package com.cocoa.shiji.worker.product;

import com.cocoa.shiji.bean.PageContent;
import com.cocoa.shiji.bean.resp.BaseResp;
import com.cocoa.shiji.bean.sql.ShijiItem;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.worker.BaseWorker;
import com.cocoa.shiji.worker.Product;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ContentImgProduct extends Product {


    Type type = new TypeToken<BaseResp<PageContent>>() {
    }.getType();

    int page = 0;


    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.subExpression = p.getProperty("sub.exp.content_img");
        this.topic = p.getProperty("mq.topic");
    }


    public void sendMsg(String num_iid) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(TAG);
        producer.setNamesrvAddr(NAME_SEV_ADDR);
        producer.start();
        Message msg = new Message(this.topic, this.subExpression, num_iid.getBytes());
        SendResult result = producer.send(msg);
    }

    @Override
    public void run() {
        super.run();
        DefaultMQProducer producer = new DefaultMQProducer(TAG);
        producer.setNamesrvAddr(NAME_SEV_ADDR);
        try {
            producer.start();
            while (true) {
                String jsonStr = OkHttpUtil.getRequest("http://youweier77.com/product/shiji/getItems?status=1&size=20&page=" + page);

                BaseResp baseResp = mGson.fromJson(jsonStr, type);
                if (baseResp == null || baseResp.getData() == null) {
                    break;
                }
                PageContent pageContent = (PageContent) baseResp.getData();

                if (pageContent == null) {
                    break;
                }
                List<ShijiItem> mList = pageContent.getContent();

                if (mList == null || mList.size() == 0) {
                    break;
                }

                for (ShijiItem shijiItem : mList) {
                    Message msg = new Message(this.topic, this.subExpression, shijiItem.getNum_iid().getBytes());
                    SendResult result = producer.send(msg);
                }
                page++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }


    }
}
