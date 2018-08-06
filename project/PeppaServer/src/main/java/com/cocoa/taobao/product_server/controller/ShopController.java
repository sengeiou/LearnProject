package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.resp.Pageable;
import com.cocoa.taobao.product_server.bean.sql.Shop;
import com.cocoa.taobao.product_server.bean.status.ShopStatus;
import com.cocoa.taobao.product_server.bean.status.StatusTemp;
import com.cocoa.taobao.product_server.impl.*;
import com.cocoa.taobao.product_server.mapper.ShopMapper;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.TextEventMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/shop")
@Api(value = "")
public class ShopController {

    public static final Gson mGson = new Gson();

    @Autowired
    private BaseResp baseResp;

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

    @Autowired
    private ShopMapper shopMapper;


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "新增商店", notes = "入参是一个json串")
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public BaseResp addShop(@RequestParam(value = "json", required = true) String json) {
        if (TextUtil.isEmpty(json)) {
            return baseResp.setError(100, "the json params is null");
        }
        Shop shop = null;
        try {
            shop = mGson.fromJson(json, Shop.class);
        } catch (JsonSyntaxException e) {
            return baseResp.setError(100, e.toString());
        }

        if (shop == null) {
            return baseResp.setError(100, "sorry, shop parse error");
        }
        shop.setCreate_date(System.currentTimeMillis());
        shop.setStatus(ShopStatus.NEW.getValue());
        System.out.println(shop);
        int result = 0;
        try {
            result = shopMapper.insertShop(shop);
        } catch (Exception e) {
            return baseResp.setError(100, e.toString());
        }
        if (result == 0) {
            return baseResp.setError(100, "nothing insert");
        }
        return baseResp.setResultOK().setData(null);
    }


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "获取所有的商店", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/getall")
    public BaseResp getAll(
//                           @RequestParam(value = "status", required = false, defaultValue = "0") int status,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page) {

        Page mPage = PageHelper.startPage(page, size);
        List<Shop> mList = shopMapper.findAll();

        Pageable pageable = new Pageable();
        pageable.setTotal(mPage.getTotal());
        pageable.setContent(mList);
        pageable.setExt1(ShopStatus.getStatusInfo());

        baseResp.setData(pageable);
        return baseResp.setResultOK();
    }


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/status")
    public BaseResp getStatusInfo() {
        baseResp.setData(ShopStatus.getStatusInfo());
        return baseResp.setResultOK();
    }

    /**
     * @param
     * @return
     */
    @ApiOperation(value = "获取所有的商店", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/getone")
    public BaseResp getOneById(@RequestParam(value = "id", required = true) int id) {
        Shop shop = new Shop();
        shop.setId(id);
        List<Shop> list = shopMapper.queryShop(shop);
        if (list.size() == 1) {
            baseResp.setData(list.get(0));
        } else {
            System.out.println(list);
        }
        return baseResp.setResultOK();
    }


    /**
     * @param
     * @return
     */
    @ApiOperation(value = "", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/update_status")
    public BaseResp updateOne(@RequestParam(value = "shop_id", required = true) int shopId,
                              @RequestParam(value = "status", required = true) String status) {
        ShopStatus shopStatus = ShopStatus.getStatus(status);
        if (shopStatus == null || shopId < 0) {
            return baseResp.setError(100, "check params");
        }
        int result = 0;
        try {
            System.out.println(shopId);
            System.out.println(shopStatus.getValue());
            result = shopMapper.updateStatus(shopId, shopStatus.getValue());
        } catch (Exception e) {
            return baseResp.setError(100, e.toString());
        }
        if (result == 0) {
            baseResp.setError(100, "nothing update");
        }
        return baseResp.setResultOK().setData(null);
    }



}
