package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.h5.H5apiData;
import com.cocoa.taobao.product_server.bean.h5.H5apiItem;
import com.cocoa.taobao.product_server.bean.h5.H5apiJson;
import com.cocoa.taobao.product_server.bean.h5.H5apiStackValue;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.impl.ShijiServiceImpl;
import com.cocoa.taobao.product_server.impl.TaobaoServiceImpl;
import com.cocoa.taobao.product_server.util.H5apiUtil;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value ="/shiji")
@Api(value = "db shiji_item的相关操作", description = "主要有两个插入：1.从ProductController获取信息后，在调用H5 api 入库 \r\n" +
        "2.根据商品的id 调用H5 api 后入库")
public class SjController {

    public static final Gson mGson = new Gson();

    @Autowired
    private BaseResp baseResp;

    @Autowired
    public ShijiServiceImpl shijiService;

    @Autowired
    public TaobaoServiceImpl taobaoService;

    @Value("${httpparams.default.pagesize}")
    private int defaultPageSize;
    @Value("${httpparams.default.pageindex}")
    private int defaultPageIndex;

    /**
     * @param
     * @return
     */
    @ApiOperation(value = "通过淘宝 api 过来的数据", notes = "这个方法要优化")
    @RequestMapping(method = RequestMethod.POST, value = "/additem")
    public BaseResp addShijiFromTB(@RequestBody String json) {

        if (TextUtil.isEmpty(json)) {
            return baseResp.setError(100, "body data is null");
        }
        ShijiItem shijiItem = mGson.fromJson(json, ShijiItem.class);

        ShijiItem dbItem = shijiService.getItem(shijiItem.getNum_iid());

        if (dbItem == null) {
            shijiItem = shijiService.saveAndUpdate(shijiItem);
        } else {
            return baseResp.setError(100, "item has been added");
        }
        if (null != shijiItem) {
            baseResp.setResultOK();
            baseResp.setData(shijiItem);
        } else {
            baseResp.setError(100, "error");
        }

//        BaseItem baseItem = shijiService.getItem(num_iid);
//        if (baseItem != null) {
//            return baseResp.setError(100, "item has been added");
//        }
//        ShijiItem result = null;
//        try {
//            BaseItem taobaoItem = taobaoService.getItem(num_iid);
//            ShijiItem shijiItem = mGson.fromJson(mGson.toJson(taobaoItem),ShijiItem.class);
//            result = shijiService.saveAndUpdate(shijiItem);
//        } catch (Exception e) {
//            return baseResp.setError(100, e.toString());
//        }
//        if (null != result) {
//            taobaoService.updateStatus(num_iid, TBItemStatus.INSERTED.getValue());
//            baseResp.setResultOK();
//            baseResp.setData(result);
//        } else {
//            baseResp.setError(100, "error");
//        }
        return baseResp;
    }

    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/getitem")
    public BaseResp getItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
        ShijiItem shijiItem = shijiService.getItem(num_iid);
        if (shijiItem != null) {
            return baseResp.setResultOK().setData(shijiItem);
        } else {
            return baseResp.setError(100, "error");
        }
    }


    @ApiOperation(value = "获取商品", notes = "根据关键字分页获取推荐的商品")
    @RequestMapping(method = RequestMethod.GET, value = "/getItems")
    public BaseResp getItems(@RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
                             @RequestParam(value = "status", required = false, defaultValue = "0") int status,
                             @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        if (size < 1 || size > 50) {
            size = defaultPageSize;
        }
        if (page < 0) {
            page = defaultPageIndex;
        }
        Page<CommitItem> mList = shijiService.findAll(keywords, status, size, page);
        baseResp.setResultOK();
        baseResp.setData(mList);
        return baseResp;
    }


    @ApiOperation(value = "根据 id 更新商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/updateItem")
    public BaseResp updateItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
        ShijiItem shijiItem = null;
        try {
            shijiItem = shijiService.getItem(num_iid);
            String message = H5apiUtil.getH5Data(num_iid);
            H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
            H5apiData h5data = h5apiJson.getData();
            H5apiItem h5apiItem = h5data.item;

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
            // 设置店铺昵称
            String shopName = h5data.seller.shopName;
            if (!TextUtil.isEmpty(shopName)) {
                shijiItem.setNick(shopName);
            } else {
                shijiItem.setNick(h5data.seller.sellerNick);
            }
            String apiStackVlaue = h5data.apiStack[0].getValue();
            H5apiStackValue h5apiStackValue = mGson.fromJson(apiStackVlaue, H5apiStackValue.class);
            shijiItem.setProvcity(h5apiStackValue.delivery.from);
            shijiItem.setVolume(h5apiStackValue.item.sellCount);
            shijiItem.setSales(Integer.parseInt(h5apiStackValue.item.sellCount));
            shijiItem.setZk_final_price(h5apiStackValue.price.price.priceText);
            // tmall 商品可能出现 原价 为空的情况，这里需要注意
            if (h5apiStackValue.price.extraPrices != null) {
                if (h5apiStackValue.price.extraPrices.length > 0) {
                    shijiItem.setReserve_price(h5apiStackValue.price.extraPrices[0].priceText);
                }
            }

        } catch (Exception e) {
            return baseResp.setError(100, e.toString());
        }
        shijiItem.setSales_update_time(new Date());
        ShijiItem item = shijiService.saveAndUpdate(shijiItem);
        baseResp.setResultOK();
        baseResp.setData(item);
        return baseResp;
    }


//    @ApiOperation(value = "根据商品的id， 查询 h5 api 后入库", notes = "")
//    @RequestMapping(method = RequestMethod.GET, value = "/additem_id")
//    public BaseResp addShijiFromId(String id) {
//        ShijiItem shijiItem = null;
//        ShijiItem result = null;
//        try {
//
//            String message = H5apiUtil.getH5Data(id);
//
//            System.out.println(message);
//
//            H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
//            H5apiData h5data = h5apiJson.getData();
//            H5apiItem h5apiItem = h5data.item;
//
//            shijiItem = new ShijiItem();
//            shijiItem.setNum_iid(h5apiItem.itemId);
//            shijiItem.setTitle(h5apiItem.title);
//            shijiItem.setRate(mGson.toJson(h5data.rate));
//
//            if (h5apiItem.images != null && h5apiItem.images.length > 0) {
//                StringBuilder sb = new StringBuilder();
//                for (String url : h5apiItem.images) {
//                    sb.append(url + "@@");
//                }
//                shijiItem.setSmall_img(sb.toString().substring(0, sb.length() - 2));
//                shijiItem.setPict_url(h5apiItem.images[0]);
//            }
//            shijiItem.setNick(h5data.seller.shopName);
//
//            String apiStackVlaue = h5data.apiStack[0].getValue();
//            H5apiStackValue h5apiStackValue = mGson.fromJson(apiStackVlaue, H5apiStackValue.class);
//            shijiItem.setProvcity(h5apiStackValue.delivery.from);
//            shijiItem.setVolume(h5apiStackValue.item.sellCount);
//            shijiItem.setSales(Integer.parseInt(h5apiStackValue.item.sellCount));
//            shijiItem.setZk_final_price(h5apiStackValue.price.price.priceText);
//            // tmall 商品可能出现 原价 为空的情况，这里需要注意
//            if (h5apiStackValue.price.extraPrices != null) {
//                if (h5apiStackValue.price.extraPrices.length > 0) {
//                    shijiItem.setReserve_price(h5apiStackValue.price.extraPrices[0].priceText);
//                }
//            }
//            shijiItem.setFrom(TBItemFrom.FIND_ID.getValue());
//            result = shijiService.saveAndUpdate(shijiItem);
//
//        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
//        }
//
//        if (null != result) {
//            baseResp.setResultOK();
//            baseResp.setData(result);
//        } else {
//            baseResp.setError(100, "error");
//        }
//        return baseResp;
//    }

}
