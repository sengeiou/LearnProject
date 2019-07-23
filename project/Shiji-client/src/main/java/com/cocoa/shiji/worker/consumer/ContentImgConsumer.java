package com.cocoa.shiji.worker.consumer;

import com.cocoa.shiji.bean.content_img.CIResult;
import com.cocoa.shiji.bean.content_img.CIimg;
import com.cocoa.shiji.bean.content_img.ContentDetail;
import com.cocoa.shiji.bean.content_img.ContentDetailType;
import com.cocoa.shiji.db.MongoDb;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.util.TextUtil;
import com.cocoa.shiji.worker.Consumer;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ContentImgConsumer extends Consumer {


    String url_content_img;
    MongoDb mongoDb = new MongoDb().connect();
    MongoCollection<Document> collection = mongoDb.useDbCollection("contentImg");

    public ContentImgConsumer() {
        this.consumerGroup = TAG;
    }

    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.serverUrl = p.getProperty("server.url");
        this.subExpression = p.getProperty("sub.exp.content_img");
        this.topic = p.getProperty("mq.topic");
        this.url_content_img = p.getProperty("taobao.url.content_img");
    }


    @Override
    public ConsumerStatus dispatchMsg(String msg) {

        try {
            TimeUnit.SECONDS.sleep(threadSleepSecond);
        } catch (InterruptedException e) {
            return new ConsumerStatus(e);
        }

        final String num_iid = msg;

        String url = String.format(url_content_img, num_iid);  // replace request num_iid
        String message = null;
        try {
            message = OkHttpUtil.getRequest(url);
        } catch (Exception e) {
            return new ConsumerStatus(e);
        }

        System.out.println(message);

        if (TextUtil.isEmpty(message)) {
            // 存在下架的可能
            return new ConsumerStatus(String.format(FORMAT_TAG, "content img josnStr from taobao api is null 可能存在下架"));
        }

        if (message.indexOf("mtopjsonp1(") > -1) {
            message = message.replace("mtopjsonp1(", "");
            message = message.substring(0, message.length() - 1);
        }

        CIResult ciResult = mGson.fromJson(message, CIResult.class);

        if (ciResult == null || ciResult.getData() == null) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "content img CIResult is null"));
        }
        CIimg cIimg = ciResult.getData().getWdescContent();
        if (cIimg == null) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "content img CIimg is null"));
        }

        List<String> pages = cIimg.getPages();

        List<ContentDetail> list = new ArrayList<>();

        for (int i = 0; i < pages.size(); i++) {
            String s = pages.get(i);
            ContentDetail contentDetail = new ContentDetail();
            if (s.contains(ContentDetailType.IMG.getValue())) {
                contentDetail.setType(ContentDetailType.IMG);
                if (s.contains("size")) {
                    //<img size=790x416>https://img.alicdn.com/imgextra/i3/2103369914/TB2hhkjiXXXXXbZXXXXXXXXXXXX_!!2103369914.jpg</img>
                    // 有高度宽度
                    s = s.replace("</img>", "");
                    s = s.replace("<img size=", "");

                    String[] arraySizeUrl = s.split(">");
                    if (arraySizeUrl.length > 1) {

                        contentDetail.setValue(arraySizeUrl[1]);
                        String[] arrayWidthHeight = null;
                        try {
                            arrayWidthHeight = arraySizeUrl[0].split("x");
                        } catch (Exception e) {

                        }
                        if (arrayWidthHeight != null) {
                            try {
                                contentDetail.setWidth(Integer.parseInt(arrayWidthHeight[0]));
                            } catch (NumberFormatException e) {

                            }

                            try {
                                contentDetail.setHeight(Integer.parseInt(arrayWidthHeight[1]));
                            } catch (NumberFormatException e) {

                            }
                        }
                    }


                } else {
                    s = s.replace("</img>", "");
                    s = s.replace("<img>", "");
                    contentDetail.setValue(s);
                }
            } else if (s.contains(ContentDetailType.TXT.getValue())) {
                contentDetail.setType(ContentDetailType.TXT);
                s = s.replace("</txt>", "");
                s = s.replace("<txt>", "");
                contentDetail.setValue(s);
            }
            list.add(contentDetail);
        }


        String jsonData = mGson.toJson(list);

        String _id = num_iid;
        Document document = new Document("_id", _id)
                .append("data", jsonData)
                .append("fm_date", dateFormat.format(new Date()))
                .append("num_iid", num_iid)
                .append("date", System.currentTimeMillis());

        try {
            collection.insertOne(document);
        } catch (MongoWriteException e) {
            document = null;
            try {
                Bson updtaeBsons = Updates.combine(Updates.set("fm_date", dateFormat.format(new Date())),
                        Updates.set("date", System.currentTimeMillis()),
                        Updates.set("data", jsonData)
                );
                collection.updateOne(Filters.eq("_id", _id),
                        updtaeBsons);
            } catch (Exception e2) {
                return new ConsumerStatus(e);
            }
        }

        return new ConsumerStatus();
    }
}
