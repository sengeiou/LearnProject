package com.cocoa.rmq_client.worker;


import com.cocoa.rmq_client.bean.PageContent;
import com.cocoa.rmq_client.bean.client.BaseParams;
import com.cocoa.rmq_client.bean.client.BasicParams;
import com.cocoa.rmq_client.bean.client.InsertParams;
import com.cocoa.rmq_client.bean.h5.H5apiData;
import com.cocoa.rmq_client.bean.h5.H5apiItem;
import com.cocoa.rmq_client.bean.h5.H5apiJson;
import com.cocoa.rmq_client.bean.h5.H5apiStackValue;
import com.cocoa.rmq_client.bean.resp.BaseResp;
import com.cocoa.rmq_client.bean.sql.ShijiItem;
import com.cocoa.rmq_client.util.H5apiUtil;
import com.cocoa.rmq_client.util.OkHttpUtil;
import com.cocoa.rmq_client.util.TextUtil;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertWorker extends BaseWorker {

    public InsertParams insertParams;

    public InsertWorker(BasicParams basicParams, BaseParams baseParams) {
        this.basicParams = basicParams;
        this.params = baseParams;
        this.insertParams = (InsertParams) baseParams;


        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        mGson = builder.create();
    }

    Map<String, Object> requestParams = new HashMap<>();
    public Gson mGson;
    Type type = new TypeToken<BaseResp<PageContent>>() {
    }.getType();

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                // get items where status == "prepared"
                requestParams.put("size", 20);
                requestParams.put("page", 0);
                requestParams.put("status", insertParams.getListParamsStatus());
                String taobaoItemStr = OkHttpUtil.getRequest(basicParams.getBaseUrl() + insertParams.getListUrl(), requestParams);
                System.out.println(taobaoItemStr);
//                report("get tabaoke api");

                BaseResp<PageContent> baseResp = mGson.fromJson(taobaoItemStr, type);
                if (baseResp == null || baseResp.getData() == null || baseResp.getData().getContent() == null) {
                    Thread.sleep(1000 * 10 * 6);
                    continue;
                }
                List<ShijiItem> shijiItems = baseResp.getData().getContent();
                int size = shijiItems.size();
                if (size == 0) {
                    Thread.sleep(1000 * 10 * 6);
                    continue;
                }
                ShijiItem item = null;
                for (int i = 0; i < size; i++) {
                    Thread.sleep(insertParams.getSleepTime() * 1000);
                    try {
                        item = shijiItems.get(i);
                        String id = item.getNum_iid();

                        System.out.println("start=====> " + i);
                        System.out.println(id);
                        String message = H5apiUtil.getH5Data(id);
                        System.out.println(message);
                        H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
                        H5apiData h5data = h5apiJson.getData();
                        H5apiItem h5apiItem = h5data.item;
                        if (h5apiItem != null) {
                            item.setNum_iid(h5apiItem.itemId);
                            item.setTitle(h5apiItem.title);
                        }
                        item.setRate(mGson.toJson(h5data.rate));

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
                            if (TextUtil.isEmpty(h5apiStackValue.item.sellCount)) {
                                System.out.println(h5apiStackValue.item.sellCount);
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
                        item.setSales_update_time(new Date());
                        String msg = OkHttpUtil.postRequest(basicParams.getBaseUrl() + insertParams.getInsertUrl(), mGson.toJson(item));
                        System.out.println(msg);
                        if (TextUtil.isEmpty(msg)) {
                            report("response message is null");
                            continue;
                        }

                        BaseResp insertResp = mGson.fromJson(msg, BaseResp.class);

                        if (insertResp.getCode() == BaseResp.DEFAULT_CODE) {

                            requestParams.put("num_iid", id);
                            requestParams.put("status", insertParams.getUpdateParamsStatus());

                            String result = OkHttpUtil.getRequest(basicParams.getBaseUrl() + insertParams.getUpdateUrl(), requestParams);
                            System.out.println(result);
                        } else {
                            report(insertResp.getMsg());
                        }
                    } catch (Exception e) {
                        report(e);
                    }
                }
            } catch (Exception e) {
                report(e);
            }

        }
    }
}
