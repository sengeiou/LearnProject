package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaobaoService {

    CommitItem addItem(CommitItem commitItem);

    int updateStatus(String num_iid, int status);

    Page findAll(String keywords, int status, Integer size, Integer page);

    CommitItem getItem(String num_iid);

//    int updateItem(CommitItem commitItem);

    Page findByStatusAndTitleLike( int status, String title,Pageable pageable);

}
