package com.cocoa.sangeng;

import com.cocoa.sangeng.bean.client.BasicParams;
import com.cocoa.sangeng.bean.client.BasicRespData;
import com.cocoa.sangeng.bean.client.InsertParams;
import com.cocoa.sangeng.bean.client.SearchParams;
import com.cocoa.sangeng.bean.resp.BaseResp;
import com.cocoa.sangeng.util.OkHttpUtil;
import com.cocoa.sangeng.util.TextUtil;
import com.cocoa.sangeng.worker.InsertWorker;
import com.cocoa.sangeng.worker.SearchWorker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

//tengxun  118.126.66.230    !     2018-07   RMB120   1核2G、1M带宽
//jd       116.196.79.208    ?      2018-09   RMB188  1核2G
// aliyun   120.79.51.243     ?      2018-11   RMB330  1核1G



public class Main {

    public static final String BASE_URL = "http://127.0.0.1:8898";
//    public static final String BASE_URL = "http://116.196.79.208:8898";

    public static void main(String[] args) {




        try {

            String jsonStr = OkHttpUtil.getRequest(BASE_URL + "/product/client");

            if (TextUtil.isEmpty(jsonStr)) {
                Thread.sleep(1000 * 60 * 30);
//                    continue;
            }

            Type type = new TypeToken<BaseResp<BasicRespData>>() {
            }.getType();

            BaseResp<BasicRespData> baseResp = new Gson().fromJson(jsonStr, type);
            BasicRespData data = null;
            if (baseResp != null && (data = baseResp.getData()) != null) {
                BasicParams basicParams = data.getBasicParams();
                basicParams.setBaseUrl(BASE_URL);

                SearchWorker searchWorker = new SearchWorker(basicParams, data.getSearchParams());
                searchWorker.start();

                InsertWorker insertWorker = new InsertWorker(basicParams, data.getInsertParams());
                insertWorker.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        ShijiItem shijiItem = null;
//        try {
////            Test t = mGson.fromJson(ttMsg,Test.class);
//
//            String taobaoItemStr = OkHttpUtil.getRequest(ITEM_URL);
//            TaobaoAllResp taobaoAllResp = new Gson().fromJson(taobaoItemStr, TaobaoAllResp.class);
//
//            List<TaobaoItem> item = taobaoAllResp.tbk_item_get_response.results.n_tbk_item;
//
//            for (int i = 0; i < item.size(); i++) {
//                String id = item.get(i).num_iid;
//                shijiItem = new ShijiItem();
//                System.out.println("start=====> " + i);
//                System.out.println(id);
//                String message = H5apiUtil.getH5Data(id);
//                System.out.println(message);
//                H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
//                H5apiData h5data = h5apiJson.getData();
//                H5apiItem h5apiItem = h5data.item;
//
//                shijiItem.setNum_iid(h5apiItem.itemId);
//                shijiItem.setTitle(h5apiItem.title);
//                shijiItem.setRate(mGson.toJson(h5data.rate));
//
//                if (h5apiItem.images != null && h5apiItem.images.length > 0) {
//                    StringBuilder sb = new StringBuilder();
//                    for (String url : h5apiItem.images) {
//                        sb.append(url + "@@");
//                    }
//                    shijiItem.setSmall_img(sb.toString().substring(0, sb.length() - 2));
//                    shijiItem.setPict_url(h5apiItem.images[0]);
//                }
//                // 设置店铺昵称
//                String shopName = h5data.seller.shopName;
//                if (!TextUtil.isEmpty(shopName)) {
//                    shijiItem.setNick(shopName);
//                } else {
//                    shijiItem.setNick(h5data.seller.sellerNick);
//                }
//                String apiStackVlaue = h5data.apiStack[0].getValue();
//                H5apiStackValue h5apiStackValue = mGson.fromJson(apiStackVlaue, H5apiStackValue.class);
//                shijiItem.setProvcity(h5apiStackValue.delivery.from);
//                //tmall supermarket product. the params <item> maybe equals null
//                if (h5apiStackValue.item != null) {
//                    shijiItem.setVolume(h5apiStackValue.item.sellCount);
//                    System.out.println(h5apiStackValue.item.sellCount);
//                    shijiItem.setSales(Integer.parseInt(h5apiStackValue.item.sellCount));
//                }
//                shijiItem.setZk_final_price(h5apiStackValue.price.price.priceText);
//                // tmall 商品可能出现 原价 为空的情况，这里需要注意
//                if (h5apiStackValue.price.extraPrices != null) {
//                    if (h5apiStackValue.price.extraPrices.length > 0) {
//                        shijiItem.setReserve_price(h5apiStackValue.price.extraPrices[0].priceText);
//                    }
//                }
//                shijiItem.setSales_update_time(new Date());
//                shijiItem.setCreate_time(new Date());
//
//                String msg = OkHttpUtil.postRequest(INSERT_URL, mGson.toJson(shijiItem));
//                System.out.println(msg);
//                System.out.println("--------");
//                Thread.sleep(1000 * 5);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }

    }
}
