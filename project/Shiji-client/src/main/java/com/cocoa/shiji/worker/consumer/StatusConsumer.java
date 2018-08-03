package com.cocoa.shiji.worker.consumer;

import com.cocoa.shiji.bean.TBItemStatus;
import com.cocoa.shiji.db.MongoDb;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.util.TextUtil;
import com.cocoa.shiji.worker.Consumer;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;


import java.util.Properties;

/**
 * update shiji item status required_update to online
 */
public class StatusConsumer extends Consumer {


    String url_content_img;
    MongoDb mongoDb = new MongoDb().connect();

    public StatusConsumer() {
        this.consumerGroup = TAG;
    }


    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.serverUrl = p.getProperty("server.url");
        this.subExpression = p.getProperty("sub.exp.shiji_status");
        this.topic = p.getProperty("mq.topic");
        this.url_content_img = p.getProperty("taobao.url.content_img");

        this.dbArray[0] = p.getProperty("db.mongo.contentImg");
        this.dbArray[1] = p.getProperty("db.mongo.rateList");
        this.dbArray[2] = p.getProperty("db.mongo.itemDetail");
        this.dbArray[3] = p.getProperty("db.mongo.taoCode");
    }


    @Override
    public ConsumerStatus dispatchMsg(String msg) {


        final String num_iid = msg;

        if (TextUtil.isEmpty(num_iid)) {
            return new ConsumerStatus();
        }

        System.out.println(num_iid);

        boolean canOnLine = true;
        for (String dbName : dbArray) {
            try {
                MongoCollection<Document> collection = mongoDb.useDbCollection(dbName);
                FindIterable<Document> result = collection.find(Filters.eq("num_iid", num_iid));
                MongoCursor<Document> iter = result.iterator();
                if (iter.hasNext()) {
                    Document doc = iter.next();
                    Long date = (Long) doc.get("date");
                    if ((System.currentTimeMillis() - date) > 2 * 24 * 60 * 60 * 1000) {
                        canOnLine = false;
                        break;
                    }
                } else {
                    canOnLine = false;
                    break;
                }
            } catch (MongoWriteException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
        if (canOnLine) {
            try {
                String res = OkHttpUtil.getRequest(serverUrl + "shiji/update_status?status=online&num_iid=" + num_iid);
                System.out.println(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // report dingding
            try {
                String res = OkHttpUtil.getRequest(serverUrl + "report/add?title=StatusConsumer&num_iid=" + num_iid + "&msg=this_item_was_not_updated");
                System.out.println(res);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return new ConsumerStatus();
    }
}
