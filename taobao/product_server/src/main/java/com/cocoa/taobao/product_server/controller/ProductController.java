package com.cocoa.taobao.product_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {
    public static String url = "http://gw.api.taobao.com/router/rest";
    public static String appkey = "23222740";
    public static String secret = "36b68bc26780160e5d80a129666dcc7f";


    @RequestMapping(method = RequestMethod.GET , value = "/list")
    public String getProduct(int pageSize , int pageNo, String keywords){
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("布丁");
//        req.setCat("21,23");
//        req.setItemloc("杭州");
//        req.setSort("tk_rate_des");
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);
        req.setPageNo(2L);
//        req.setPageSize(20L);
        TbkItemGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
        return "";
    }




}
