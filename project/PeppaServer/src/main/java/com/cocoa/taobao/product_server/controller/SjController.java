package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.content_img.ContentDetail;
import com.cocoa.taobao.product_server.bean.itemDetail.MongoItemDetail;
import com.cocoa.taobao.product_server.bean.mongo.ContentImg;
import com.cocoa.taobao.product_server.bean.mongo.MongoResult;
import com.cocoa.taobao.product_server.bean.rate.RateDetail;
import com.cocoa.taobao.product_server.bean.rate.RateList;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.sql.BaseItem;
import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import com.cocoa.taobao.product_server.bean.status.TBItemFrom;
import com.cocoa.taobao.product_server.bean.status.TBItemStatus;
import com.cocoa.taobao.product_server.bean.taobao.*;
import com.cocoa.taobao.product_server.bean.taocode.TaoCode;
import com.cocoa.taobao.product_server.impl.*;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/shiji")
@Api(value = "db shiji_item的相关操作", description = "主要有两个插入：1.从ProductController获取信息后，在调用H5 api 入库 \r\n" +
        "2.根据商品的id 调用H5 api 后入库")
public class SjController {

    public static final Gson mGson = new Gson();

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
    @RequestMapping(method = RequestMethod.POST, value = "/additem")
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

        // 根据num_iid 查询shiji 库
        ShijiItem dbItem = shijiService.getItem(shijiItem.getNum_iid());

        if (dbItem == null) {
            //start mq
            getMoreDetail(shijiItem.getNum_iid());

            //change status
            shijiItem.setFrom(TBItemFrom.TKAPI.getValue());

            shijiItem = shijiService.saveAndUpdate(shijiItem);
        } else {
            return baseResp.setError(1, "item has been added");
        }
        if (null != shijiItem) {
            baseResp.setResultOK();
            baseResp.setData(shijiItem);
        } else {
            baseResp.setError(100, "error");
        }

        return baseResp;
    }

    /**
     * @param
     * @return
     */
    @ApiOperation(value = "通过id过来的数据", notes = "官方的api 查询")
    @RequestMapping(method = RequestMethod.GET, value = "/additem")
    public BaseResp addShijiFromId(@RequestParam(value = "num_iid", required = true) String num_iid) {

        baseResp.setData(null);
        if (TextUtil.isEmpty(num_iid)) {
            return baseResp.setError(100, "num_iids is null");
        }
        try {
            List<TaobaoRespItem> mList = productImpl.getItems(num_iid);

            if (mList == null || mList.size() == 0) {
                return baseResp.setError(100, "taobao api return null");
            }

            for (TaobaoRespItem item : mList) {

                if (item == null || TextUtil.isEmpty(item.getNum_iid())) {
                    continue;
                }

                ShijiItem dbItem = shijiService.getItem(item.getNum_iid());
                if (dbItem != null) {
                    continue;
                }

                ShijiItem shijiItem = new ShijiItem();
                shijiItem.setNum_iid(item.getNum_iid());
                shijiItem.setNick(item.getNick());
                shijiItem.setItem_url(item.getItem_url());
                shijiItem.setPict_url(item.getPict_url());
                shijiItem.setProvcity(item.getProvcity());
                shijiItem.setReserve_price(item.getReserve_price());
                shijiItem.setSeller_id(item.getSeller_id());
                shijiItem.setTitle(item.getTitle());
                shijiItem.setUser_type(item.getUser_type());
                shijiItem.setVolume(item.getVolume());
                shijiItem.setZk_final_price(item.getZk_final_price());
                shijiItem.setCreateTime(new Date());
                shijiItem.setSales_update_time(new Date());
                shijiItem.setFrom(TBItemFrom.FIND_ID.getValue());
                shijiItem.setStatus(TBItemStatus.REQ_UPDATED.getValue());

                TaobaoSmallimg img = item.getSmall_img();
                if (img != null && img.getString() != null && img.getString().size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String imgUrl : img.getString()) {
                        sb.append(imgUrl + "@@");
                    }
                    shijiItem.setSmall_img(sb.substring(0, sb.length() - 2));
                }
                shijiService.saveAndUpdate(shijiItem);

                getMoreDetail(shijiItem.getNum_iid());
            }

        } catch (Exception e) {
            return baseResp.setError(100, e.toString());
        }
        return baseResp.setResultOK();
    }


    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/getitem")
    public BaseResp getItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
        ShijiItem shijiItem = shijiService.getItem(num_iid);

        if (shijiItem != null) {
            // add the detail page content images
            MongoResult contentImgMongoResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "contentImg");
            if (null != contentImgMongoResult && !TextUtil.isEmpty(contentImgMongoResult.data)) {
                Type type = new TypeToken<List<ContentDetail>>() {
                }.getType();
                List<ContentDetail> mList = mGson.fromJson(contentImgMongoResult.data, type);
                if (mList != null && mList.size() > 0) {
                    shijiItem.contentDetailList.addAll(mList);
                }
            }

            //taocode
            MongoResult taoCodeMongoResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "taoCode");
            if (null != taoCodeMongoResult && !TextUtil.isEmpty(taoCodeMongoResult.data)) {
                TaoCode taoCode = mGson.fromJson(taoCodeMongoResult.data, TaoCode.class);
                shijiItem.taoCode = taoCode;
            }

            // rateList 最近的20条评论
            MongoResult rateListMongoResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "rateList");
            if (null != rateListMongoResult && !TextUtil.isEmpty(rateListMongoResult.data)) {
                Type type = new TypeToken<List<RateDetail>>() {
                }.getType();
                List<RateDetail> mList = mGson.fromJson(rateListMongoResult.data, type);
                if (mList != null && mList.size() > 0) {
                    shijiItem.rateDetailList.addAll(mList);
                }
            }
            // itemDetail 暂时就用到了 rate（和评论相关的） 相关的
            MongoResult itemDetailResult = itemDetailService.findByNumiid(num_iid, MongoResult.class, "itemDetail");
            if (null != itemDetailResult && !TextUtil.isEmpty(itemDetailResult.data)) {
                System.out.println(itemDetailResult.data);
                MongoItemDetail mongoItemDetail = mGson.fromJson(itemDetailResult.data, MongoItemDetail.class);
                shijiItem.rate = mongoItemDetail.rate;
            }

            return baseResp.setResultOK().setData(shijiItem);
        } else {
            return baseResp.setError(100, "error");
        }
    }


    @ApiOperation(value = "根据num_iid 查询商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/getsitem")
    public BaseResp getSimpleItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
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
        Page<ShijiItem> mList = shijiService.findAll(keywords, status, size, page);
        baseResp.setResultOK();
        baseResp.setData(mList);
        return baseResp;
    }

    @ApiOperation(value = "获取商品", notes = "根据关键字分页获取推荐的商品")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllItems")
    public BaseResp getItems(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        if (size < 1 || size > 50) {
            size = defaultPageSize;
        }
        if (page < 0) {
            page = defaultPageIndex;
        }
        Page<ShijiItem> mList = shijiService.findAll(size, page, Sort.Direction.ASC, "status");
        baseResp.setResultOK();
        baseResp.setData(mList);
        return baseResp;
    }


    public void getMoreDetail(String num_iid) {
        try {
            SendResult resultContentImg = mqProducer.senMsg(num_iid, tagContentImg);
            System.out.println(resultContentImg);
            SendResult resultRateList = mqProducer.senMsg(num_iid, tagRateList);
            System.out.println(resultRateList);
            SendResult resultItemDetail = mqProducer.senMsg(num_iid, tagItemDetail);
            System.out.println(resultItemDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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


    @ApiOperation(value = "商品状态修改", notes = "expird")
    @RequestMapping(method = RequestMethod.GET, value = "/update_status")
    public BaseResp update(@RequestParam(value = "num_iid") String num_iid,
            @RequestParam(value = "status") String status) {
        // *******require fix*****
        // 钉钉提醒 dingding
        TBItemStatus tbItemStatus = TBItemStatus.getStatus(status);
        if (tbItemStatus==null){
            return baseResp.setError(100, "status error");
        }
        int code = shijiService.updateStatus(num_iid, tbItemStatus.getValue());
        if (code > 0) {
            return baseResp.setResultOK();
        }
        return baseResp.setError(100, "update error");
    }

    @ApiOperation(value = "修改商品的销量", notes = "sales")
    @RequestMapping(method = RequestMethod.GET, value = "/update_sales")
    public BaseResp updateSales(@RequestParam(value = "num_iid") String num_iid,
                                @RequestParam(value = "sales") int sales) {
        if (sales > 1000_0000 || TextUtil.isEmpty(num_iid)) {
            return baseResp.setError(100, "check params");
        }
        int code = shijiService.updateSales(num_iid, sales);
        if (code > 0) {
            return baseResp.setResultOK();
        }
        return baseResp.setError(code, "update error");
    }


    @ApiOperation(value = "xxxx", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/mongo1")
    public BaseResp mongotest1(@RequestParam(value = "num_iid") String num_iid
    ) {
        return baseResp.setData(itemDetailService.find(num_iid, TaoCode.class, "taoCode"));
    }


    @ApiOperation(value = "xxxx", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/mongo2")
    public BaseResp mongotest2(
    ) {
        return baseResp.setData(itemDetailService.findAll(TaoCode.class, "taoCode"));
    }

    @ApiOperation(value = "xxxx", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/mongo3")
    public BaseResp mongotest3(@RequestParam(value = "price") Double price,
                               @RequestParam(value = "id") String id) {
        ContentImg itemDetail = new ContentImg();
        itemDetailService.insertOne(itemDetail, "taoCode");
        return baseResp;
    }


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
