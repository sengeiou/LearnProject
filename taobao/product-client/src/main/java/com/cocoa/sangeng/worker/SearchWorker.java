package com.cocoa.sangeng.worker;

import com.cocoa.sangeng.bean.client.BaseParams;
import com.cocoa.sangeng.bean.client.BasicParams;
import com.cocoa.sangeng.bean.client.SearchParams;
import com.cocoa.sangeng.bean.h5.H5apiData;
import com.cocoa.sangeng.bean.h5.H5apiItem;
import com.cocoa.sangeng.bean.h5.H5apiJson;
import com.cocoa.sangeng.bean.h5.H5apiStackValue;
import com.cocoa.sangeng.bean.resp.BaseResp;
import com.cocoa.sangeng.bean.sql.CommitItem;
import com.cocoa.sangeng.bean.taobao.TaobaoAllResp;
import com.cocoa.sangeng.bean.taobao.TaobaoItem;
import com.cocoa.sangeng.util.H5apiUtil;
import com.cocoa.sangeng.util.OkHttpUtil;
import com.cocoa.sangeng.util.TextUtil;
import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchWorker extends BaseWorker {

    private SearchParams searchParams;

    public SearchWorker(BasicParams basicParams, BaseParams params) {
        this.basicParams = basicParams;
        this.params = params;
        searchParams = (SearchParams) params;
        currentIndex = searchParams.getPageIndex();
    }

    private int currentIndex = 0;
    Map<String, Object> requestParams = new HashMap<>();
    public Gson mGson = new Gson();

    @Override
    public void run() {
        super.run();

        while (true) {
            try {
                if (currentIndex > searchParams.getMaxPageIndex()) {
                    report("has been maxsize");
                }
                requestParams.put("pageSize", searchParams.getPageSize());
                requestParams.put("pageIndex", currentIndex);
                requestParams.put("keywords", searchParams.getKeywords());
                String taobaoItemStr = OkHttpUtil.getRequest(basicParams.getBaseUrl() + searchParams.getListUrl(), requestParams);

                report("get tabaoke api");
                TaobaoAllResp taobaoAllResp = new Gson().fromJson(taobaoItemStr, TaobaoAllResp.class);

                currentIndex++;
                searchParams.setCurrntIndex(currentIndex);

                List<TaobaoItem> itemList = taobaoAllResp.tbk_item_get_response.results.n_tbk_item;
                CommitItem item = null;
                for (int i = 0; i < itemList.size(); i++) {
                    Thread.sleep(searchParams.getSleepTime() * 1000);
                    try {
                        // 查询数据，更新taobao 库
                        String id = itemList.get(i).num_iid;
                        item = new CommitItem();
                        System.out.println("start=====> " + i);
                        System.out.println(id);
                        String message = H5apiUtil.getH5Data(id);
                        System.out.println(message);
                        H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
                        H5apiData h5data = h5apiJson.getData();
                        H5apiItem h5apiItem = h5data.item;

                        item.setNum_iid(h5apiItem.itemId);
                        item.setTitle(h5apiItem.title);
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
                        item.setSales_update_time(new Date());
                        item.setCreate_time(new Date());
                        item.setSearch_kw(searchParams.getKeywords());
                        String msg = OkHttpUtil.postRequest(basicParams.getBaseUrl() + searchParams.getUpdateUrl(), mGson.toJson(item));

                        if (TextUtil.isEmpty(msg)) {
                            report("response message is null");
                            continue;
                        }

                        BaseResp baseResp = mGson.fromJson(msg, BaseResp.class);

                        if (baseResp.getCode() == BaseResp.DEFAULT_CODE) {
//                            report("normal message", "one item has been add");
                        } else {
                            report(baseResp.getMsg());
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
