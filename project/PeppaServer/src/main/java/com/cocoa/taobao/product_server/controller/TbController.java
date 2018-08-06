package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.status.TBItemStatus;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.taobao.TaobaoRespItem;
import com.cocoa.taobao.product_server.bean.taobao.TaobaoSmallimg;
import com.cocoa.taobao.product_server.impl.TaobaoServiceImpl;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/taobao")
@Api(value = "真实的商品库操作", description = "db = taobao_item")
public class TbController {

    final String[] shopArray = {"百草味", "周黑鸭", "三只松鼠", "良品铺子", "天猫生鲜", "天猫超市", "天猫"};

    @Autowired
    private BaseResp baseResp;
    @Autowired
    public TaobaoServiceImpl taobaoService;


    @Value("${httpparams.default.pagesize}")
    private int defaultPageSize;
    @Value("${httpparams.default.pageindex}")
    private int defaultPageIndex;


    @ApiOperation(value = "获取商品", notes = "根据关键字分页获取推荐的商品")
    @RequestMapping(method = RequestMethod.GET, value = "/getItems")
    public BaseResp getItems(@RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
                             @RequestParam(value = "status", required = false, defaultValue = "new") String status,
                             @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        if (size < 1 || size > 50) {
            size = defaultPageSize;
        }
        if (page < 0) {
            page = defaultPageIndex;
        }

        int statusInt = TBItemStatus.NEW.getValue();
        if (TBItemStatus.getStatus(status) != null) {
            statusInt = TBItemStatus.getStatus(status).getValue();
        }

        Page<CommitItem> mList = taobaoService.findAll(keywords, statusInt, size, page);
        baseResp.setResultOK();
        baseResp.setData(mList);
        return baseResp;
    }

    @ApiOperation(value = "获取商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/getItem")
    public BaseResp getItem(@RequestParam(value = "num_iid", required = true) String num_iid) {
        CommitItem dbItem = taobaoService.getItem(num_iid);
        if (dbItem != null) {
            baseResp.setResultOK();
            baseResp.setData(dbItem);
            return baseResp;
        }
        return baseResp.setError(100, "error");
    }

    @ApiOperation(value = "更新商品状态", notes = "")
    @ApiImplicitParam(name = "status", value = "", required = true, dataType = "String")
    @RequestMapping(value = "/updateItemStatus", method = RequestMethod.GET)
    public BaseResp updateItemStatusById(String num_iid, String status) {
        if (TextUtil.isEmpty(num_iid)) {
            return baseResp.setError(100, "num_iid is null");
        }
        TBItemStatus tbItemStatus = TBItemStatus.getStatus(status);
        if (tbItemStatus == null) {
            baseResp.setError(100, "error status");
        } else {
            int result = taobaoService.updateStatus(num_iid, tbItemStatus.getValue());
            if (1 == result) {
                baseResp.setResultOK();
            } else {
                baseResp.setError(100, "error");
            }
        }
        return baseResp;
    }

    @ApiOperation(value = "添加商品", notes = "")
    @RequestMapping(method = RequestMethod.POST, value = "/insertItem")
    public BaseResp addItem(@RequestBody String json) {

        if (TextUtil.isEmpty(json)) {
            return baseResp.setError(100, "body item is null");
        }
        System.out.println(json);

        CommitItem commitItem = new Gson().fromJson(json, CommitItem.class);

        // find db-item
        CommitItem dbItem = taobaoService.getItem(commitItem.getNum_iid());
        if (dbItem != null) {
            return baseResp.setError(100, "item has been added, and status ignore");
        }

        commitItem.setStatus(TBItemStatus.REQ_UPDATED.getValue());
        // 大流量店铺，直接修改状态
        for (String key : shopArray) {
            if (commitItem.getNick().contains(key) || commitItem.getTitle().contains(key)) {
                commitItem.setStatus(TBItemStatus.IGNORE.getValue());
                break;
            }
        }
        CommitItem result = taobaoService.addItem(commitItem);
        if (null != result) {
            baseResp.setResultOK();
        } else {
            baseResp.setError(100, "error");
        }
        return baseResp;
    }


    @ApiOperation(value = "添加多个商品", notes = "")
    @RequestMapping(method = RequestMethod.POST, value = "/insertItems")
    public BaseResp addItems(@RequestBody String json) {

        if (TextUtil.isEmpty(json)) {
            return baseResp.setError(100, "body item is null");
        }


        Type type = new TypeToken<List<TaobaoRespItem>>() {
        }.getType();
        ArrayList<CommitItem> commitItems = new ArrayList<>();

        List<TaobaoRespItem> taobaoRespItemList = new Gson().fromJson(json, type);
        for (int i = 0; i < taobaoRespItemList.size(); i++) {
            TaobaoRespItem taobaoRespItem = taobaoRespItemList.get(i);

            String num_iid = taobaoRespItem.getNum_iid();
            if (TextUtil.isEmpty(num_iid)) {
                continue;
            }

            // find db-item
            CommitItem dbItem = taobaoService.getItem(taobaoRespItem.getNum_iid());
            if (dbItem != null) {
                continue;
            }

            CommitItem commitItem = new CommitItem();
            commitItem.setNum_iid(taobaoRespItem.getNum_iid());
            commitItem.setNick(taobaoRespItem.getNick());
            commitItem.setItem_url(taobaoRespItem.getItem_url());
            commitItem.setPict_url(taobaoRespItem.getPict_url());
            commitItem.setProvcity(taobaoRespItem.getProvcity());
            commitItem.setReserve_price(taobaoRespItem.getReserve_price());
            commitItem.setSeller_id(taobaoRespItem.getSeller_id());
            commitItem.setTitle(taobaoRespItem.getTitle());
            commitItem.setUser_type(String.valueOf(taobaoRespItem.getUser_type()));
            commitItem.setVolume(taobaoRespItem.getVolume());
            int sales = 0;
            try {
                sales = Integer.parseInt(taobaoRespItem.getVolume());
            } catch (NumberFormatException e) {

            }
            commitItem.setSales(sales);
            commitItem.setZk_final_price(taobaoRespItem.getZk_final_price());
            commitItem.setCreate_time(new Date());
            commitItem.setSales_update_time(new Date());

            TaobaoSmallimg img = taobaoRespItem.getSmall_img();
            if (img != null && img.getString() != null && img.getString().size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (String imgUrl : img.getString()) {
                    sb.append(imgUrl + "@@");
                }
                commitItem.setSmall_img(sb.substring(0, sb.length() - 2));
            }
            commitItem.setStatus(TBItemStatus.NEW.getValue());
            // 大流量店铺，直接修改状态
            for (String key : shopArray) {
                if (commitItem.getNick().contains(key) || commitItem.getTitle().contains(key)) {
                    commitItem.setStatus(TBItemStatus.IGNORE.getValue());
                    break;
                }
            }
            taobaoService.flush();
            commitItems.add(commitItem);
        }
        taobaoService.addItems(commitItems);
        return baseResp;
    }

    @ApiOperation(value = "模糊查找商品", notes = "")
    @RequestMapping(method = RequestMethod.GET, value = "/finditems")
    public BaseResp findItems(String title, int status) {
        Pageable pageable = new PageRequest(0, 1000);
        Page page = taobaoService.findByStatusAndTitleLike(status, "%" + title + "%", pageable);
        baseResp.setResultOK();
        baseResp.setData(page);
        return baseResp;
    }

}
