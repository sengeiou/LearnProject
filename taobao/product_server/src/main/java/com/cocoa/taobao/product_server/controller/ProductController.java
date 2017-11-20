package com.cocoa.taobao.product_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET , value = "/list")
    public String getProduct(int pageSize , int pageNo, String keywords){

        return "";
    }




}
