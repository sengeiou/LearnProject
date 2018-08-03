package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.impl.MQProducerImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/keywords")
public class KeywordsController {


    @Autowired
    private BaseResp baseResp;

    @Autowired
    private MQProducerImpl mqProducer;

//    @ApiOperation(value = "增加一个关键字",notes = "")
//    @RequestMapping(value = "/additem", method = RequestMethod.GET)
//    public BaseResp addItem(String name) {
//        return baseResp.setResultOK();
//    }

//    @ApiOperation(value = "更新关键字的数量",notes = "")
//    @RequestMapping(value = "/updateitem", method = RequestMethod.GET)
//    public BaseResp updateItem(String name,long searchNum) {
//        return baseResp.setResultOK();
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public BaseResp testProducer(String kw, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        mqProducer.sendMsg(kw, size);
        baseResp.setData(null);
        return baseResp.setResultOK();
    }

}
