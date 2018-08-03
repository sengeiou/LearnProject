package com.cocoa.taobao.product_server.controller;

import com.cocoa.taobao.product_server.bean.client.BasicParams;
import com.cocoa.taobao.product_server.bean.client.BasicRespData;
import com.cocoa.taobao.product_server.bean.client.InsertParams;
import com.cocoa.taobao.product_server.bean.client.SearchParams;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.impl.MQProducerImpl;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;

@RestController
@RequestMapping(value = "/")
public class BaseController {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//    @RequestMapping(method = RequestMethod.GET, value = "/display")
//    public String getDisplay(String message) {
//        logger.error("dispa11 error");
//        return message;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/client")
//    public BaseResp getBasciParams() {
//
//        BasicParams basicParams = new BasicParams();
//        basicParams.setDingUrl("https://oapi.dingtalk.com/robot/send?access_token=ba895b6c33bc212547af72395d37dd29f246bd337ceab884e63491d8099f2a09");
//
//        SearchParams searchParams = new SearchParams();
//        searchParams.setKeywords("麻花");
//        searchParams.setListUrl("/product/product/list");
//        searchParams.setUpdateUrl("/product/taobao/insertItem");
//
//        InsertParams insertParams = new InsertParams();
//        insertParams.setListParamsStatus("prepared");
//        insertParams.setListUrl("/product/taobao/getItems");
//        insertParams.setInsertUrl("/product/shiji/additem");
//        insertParams.setUpdateUrl("/product/taobao/updateItemStatus");
//
//        BasicRespData data = new BasicRespData();
//        data.setBasicParams(basicParams);
//        data.setSearchParams(searchParams);
//        data.setInsertParams(insertParams);
//
//        BaseResp<BasicRespData> resp = new BaseResp<>();
//        resp.setData(data);
//        return resp;
//    }


}
