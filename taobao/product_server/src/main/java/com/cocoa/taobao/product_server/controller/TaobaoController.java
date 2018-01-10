package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.TBItemStatus;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.dao.TaobaoDao;
import com.cocoa.taobao.product_server.impl.TaobaoServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("taobao")
public class TaobaoController {

    final String[] shopArray = {"百草味", "周黑鸭", "三只松鼠", "良品铺子", "天猫生鲜", "天猫超市", "天猫"};
    public static final Gson mGson = new Gson();

    @Autowired
    private BaseResp baseResp;

    @Autowired
    public TaobaoServiceImpl taobaoService;


    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_PAGE_INDEX = 0;


    @RequestMapping(method = RequestMethod.GET, value = "/getItems")
    public String getItems(String keywords, int status, Integer size, Integer page) {
        int finalSize = DEFAULT_PAGE_SIZE;
        int finalPage = DEFAULT_PAGE_INDEX;
        if (size != null && size > 0) {
            finalSize = size;
        }
        if (page != null && page > 0) {
            finalPage = page;
        }

        Page<CommitItem> mList = taobaoService.findAll(keywords, status, finalSize, finalPage);

        List finLList = new ArrayList();
        for (CommitItem commitItem : mList) {
            finLList.add(commitItem);
        }

        return mGson.toJson(finLList);
    }

    /**
     * 更新 taobao_item 数据库的状态
     *
     * @param id     CommitItem 的 num_iid  淘宝商品的id
     * @param status CommitItem 的 status  状态值
     * @return
     */
    @RequestMapping(value = "/updateItemStatus")
    public String updateItemStatusById(long id, String status) {
        TBItemStatus tbItemStatus = TBItemStatus.getStatus(status);
        if (tbItemStatus == null) {
            baseResp.setError(100, "error status");
        } else {
            int result = taobaoService.updateStatus(id, tbItemStatus.getValue());
            if (1 == result) {
                baseResp.setResultOK();
            } else {
                baseResp.setError(100, "error");
            }
        }
        return mGson.toJson(baseResp);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/insertItem")
    public String addItem(String json) {
        CommitItem commitItem = mGson.fromJson(json, CommitItem.class);
        // 大流量店铺，直接修改状态
        for (String key : shopArray) {
            if(commitItem.getNick().contains(key)||commitItem.getTitle().contains(key)){
                commitItem.setStatus(TBItemStatus.IGNORE.getValue());
                break;
            }
        }
        int b = taobaoService.addItem(commitItem);
        if (1 == b) {
            baseResp.setResultOK();
        } else {
            baseResp.setError(100, "error");
        }
        return mGson.toJson(baseResp);
    }


}
