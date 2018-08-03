package com.cocoa.taobao.product_server.service;

import com.cocoa.taobao.product_server.bean.taobao.TaobaoRespItem;

import java.util.List;

public interface IProductService {

    List<TaobaoRespItem> getItems(String keywords, Long pageSize, Long pageIndex);


    List<TaobaoRespItem> getItems(String num_iids);

}
