package com.cocoa.taobao.product_server.dao;

import com.cocoa.taobao.product_server.bean.mongo.ContentImg;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemDetailDao extends MongoRepository<ContentImg,Long> {


}
