package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.dao.ShopDao;
import com.cocoa.taobao.product_server.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ShopDaoImpl implements ShopService {

//    @Autowired
//    private ShopDao shopDao;
//
//    @Override
//    public Page<Shop> findAll(int page,int size ,Sort.Direction direction,String sortedProp) {
//        PageRequest pageRequest = new PageRequest(page, size, direction,sortedProp);
//        return shopDao.findAll(pageRequest);
//    }
//
//    @Override
//    public boolean add(Shop shop) {
//        shopDao.save(shop);
//        return true;
//    }
//
//    @Override
//    public Shop findOne(Long id) {
//        return shopDao.findOne(id);
//    }
//
//    @Override
//    public Shop findByShopId(int shopId) {
////        Shop item = new Shop();
////        item.setId(shopId);
////        ExampleMatcher matcher = ExampleMatcher.matching()
////                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact());
////        Example e = Example.of(item, matcher);
//        return null;
//    }


}
