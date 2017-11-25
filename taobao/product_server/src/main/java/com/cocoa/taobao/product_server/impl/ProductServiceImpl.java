package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.CommitItem;
import com.cocoa.taobao.product_server.dao.ProductDao;
import com.cocoa.taobao.product_server.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public int insertProduct(CommitItem commitItem) {
      return   productDao.insertCommitItem(commitItem.getItem_url(),
                commitItem.getNick(),
                commitItem.getNum_iid() ,
                commitItem.getPict_url(),
                commitItem.getProvcity(),
                commitItem.getReserve_price(),
                commitItem.getSeller_id(),
                commitItem.getSmall_img(),
                commitItem.getTitle(),
                commitItem.getUser_type(),
                commitItem.getVolume(),
                commitItem.getZk_final_price(),
                commitItem.getSales(),
                new Date(), new Date(),
                commitItem.getItem_id());
    }
}
