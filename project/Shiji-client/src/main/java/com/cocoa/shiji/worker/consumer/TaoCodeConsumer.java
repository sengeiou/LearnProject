package com.cocoa.shiji.worker.consumer;

import com.cocoa.shiji.bean.PageContent;
import com.cocoa.shiji.bean.resp.BaseResp;
import com.cocoa.shiji.bean.sql.ShijiItem;
import com.cocoa.shiji.bean.taocode.TaoCode;
import com.cocoa.shiji.bean.taocode.TaoCodeResult;
import com.cocoa.shiji.db.MongoDb;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.util.TextUtil;
import com.cocoa.shiji.worker.Consumer;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.WirelessShareTpwdCreateRequest;
import com.taobao.api.response.WirelessShareTpwdCreateResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TaoCodeConsumer extends Consumer {

    public String appurl;
    public String appkey;
    public String secret;
    public String url_rate_list;
    MongoDb mongoDb = new MongoDb().connect();
    MongoCollection<Document> collection = mongoDb.useDbCollection("taoCode");

    Type type = new TypeToken<BaseResp<PageContent>>() {
    }.getType();

    int page = -1;

    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.subExpression = p.getProperty("sub.exp.tao_code");
        this.topic = p.getProperty("mq.topic");
        this.url_rate_list = p.getProperty("taobao.url.tao_code");
        this.appurl = p.getProperty("taobao.url");
        this.appkey = p.getProperty("taobao.appkey");
        this.secret = p.getProperty("taobao.secret");
        this.serverUrl = p.getProperty("server.url");
    }

    public TaoCodeConsumer() {
        this.consumerGroup = TAG;
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                    JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        mGson = builder.create();
    }

    @Override
    public ConsumerStatus dispatchMsg(String msg) {

        String taokeToken = msg;   // 这里的msg 是 淘宝客网站的 token

        if (taokeToken.length() < 20) {
            return new ConsumerStatus();
        }

        while (true) {
            String jsonStr = null;
            page++;
            try {
                jsonStr = OkHttpUtil.getRequest(serverUrl + "/shiji/getAllItems?size=10&page=" + page);
                System.out.println(jsonStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            BaseResp baseResp = mGson.fromJson(jsonStr, type);
            if (baseResp == null || baseResp.getData() == null) {
                continue;
            }
            PageContent pageContent = (PageContent) baseResp.getData();

            if (pageContent == null) {
                page = -1;
                break;
            }
            List<ShijiItem> mList = pageContent.getContent();

            if (mList == null || mList.size() == 0) {
                break;
            }

            for (ShijiItem shijiItem : mList) {


                try {
                    TimeUnit.SECONDS.sleep(threadSleepSecond);
                } catch (InterruptedException e) {

                }

                if (shijiItem.getStatus() > 100 || shijiItem.getStatus() < 1) {
                    continue;
                }

                String num_iid = shijiItem.getNum_iid();

                String url = String.format(url_rate_list, num_iid);  // replace request num_iid

                String message = "";
                System.out.println(num_iid);
                Bson filter = Filters.eq("num_iid", num_iid);
                FindIterable<Document> result = collection.find(filter).sort(new BasicDBObject("date", -1));

                MongoCursor<Document> iterator = result.iterator();
                if (iterator.hasNext()) {
                    Document document = iterator.next();
                    Long date = (Long) document.get("date");
                    if ((System.currentTimeMillis() - date) < (10 * 24 * 60 * 60 * 1000)) {
                        // 创建时间距离本次还没有到10天，则消费任务
                        continue;
                    }
                }

                try {
                    final OkHttpClient client = new OkHttpClient();

                    Request.Builder requestBuild = new Request.Builder()
                            .header("Content-Type", "application/json;charset=UTF-8")
                            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                            .url(url);
                    requestBuild = requestBuild.addHeader("Cookie", taokeToken);

                    message = OkHttpUtil.getRequest(requestBuild.build());
                } catch (Exception e) {
                    continue;
                }


                System.out.println(message);

                if (TextUtil.isEmpty(message)) {
                    return new ConsumerStatus(String.format(FORMAT_TAG, "taocode jsonstr from taobao api is null"));
                }

                if (message.contains("gen url item not found on call") || message.contains("宝贝失效")) {
                    // 商品下架
                    try {
                        OkHttpUtil.getRequest(serverUrl + "shiji/update_status?status=expird&num_iid=" + num_iid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                TaoCodeResult taoCodeResult = mGson.fromJson(message, TaoCodeResult.class);

                if (taoCodeResult == null || taoCodeResult.getData() == null) {
                    continue;
                }
                TaoCode taoCode = taoCodeResult.getData();

                if (taoCode == null) {
                    continue;
                }

                String jsonData = mGson.toJson(taoCode);

                Document document = new Document("_id", num_iid)
                        .append("num_iid", num_iid)
                        .append("data", jsonData)
                        .append("fm_date", dateFormat.format(new Date()))
                        .append("date", System.currentTimeMillis());

                try {
                    collection.insertOne(document);
                } catch (MongoWriteException e) {
                    document = null;
                    try {
                        Bson updtaeBsons = Updates.combine(
                                Updates.set("fm_date", dateFormat.format(new Date())),
                                Updates.set("date", System.currentTimeMillis()),
                                Updates.set("data", jsonData)
                        );
                        collection.updateOne(Filters.eq("_id", num_iid),
                                updtaeBsons);
                    } catch (Exception e1) {

                    }
                }
            }
        }
        return new ConsumerStatus(String.format(FORMAT_TAG, "final"));
    }
}

//            官方api 返回错误。自己生成code
//            taoCode = new TaoCode();
//
//            try {
//                TaobaoClient client = new DefaultTaobaoClient(appurl, appkey, secret);
//                WirelessShareTpwdCreateRequest req = new WirelessShareTpwdCreateRequest();
//                WirelessShareTpwdCreateRequest.GenPwdIsvParamDto obj1 = new WirelessShareTpwdCreateRequest.GenPwdIsvParamDto();
//                obj1.setLogo("https://img.alicdn.com/tps/TB1EdnZKpXXXXc9XpXXXXXXXXXX-592-236.png");
//                obj1.setUrl("http://item.taobao.com/item.htm?id=" + num_iid);
//                obj1.setText("超值活动，惊喜活动多多");
//                obj1.setUserId(1071473899L);
//                req.setTpwdParam(obj1);
//                WirelessShareTpwdCreateResponse rsp = client.execute(req);
//                System.out.println(rsp.getBody());
//                String model = rsp.getModel();
//                if (!TextUtil.isEmpty(model)) {
//                    taoCode.setTaoToken(model);
//                    taoCode.setTKCode(false);
//                    System.out.println(taoCode.toString());
//                } else {
//                    taoCode = null;
//                }
//            } catch (Exception e) {
//                return new ConsumerStatus(e);
//            }