package com.cocoa.shiji.worker.consumer;

import com.cocoa.shiji.bean.rate.RateDetail;
import com.cocoa.shiji.bean.rate.RateList;
import com.cocoa.shiji.bean.report.LogLevel;
import com.cocoa.shiji.bean.report.Reporter;
import com.cocoa.shiji.bean.report.ding.DingLinkType;
import com.cocoa.shiji.bean.report.ding.DingUploader;
import com.cocoa.shiji.db.MongoDb;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.util.TextUtil;
import com.cocoa.shiji.worker.Consumer;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ReportConsumer extends Consumer {


    public String dingding_host;


    public HashMap<String, String> tokenMap;

    String url_rate_list;
    MongoDb mongoDb = new MongoDb().connect();
    MongoCollection<Document> collection = mongoDb.useDbCollection("reportMsg");

    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.subExpression = p.getProperty("sub.exp.report_msg");
        this.topic = p.getProperty("mq.topic");
        this.serverUrl = p.getProperty("server.url");

        this.dingding_host = p.getProperty("dingding.host");

        tokenMap = new HashMap<>();
        for (LogLevel logLevel : LogLevel.LOGS) {
            this.tokenMap.put(logLevel.getMsg(), p.getProperty("dingding.token." + logLevel.getMsg().toLowerCase()));
        }
    }


    public ReportConsumer() {
        this.consumerGroup = TAG;
    }


    @Override
    public ConsumerStatus dispatchMsg(String msg) {

        Reporter reporter = mGson.fromJson(msg, Reporter.class);

        if (reporter == null) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "reporter format is null"));
        }

        System.out.println(reporter.toString());

        // 设置间隔时间
        synchronized (ReportConsumer.class) {
            String last_loglevel = this.tokenMap.get("last-level");
            if (!TextUtil.isEmpty(last_loglevel)) {
                if (last_loglevel.equals(reporter.getLogLevel().getMsg())) {
                    try {
                        TimeUnit.SECONDS.sleep(threadSleepSecond);
                    } catch (InterruptedException e) {
                        return new ConsumerStatus(e);
                    }
                }
            }
        }
        String jsonData = mGson.toJson(reporter);
        Document document = new Document("date", System.currentTimeMillis())
                .append("data", jsonData)
                .append("level", reporter.getLogLevel().getMsg())
                .append("num_iid", reporter.getNum_iid())
                .append("fm_date", dateFormat.format(new Date()));
        try {
            collection.insertOne(document);
        } catch (MongoWriteException e) {
            return new ConsumerStatus(e);
        }
        Object _id = document.get("_id");

        reporter.setMsgUrl(serverUrl + "report/get?id=" + _id);

        DingLinkType dingLinkType = new DingLinkType(reporter);

        DingUploader uploader = new DingUploader("link", dingLinkType);


        String message = null;
        try {

            String url = String.format(dingding_host, this.tokenMap.get(reporter.getLogLevel().getMsg()));

            message = OkHttpUtil.postRequest(url, mGson.toJson(uploader));

            this.tokenMap.put("last-level", reporter.getLogLevel().getMsg());

        } catch (Exception e) {
            return new ConsumerStatus(e);
        }

        System.out.println(message);


        return new ConsumerStatus();
    }
}

// 插入数据
//        ReportMsg reportMsg = new ReportMsg(msg, new Date(), level);
//        itemDetailService.insertOne(reportMsg, "reportMsg");
//
//        // 上传钉
//        String server_host = "";
//        try {
//            server_host = InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        reportMsg.msgUrl = String.format("http://%s:%s/product/report/get?id=%s", server_host, server_port, reportMsg._id);
//
//        String url = "";
//        if ("debug".equals(level)) {
//            url = DING_URL_DEBUG;
//        } else if ("info".equals(level)) {
//            url = DING_URL_INFO;
//        } else if ("warn".equals(level)) {
//            url = DING_URL_WARN;
//        }
//        Reporter reporter = new Reporter("link", new LinkType(reportMsg));
//
//        try {
//            OkHttpUtil.postRequest(url, mGson.toJson(reporter));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }