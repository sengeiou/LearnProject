package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.sql.CommitItem;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.springframework.data.domain.Page;

public interface ITaobaoService {

    int addItem(CommitItem commitItem);

    int updateStatus(long num_iid, int status);

    Page findAll(String keywords, int status, Integer size, Integer page);

}
