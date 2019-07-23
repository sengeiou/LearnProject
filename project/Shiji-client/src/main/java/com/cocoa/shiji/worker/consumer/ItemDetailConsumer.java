package com.cocoa.shiji.worker.consumer;

import com.cocoa.shiji.bean.h5.H5apiData;
import com.cocoa.shiji.bean.h5.H5apiItem;
import com.cocoa.shiji.bean.h5.H5apiJson;
import com.cocoa.shiji.bean.h5.H5apiStackValue;
import com.cocoa.shiji.bean.sql.ItemDetail;
import com.cocoa.shiji.db.MongoDb;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.cocoa.shiji.util.TextUtil;
import com.cocoa.shiji.worker.Consumer;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ItemDetailConsumer extends Consumer {


    MongoDb mongoDb = new MongoDb().connect();
    MongoCollection<Document> collection = mongoDb.useDbCollection("itemDetail");


    public String DEFAULT_CONSUMER_GROUP = TAG;
    public String url_item_detail;

    public ItemDetailConsumer() {
        this.consumerGroup = DEFAULT_CONSUMER_GROUP;
    }


    @Override
    public void initPropreties() {
        Properties p = PropretyUtil.getPps();
        this.subExpression = p.getProperty("sub.exp.item_detail");
        this.topic = p.getProperty("mq.topic");
        this.url_item_detail = p.getProperty("taobao.url.item_detail");
        this.serverUrl = p.getProperty("server.url");
    }


    @Override
    public ConsumerStatus dispatchMsg(String msg) {
        final String num_iid = msg;
        try {
            TimeUnit.SECONDS.sleep(threadSleepSecond);
        } catch (InterruptedException e) {
            return new ConsumerStatus(e);
        }

        String message = null;


        String apiUrl = url_item_detail.replace("@@", num_iid);
        apiUrl = apiUrl.replace("@@", num_iid);


        try {
            message = OkHttpUtil.getRequest(apiUrl);
        } catch (Exception e) {
            return new ConsumerStatus(e);
        }
        System.out.println(num_iid + message);

        if (TextUtil.isEmpty(message)) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "message is null"));
        }

        if (message.indexOf("expired") > -1 && message.indexOf("") > -1) {
            // 商品过期，
            // 提交 api 请求
            try {
                OkHttpUtil.getRequest(serverUrl + "shiji/update_status?status=expird&num_iid=" + num_iid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ConsumerStatus();
        }

        if (message.indexOf("mtopjsonp1(") > -1) {
            message = message.replace("mtopjsonp1(", "");
            message = message.substring(0, message.length() - 1);
        }

        H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
        H5apiData h5data = h5apiJson.getData();
        H5apiItem h5apiItem = h5data.item;

        if (h5apiItem == null) {
            return new ConsumerStatus(String.format(FORMAT_TAG, "h5apiItem is null"));
        }

        ItemDetail item = new ItemDetail();

        item.setNum_iid(h5apiItem.itemId);
        item.setTitle(h5apiItem.title);
        item.rate = h5data.rate;

        if (h5apiItem.images != null && h5apiItem.images.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String url : h5apiItem.images) {
                sb.append(url + "@@");
            }
            item.setSmall_img(sb.toString().substring(0, sb.length() - 2));
            item.setPict_url(h5apiItem.images[0]);
        }
        // 设置店铺昵称
        String shopName = h5data.seller.shopName;
        if (!TextUtil.isEmpty(shopName)) {
            item.setNick(shopName);
        } else {
            item.setNick(h5data.seller.sellerNick);
        }
        String apiStackVlaue = h5data.apiStack[0].getValue();
        H5apiStackValue h5apiStackValue = mGson.fromJson(apiStackVlaue, H5apiStackValue.class);
        item.setProvcity(h5apiStackValue.delivery.from);
        //tmall supermarket product. the params <item> maybe equals null
        if (h5apiStackValue.item != null) {
            item.setVolume(h5apiStackValue.item.sellCount);
            System.out.println(h5apiStackValue.item.sellCount);
            if (!TextUtil.isEmpty(h5apiStackValue.item.sellCount)) {
                item.setSales(Integer.parseInt(h5apiStackValue.item.sellCount));
            }
        }
        item.setZk_final_price(h5apiStackValue.price.price.priceText);
        // tmall 商品可能出现 原价 为空的情况，这里需要注意
        if (h5apiStackValue.price.extraPrices != null) {
            if (h5apiStackValue.price.extraPrices.length > 0) {
                item.setReserve_price(h5apiStackValue.price.extraPrices[0].priceText);
            }
        }

        //http://127.0.0.1:8898/product/shiji/update_sales?num_iid=561129700290&sales=222222
//        update sales   sales and Volume has different value

        try {
            String volumeStr = item.getVolume();
            if (!TextUtil.isEmpty(volumeStr)) {
                OkHttpUtil.getRequest(serverUrl + "shiji/update_sales?num_iid=" + num_iid + "&sales=" + volumeStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Date currentDate = new Date();

        item.setSales_update_time(currentDate);
        item.setCreate_time(currentDate);

        String jsonData = mGson.toJson(item);

        String _id = dateFormatWhitHyphen.format(currentDate) + num_iid;
        Document document = new Document("_id", _id)
                .append("num_iid", num_iid)
                .append("data", jsonData)
                .append("fm_date", dateFormat.format(new Date()))
                .append("date", System.currentTimeMillis());
        try {
            collection.insertOne(document);
        } catch (Exception e) {
            document = null;
            try {
                Bson updtaeBsons = Updates.combine(Updates.set("fm_date", dateFormat.format(new Date())),
                        Updates.set("date", System.currentTimeMillis())
                        , Updates.set("data", jsonData));
                collection.updateOne(Filters.eq("_id", _id),
                        updtaeBsons);
            } catch (Exception e1) {
                return new ConsumerStatus(e1);
            }
        }

        return new ConsumerStatus();

    }


}
