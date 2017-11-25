package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.CommitItem;
import com.cocoa.taobao.product_server.dao.ProductDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("server")
public class ItemController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(method = RequestMethod.GET, value = "/getItems")
    public String getItemByStatus(String keywords, int status, Integer size) {
        int finalSize = 10;
        if (size != null && size > 0) {
            finalSize = size ;
        }
        long cTime = System.currentTimeMillis();
        PageRequest pageRequest = new PageRequest(0, finalSize, Sort.Direction.DESC, "sales");
//        productDao.findAll(new Example<>())
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact()).
                        withIgnorePaths("id").
                        withIgnorePaths("sales").
                        withIgnorePaths("small_img");
        CommitItem commitItem = new CommitItem();
        commitItem.setStatus(status);

        Page<CommitItem> mList = productDao.findAll(Example.of(commitItem, matcher), pageRequest);
        List<CommitItem> resultList = new ArrayList<>();
        for (CommitItem m : mList) {
            resultList.add(m);
        }
        System.out.println("----"+(System.currentTimeMillis()-cTime)+"---");
        return new Gson().toJson(resultList);
    }

    @RequestMapping(value = "/update")
    public String updateItemStatus(long id, int status) {
        int result = productDao.updateItemStatus(id, status);
        System.out.println(result);
        return new Gson().toJson(result);
    }


}
