package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.h5.H5apiData;
import com.cocoa.taobao.product_server.bean.h5.H5apiItem;
import com.cocoa.taobao.product_server.bean.h5.H5apiJson;
import com.cocoa.taobao.product_server.bean.h5.H5apiStackValue;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.dao.ShijiDao;
import com.cocoa.taobao.product_server.dao.TaobaoDao;
import com.cocoa.taobao.product_server.impl.ShijiServiceImpl;
import com.cocoa.taobao.product_server.impl.TaobaoServiceImpl;
import com.cocoa.taobao.product_server.util.H5apiUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("shiji")
public class ShijiController {


    public static final Gson mGson = new Gson();

    @Autowired
    private BaseResp baseResp;

    @Autowired
    public ShijiServiceImpl shijiService;


    /**
     * 通过淘宝 api 过来的数据, 去查询 h5 api 后，获取更多的信息（评论相关）入库
     * @param map  item : taobao_item的 json
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/additem_tb")
    public String addShijiFromTB(@RequestBody Map map) {
        String item = map.get("item").toString();
        System.out.println(item);
        ShijiItem shijiItem = mGson.fromJson(item, ShijiItem.class);
        String num_iid = shijiItem.getNum_iid();
        int result = 0;
        try {

            String message = H5apiUtil.getH5Data(num_iid);
            H5apiJson json = mGson.fromJson(message, H5apiJson.class);
            String resultMsg = json.getData().rate.toString();
            shijiItem.setRate(resultMsg);
            result = shijiService.addItem(shijiItem);

        } catch (Exception e) {
        }
        if (1 == result) {
            baseResp.setResultOK();
        } else {
            baseResp.setError(100, "error");
        }
        return mGson.toJson(baseResp);
    }

    /**
     * 根据商品的id， 查询 h5 api 后入库
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/additem_id")
    public String addShijiFromId(String id) {
        ShijiItem shijiItem = null;
        int result = 0;
        try {

            String message = H5apiUtil.getH5Data(id);
            H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
            H5apiData h5data = h5apiJson.getData();
            H5apiItem h5apiItem = h5data.item;

            shijiItem = new ShijiItem();
            shijiItem.setNum_iid(h5apiItem.itemId);
            shijiItem.setTitle(h5apiItem.title);
            shijiItem.setRate(mGson.toJson(h5data.rate));

            if (h5apiItem.images != null && h5apiItem.images.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (String url : h5apiItem.images) {
                    sb.append(url + "@@");
                }
                shijiItem.setSmall_img(sb.toString().substring(0, sb.length() - 2));
                shijiItem.setPict_url(h5apiItem.images[0]);
            }
            shijiItem.setNick(h5data.seller.shopName);

            String apiStackVlaue = h5data.apiStack[0].getValue();
            H5apiStackValue h5apiStackValue = mGson.fromJson(apiStackVlaue, H5apiStackValue.class);
            shijiItem.setProvcity(h5apiStackValue.delivery.from);
            shijiItem.setVolume(h5apiStackValue.item.sellCount);
            shijiItem.setSales(Integer.parseInt(h5apiStackValue.item.sellCount));
            shijiItem.setZk_final_price(h5apiStackValue.price.price.priceText);
            // tmall 商品可能出现 原价 为空的情况，这里需要注意
            if(h5apiStackValue.price.extraPrices!=null) {
                if (h5apiStackValue.price.extraPrices.length > 0) {
                    shijiItem.setReserve_price(h5apiStackValue.price.extraPrices[0].priceText);
                }
            }

            result = shijiService.addItem(shijiItem);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        if (1 == result) {
            baseResp.setResultOK();
        } else {
            baseResp.setError(100, "error");
        }

        return mGson.toJson(baseResp);
    }


}
