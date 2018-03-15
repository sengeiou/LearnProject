package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.springframework.data.domain.Page;

public interface IShijiService {


    ShijiItem getItem(String num_iid);

    Page findAll(String keywords, int status, int size, int page);

    ShijiItem saveAndUpdate(ShijiItem shijiItem);
}
