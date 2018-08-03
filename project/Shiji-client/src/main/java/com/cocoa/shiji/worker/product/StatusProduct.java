package com.cocoa.shiji.worker.product;

import com.cocoa.shiji.bean.PageContent;
import com.cocoa.shiji.bean.resp.BaseResp;
import com.cocoa.shiji.bean.sql.ShijiItem;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.worker.Product;
import com.google.gson.reflect.TypeToken;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;

public class StatusProduct extends Product {


    Type type = new TypeToken<BaseResp<PageContent>>(){}.getType();

    int page = 0;


    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.subExpression = p.getProperty("sub.exp.shiji_status");
        this.topic = p.getProperty("mq.topic");
    }

    @Override
    public void run() {
        super.run();
        DefaultMQProducer producer = new DefaultMQProducer(TAG);
        producer.setNamesrvAddr(NAME_SEV_ADDR);


        try {
            producer.start();
            Message msg = new Message(this.topic, this.subExpression, "2939922051".getBytes());
            SendResult result = producer.send(msg);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("exit");
            producer.shutdown();
        }


    }
}
