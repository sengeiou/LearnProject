package com.cocoa.shiji.worker.consumer;

import com.cocoa.shiji.bean.rate.RateDetail;
import com.cocoa.shiji.bean.rate.RateList;
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

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RateListConsumer extends Consumer {


    String url_rate_list ;
    MongoDb mongoDb = new MongoDb().connect();
    MongoCollection<Document> collection = mongoDb.useDbCollection("rateList");

    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.subExpression = p.getProperty("sub.exp.rate_list");
        this.topic = p.getProperty("mq.topic");
        this.url_rate_list = p.getProperty("taobao.url.rate_list");
        this.serverUrl = p.getProperty("server.url");
    }

    public RateListConsumer() {
        this.consumerGroup = TAG;
    }

    @Override
    public ConsumerStatus dispatchMsg(String msg) {


        System.out.println(toString());

        String num_iid = msg;

        try {
            TimeUnit.SECONDS.sleep(threadSleepSecond);
        } catch (InterruptedException e) {
            return new ConsumerStatus(e);
        }
        String url = String.format(url_rate_list, num_iid);  // replace request num_iid

        String message = null;
        try {
            message = OkHttpUtil.getRequest(url);
        } catch (Exception e) {
            return new ConsumerStatus(e);
        }

        System.out.println(message);

        if (TextUtil.isEmpty(message)) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "message is null"));
        }

        if (message.indexOf("\"rateDetail\":") > -1) {
            message = message.replace("\"rateDetail\":", "");
        }
        while (message.contains("\"pics\":\"\"")) {  // when pics is empty, the json value will be string "" , `so replace to array []
            message = message.replace("\"pics\":\"\"", "\"pics\": []");
        }

        //error msg
//            {"rgv587_flag":"sm","url":"https://sec.taobao.com/query.htm?action=QueryAction&event_submit_do_css=ok&smApp=tmallrateweb&smPolicy=tmallrateweb-rate-anti_Spider-checklogin&smCharset=GBK&smTag=MTE1LjIwNC4xNTQuMTEsLGY0ZTc5MjJmNzVlNDRkYjg5NDViNjU0ZGRjMTA0MDc3&smReturn=https%3A%2F%2Frate.tmall.com%2Flist_detail_rate.htm%3Ftbpm%3D3%26itemId%3D524771024967%26sellerId%3D2455221099%26currentPage%3D1%26pageSize%3D30&smSign=%2BYglw5UrXabS82tenP2fYw%3D%3D"}

        System.out.println("==>" + message);

        RateList rateList = mGson.fromJson(message, RateList.class);

        if (rateList == null) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "rateList is null"));
        }
        List<RateDetail> mList = rateList.getRateList();
        if (mList == null || mList.size() == 0) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "List<RateDetail> is null or null"));
        }

        String jsonData = mGson.toJson(mList);
        String _id =  num_iid;
        Document document = new Document("_id", _id)
                .append("num_iid", num_iid)
                .append("data", jsonData)
                .append("fm_date", dateFormat.format(new Date()))
                .append("date", System.currentTimeMillis());

        try {
            collection.insertOne(document);
        } catch (MongoWriteException e) {
            document = null;
            try {
                Bson updtaeBsons = Updates.combine(Updates.set("fm_date", dateFormat.format(new Date())),
                        Updates.set("date", System.currentTimeMillis())
                        , Updates.set("data", jsonData));
                collection.updateOne(Filters.eq("_id", _id),
                        updtaeBsons);
            }catch (Exception e1){
                return new ConsumerStatus(e);
            }
        }

        return new ConsumerStatus();
    }
}