package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.mongo.ContentImg;

import java.util.List;

public interface ItemDetailService {

    <T> T find(String id, Class<T> clazz, String collection);

    <T> T findByNumiid(String num_iid, Class<T> clazz, String collection);

    <T> List<T> findAll(Class<T> clazz, String collection);

    <T> void insertOne(T itemDetail, String collection);

}
