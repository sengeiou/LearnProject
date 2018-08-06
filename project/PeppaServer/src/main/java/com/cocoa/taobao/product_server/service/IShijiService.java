package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IShijiService {

    int updateItem(ShijiItem shijiItem);

    int updateStatus(String num_iid, int status);

    int updateSales(String num_iid, int sales);

    ShijiItem getItem(String num_iid);

    //    Page findAll(String keywords, int status, int size, int page);
//
//    Page findAll(String keywords, int status, PageRequest pageRequest);
//
    int saveItem(ShijiItem shijiItem);
//
//
    List<ShijiItem> findAll(ShijiItem shijiItem);

    List<ShijiItem> findByNumIids(List<String> numIids);

}
