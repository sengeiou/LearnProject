package com.cocoa.shiji.worker.consumer;


import com.cocoa.shiji.bean.PageContent;
import com.cocoa.shiji.bean.resp.BaseResp;
import com.cocoa.shiji.bean.taobao.TaobaoAllResp;
import com.cocoa.shiji.bean.taobao.TaobaoRespItem;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.util.TextUtil;
import com.cocoa.shiji.worker.Consumer;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class KeywordsConsumer extends Consumer {

    public String appurl;
    public String appkey;
    public String secret;

    public static final String ADD_ITEMS = "http://localhost:8898/product/taobao/insertItems";


    static final Type type = new TypeToken<BaseResp<PageContent>>() {
    }.getType();


    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.topic = p.getProperty("mq.topic");
        this.subExpression = p.getProperty("sub.exp.keywords");
        this.appurl = p.getProperty("taobao.url");
        this.appkey = p.getProperty("taobao.appkey");
        this.secret = p.getProperty("taobao.secret");
        this.serverUrl = p.getProperty("server.url");
    }


    public KeywordsConsumer() {
        this.consumerGroup = TAG;
        this.threadSleepSecond = 1L;
        createJsonPaser();
    }

    public KeywordsConsumer(String consumerGroup, String topic, String subExpression) {
        super(consumerGroup, topic, subExpression);
        createJsonPaser();
    }


    public void createJsonPaser() {
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        mGson = builder.create();
    }


    @Override
    public ConsumerStatus dispatchMsg(String msg) {


        try {
            TimeUnit.SECONDS.sleep(threadSleepSecond);
        } catch (InterruptedException e) {
            return new ConsumerStatus(e);
        }


        String keywords = "";
        long pageIndex = 0;
        long pageSize = 100L;
        try {
            String[] array = msg.split("@@");
            keywords = array[0];
            pageIndex = Long.parseLong(array[1]);
            pageSize = Long.parseLong(array[2]);
        } catch (Exception e) {

        }

        if (TextUtil.isEmpty(keywords)) {
            return new ConsumerStatus();
        }

        System.out.println(keywords + pageIndex);
        TaobaoClient client = new DefaultTaobaoClient(appurl, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ(keywords);
//        req.setCat("21,23");
//        req.setItemloc("杭州");
        req.setSort("total_sales");  //排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);  //platform	Number	可选	1		链接形式：1：PC，2：无线，默认：１
        req.setPageNo(pageIndex);
        req.setPageSize(pageSize);
        String resp = "";
        try {
            TbkItemGetResponse rsp = client.execute(req);
            String body = rsp.getBody();
            System.out.println(body);
            if (TextUtil.isEmpty(body)) {
                return new ConsumerStatus(String.format(FORMAT_TAG, "get taobao api from TbkItemGetRequest ,json str is null"));
            }
            TaobaoAllResp taobaoAllResp = mGson.fromJson(body, TaobaoAllResp.class);
            List<TaobaoRespItem> n_tbk_item = taobaoAllResp.tbk_item_get_response.results.n_tbk_item;

            if (n_tbk_item == null) {
                return new ConsumerStatus(String.format(FORMAT_TAG, "n_tbk_item is null"));
            }

            if (n_tbk_item.size() == 0) {
                return new ConsumerStatus();
            }

            String jsonStr = mGson.toJson(n_tbk_item);
            System.out.println(jsonStr);
            String resultStr = OkHttpUtil.postRequest(ADD_ITEMS, jsonStr);

            BaseResp baseResp = mGson.fromJson(resultStr, BaseResp.class);
            if (baseResp == null || baseResp.getCode() != BaseResp.DEFAULT_CODE) {
                return new ConsumerStatus(String.format(FORMAT_TAG, "baseResp is null or error code"));
            }

        } catch (Exception e) {
            return new ConsumerStatus(e);
        }
        return new ConsumerStatus();
    }


}
