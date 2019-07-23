package com.cocoa.taobao.product_server.controller;


import com.alibaba.fastjson.JSON;
import com.cocoa.taobao.product_server.bean.content_img.ContentDetail;
import com.cocoa.taobao.product_server.bean.itemDetail.MongoItemDetail;
import com.cocoa.taobao.product_server.bean.mongo.MongoResult;
import com.cocoa.taobao.product_server.bean.rate.RateDetail;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.resp.Pageable;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiResult;
import com.cocoa.taobao.product_server.bean.sql.Shop;
import com.cocoa.taobao.product_server.bean.status.ShopStatus;
import com.cocoa.taobao.product_server.bean.status.TBItemFrom;
import com.cocoa.taobao.product_server.bean.status.TBItemStatus;
import com.cocoa.taobao.product_server.bean.taobao.*;
import com.cocoa.taobao.product_server.bean.taocode.TaoCode;
import com.cocoa.taobao.product_server.impl.*;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/shiji")
@Api(value = "db shiji_item的相关操作", description = "主要有两个插入：1.从ProductController获取信息后，在调用H5 api 入库 \r\n" +
        "2.根据商品的id 调用H5 api 后入库")
public class SjController {

    @Autowired
    private BaseResp baseResp;

    @Autowired
    public ShijiServiceImpl shijiService;

    @Autowired
    public ItemDetailDaoImpl itemDetailService;

    @Autowired
    public ProductImpl productImpl;

    @Autowired
    public TaobaoServiceImpl taobaoService;

    @Autowired
    private MQProducerImpl mqProducer;


    @Value("${httpparams.default.pagesize}")
    private int defaultPageSize;
    @Value("${httpparams.default.pageindex}")
    private int defaultPageIndex;

    // mq_tag
    @Value("${sub.exp.content_img}")
    private String tagContentImg;
    @Value("${sub.exp.item_detail}")
    private String tagItemDetail;
    @Value("${sub.exp.rate_list}")
    private String tagRateList;


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "通过淘宝 api 过来的数据", notes = "这个方法要优化")
    @RequestMapping(method = RequestMethod.POST, value = "/add/item")
    public BaseResp addShijiFromTB(@RequestBody String json) {
        if (TextUtil.isEmpty(json)) {
            return baseResp.setError(100, "body data is null");
        }
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                    JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();
        ShijiItem shijiItem = gson.fromJson(json, ShijiItem.class);

        if (shijiItem == null || TextUtil.isEmpty(shijiItem.getNum_iid())) {
            return baseResp.setError(100, "item or num_iid has been null");
        }
        ShijiItem dbItem = shijiService.getItem(shijiItem.getNum_iid());
        int result = 0;
        if (dbItem == null) {
            //start mq
            mqProducer.getMoreDetail(shijiItem.getNum_iid(),tagContentImg,tagItemDetail,tagRateList);

            //change status
            shijiItem.setTb_from(TBItemFrom.TKAPI.getValue());
            try {
                result = shijiService.saveItem(shijiItem);
            } catch (Exception e) {
                return baseResp.setError(100, "save shijiitem failed ;" + e.toString());
            }
        } else {
            return baseResp.setError(200, "item has been added");
        }
        if (result == 0) {
            baseResp.setError(100, "error");
        } else {
            baseResp.setResultOK().setData(shijiItem);
        }

        return baseResp;
    }


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "通过id过来的数据", notes = "官方的api 查询")
    @RequestMapping(method = RequestMethod.GET, value = "/add/item")
    public BaseResp addShijiFromId(@RequestParam(value = "num_iids", required = true) String num_iids) {

        if (TextUtil.isEmpty(num_iids)) {
            return baseResp.setError(100, "num_iids is null");
        }
        StringBuilder operationMsg = new StringBuilder();

        try {
            List<TaobaoRespItem> mList = productImpl.getItems(num_iids);

            if (mList == null || mList.size() == 0) {
                return baseResp.setError(100, "taobao api return null");
            }

            for (TaobaoRespItem item : mList) {

                String num_iid = item.getNum_iid();

                if (item == null || TextUtil.isEmpty(item.getNum_iid())) {
                    operationMsg.append(num_iid + " taoapi found error; \n");
                    continue;
                }

                ShijiItem dbItem = shijiService.getItem(item.getNum_iid());
                if (dbItem != null) {
                    operationMsg.append(num_iid + " has been added; \n");
                    continue;
                }

                ShijiItem shijiItem = item.convert();
                shijiItem.setTb_from(TBItemFrom.FIND_ID.getValue());
                shijiItem.setStatus(TBItemStatus.REQ_UPDATED.getValue());

                int code = shijiService.saveItem(shijiItem);

                operationMsg.append(num_iid + " insert db " + code + " ;\n");

                mqProducer.getMoreDetail(shijiItem.getNum_iid(),tagContentImg,tagItemDetail,tagRateList);
            }

        } catch (Exception e) {
            return baseResp.setError(100, e.toString());
        }
        return baseResp.setResultOK().setData(operationMsg);
    }


    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/item")
    public BaseResp getItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
        ShijiItem shijiItem = shijiService.getItem(num_iid);

        if (shijiItem != null) {

            ShijiResult shijiResult = new ShijiResult();
            shijiResult.setShijiItem(shijiItem);

            // add the detail page content images
            MongoResult contentImgMongoResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "contentImg");
            if (null != contentImgMongoResult && !TextUtil.isEmpty(contentImgMongoResult.data)) {
                List<ContentDetail> mList = JSON.parseArray(contentImgMongoResult.data, ContentDetail.class);
                if (mList != null && mList.size() > 0) {
                    shijiResult.setContentDetailList(mList);
                }
            }

            //taocode
            MongoResult taoCodeMongoResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "taoCode");
            if (null != taoCodeMongoResult && !TextUtil.isEmpty(taoCodeMongoResult.data)) {
                TaoCode taoCode = JSON.parseObject(taoCodeMongoResult.data, TaoCode.class);
                shijiResult.setTaoCode(taoCode);
            }

            // rateList 最近的20条评论
            MongoResult rateListMongoResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "rateList");
            if (null != rateListMongoResult && !TextUtil.isEmpty(rateListMongoResult.data)) {
                Type type = new TypeToken<List<RateDetail>>() {
                }.getType();
                List<RateDetail> mList = JSON.parseObject(rateListMongoResult.data, type);
                if (mList != null && mList.size() > 0) {
                    shijiResult.setRateDetailList(mList);
                }
            }
            // itemDetail 暂时就用到了 rate（和评论相关的） 相关的
            MongoResult itemDetailResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "itemDetail");
            if (null != itemDetailResult && !TextUtil.isEmpty(itemDetailResult.data)) {
                System.out.println(itemDetailResult.data);
                MongoItemDetail mongoItemDetail = JSON.parseObject(itemDetailResult.data, MongoItemDetail.class);
                shijiResult.setRate(mongoItemDetail.rate);
            }

            return baseResp.setResultOK().setData(shijiResult);
        } else {
            return baseResp.setError(100, "sorry, item id not found;");
        }
    }


    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/item/simplify")
    public BaseResp getSimpleItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
        ShijiItem shijiItem = shijiService.getItem(num_iid);
        if (shijiItem != null) {
            return baseResp.setResultOK().setData(shijiItem);
        } else {
            return baseResp.setError(100, "sorry, item id not found;");
        }
    }

    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/items/numiids")
    public BaseResp getItemByIids(@RequestParam(value = "num_iids", required = true) String num_iids) {
        if (TextUtil.isEmpty(num_iids)) {
            return baseResp.setError(100, "num_iids is null");
        }
        List<String> numIidList = Arrays.asList(num_iids.split(","))
                .stream()
                .filter((str) -> !TextUtil.isEmpty(str))
                .collect(Collectors.toList());
        if (numIidList == null || numIidList.size() == 0) {
            return baseResp.setResultOK().setData(numIidList);
        }
        List<ShijiItem> mList = shijiService.findByNumIids(numIidList);
        return baseResp.setResultOK().setData(mList);
    }


    @ApiOperation(value = "获取商品", notes = "根据关键字分页获取推荐的商品")
    @RequestMapping(method = RequestMethod.GET, value = "/get/items")
    public BaseResp getItems(@RequestParam(value = "kw", required = false, defaultValue = "") String keywords,
                             @RequestParam(value = "num_iid", required = false, defaultValue = "") String num_iid,
                             @RequestParam(value = "status", required = false, defaultValue = "") String status,
                             @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        if (size < 1 || size > 50) {
            size = defaultPageSize;
        }
        if (page < 0) {
            page = defaultPageIndex;
        }

        Page mPage = PageHelper.startPage(page, size);

        ShijiItem shijiItem = new ShijiItem();

        if (!TextUtil.isEmpty(keywords)) {
            shijiItem.setTitle(keywords);
        }
        if (!TextUtil.isEmpty(num_iid)) {
            shijiItem.setNum_iid(num_iid);
        }

        TBItemStatus tbItemStatus = TBItemStatus.getStatus(status);
        if (tbItemStatus != null) {
            shijiItem.setStatus(tbItemStatus.getValue());
        }
        System.out.println(shijiItem);

        List<ShijiItem> mList = shijiService.findAll(shijiItem);

        Pageable pageable = new Pageable();
        pageable.setTotal(mPage.getTotal());
        pageable.setContent(mList);

        return baseResp.setResultOK().setData(pageable);
    }


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "获取商品状态的信息", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/get/status")
    public BaseResp getStatusInfo() {
        baseResp.setData(TBItemStatus.getStatusInfo());
        return baseResp.setResultOK();
    }


//    @ApiOperation(value = "获取商品", notes = "根据关键字分页获取推荐的商品")
//    @RequestMapping(method = RequestMethod.GET, value = "/get/items/simplify")
//    public BaseResp getItems(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
//                             @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
//        if (size < 1 || size > 50) {
//            size = defaultPageSize;
//        }
//        if (page < 0) {
//            page = defaultPageIndex;
//        }
//        Page mPage = PageHelper.startPage(page, size);
//        ShijiItem shijiItem = new ShijiItem();
//        List<ShijiItem> mList = shijiService.findAll(shijiItem);
//
//        Pageable pageable = new Pageable();
//        pageable.setTotal(mPage.getTotal());
//        pageable.setContent(mList);
//
//        return baseResp.setResultOK().setData(pageable);
//    }


//old code
//    @ApiOperation(value = "根据 id 插入/更新商品", notes = "")
//    @RequestMapping(method = RequestMethod.GET, value = "/updateitem")
//    public BaseResp updateItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
//        ShijiItem shijiItem = null;
//        try {
//            shijiItem = shijiService.getItem(num_iid);
//            if (shijiItem == null) {
//                shijiItem = new ShijiItem();
//                shijiItem.setCreate_time(new Date());
//            }
//
//            String message = H5apiUtil.getH5Data(num_iid);
//            H5apiJson h5apiJson = mGson.fromJson(message, H5apiJson.class);
//            H5apiData h5data = h5apiJson.getData();
//            H5apiItem h5apiItem = h5data.item;
//
//            shijiItem.setNum_iid(h5apiItem.itemId);
//            shijiItem.setTitle(h5apiItem.title);
////            shijiItem.setRate(mGson.toJson(h5data.rate));  // 不存这个库
//
//            if (h5apiItem.images != null && h5apiItem.images.length > 0) {
//                StringBuilder sb = new StringBuilder();
//                for (String url : h5apiItem.images) {
//                    sb.append(url + "@@");
//                }
//                shijiItem.setSmall_img(sb.toString().substring(0, sb.length() - 2));
//                shijiItem.setPict_url(h5apiItem.images[0]);
//            }
//
//            H5apiSeller seller = h5data.seller; // 买家信息相关
//            if (seller != null) {
//                shijiItem.setSeller_id(seller.userId);
//                // 设置店铺昵称
//                String shopName = seller.shopName;
//                if (!TextUtil.isEmpty(shopName)) {
//                    shijiItem.setNick(shopName);
//                } else {
//                    shijiItem.setNick(h5data.seller.sellerNick);
//                }
//            }
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
//
//        } catch (Exception e) {
//            return baseResp.setError(100, e.toString());
//        }
//        shijiItem.setSales_update_time(new Date());
//
//        //如果没有商品的url 就自己拼接
//        if (TextUtil.isEmpty(shijiItem.getItem_url())) {
//            shijiItem.setItem_url("http://item.taobao.com/item.htm?id=" + shijiItem.getNum_iid());
//        }
//        ShijiItem item = shijiService.saveAndUpdate(shijiItem);
//        baseResp.setResultOK();
//        baseResp.setData(item);
//        return baseResp;
//    }


    @ApiOperation(value = "修改商品的信息", notes = "[sales,status]")
    @RequestMapping(method = RequestMethod.GET, value = "/update/sales")
    public BaseResp updateItemInfo(@RequestParam(value = "num_iid") String num_iid,
                                   @RequestParam(value = "sales") String sales,
                                   @RequestParam(value = "status") String status
    ) {
        if (TextUtil.isEmpty(num_iid) || num_iid.length() < 5) {
            return baseResp.setError(100, "check params [num_iid]");
        }

        ShijiItem shijiItem = new ShijiItem();
        shijiItem.setNum_iid(num_iid);
        if (!TextUtil.isEmpty(sales)) {
            try {
                shijiItem.setSales(Integer.parseInt(sales));
            } catch (Exception e) {
                return baseResp.setError(100, "check params [sales] " + e.toString());
            }
        }
        if (!TextUtil.isEmpty(status)) {
            TBItemStatus tbItemStatus = TBItemStatus.getStatus(status);
            if (tbItemStatus == null) {
                return baseResp.setError(100, "check params [status] ,not found this status;");
            } else {
                shijiItem.setSales(Integer.parseInt(sales));
            }
        }

        int code = 0;
        try {
            code = shijiService.updateItem(shijiItem);
        } catch (Exception e) {
            return baseResp.setError(100, "update error" + e.toString());
        }
        if (code == 0) {
            return baseResp.setError(100, "update error");
        }
        return baseResp.setResultOK().setData(null);
    }


//
//
//    @ApiOperation(value = "xxxx", notes = "")
//    @RequestMapping(method = RequestMethod.GET, value = "/mongo1")
//    public BaseResp mongotest1(@RequestParam(value = "num_iid") String num_iid
//    ) {
//        return baseResp.setData(itemDetailService.find(num_iid, TaoCode.class, "taoCode"));
//    }
//
//
//    @ApiOperation(value = "xxxx", notes = "")
//    @RequestMapping(method = RequestMethod.GET, value = "/mongo2")
//    public BaseResp mongotest2(
//    ) {
//        return baseResp.setData(itemDetailService.findAll(TaoCode.class, "taoCode"));
//    }
//
//    @ApiOperation(value = "xxxx", notes = "")
//    @RequestMapping(method = RequestMethod.GET, value = "/mongo3")
//    public BaseResp mongotest3(@RequestParam(value = "price") Double price,
//                               @RequestParam(value = "id") String id) {
//        ContentImg itemDetail = new ContentImg();
//        itemDetailService.insertOne(itemDetail, "taoCode");
//        return baseResp;
//    }

//old  code
//    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
//    @RequestMapping(method = RequestMethod.GET, value = "/taocode")
//    public BaseResp getTaoCode(@RequestParam(value = "pict") String itme_pict
//            , @RequestParam(value = "url", required = true) String itme_url) {
//        try {
//            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//            TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
//            req.setUserId("1071473899");
//            req.setText("超值活动123");
//            req.setUrl(itme_url);
//            req.setLogo(itme_pict);
////            req.setExt("{\"pid\":\"mm_44823234_8206093_28096268\"}");
//            TbkTpwdCreateResponse rsp = client.execute(req);
//            return baseResp.setResultOK().setData(rsp.getBody());
//        } catch (Exception E) {
//            return baseResp.setError(100, E.getLocalizedMessage());
//        }
//
//    }


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
