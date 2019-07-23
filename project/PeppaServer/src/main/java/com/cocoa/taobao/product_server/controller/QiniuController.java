package com.cocoa.taobao.product_server.controller;

import com.cocoa.taobao.product_server.bean.qiniu.QiniuResp;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.impl.MQProducerImpl;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/qiniu")
public class QiniuController {

    @Value("${qiniu.accessKey}")
    String accessKey;
    @Value("${qiniu.secretKey}")
    String secretKey;
    @Value("${qiniu.bucket}")
    String bucket ;
    @Value("${qiniu.url}")
    String url ;

    @Autowired
    private BaseResp baseResp;


    @RequestMapping(method = RequestMethod.GET, value = "/token")
    public BaseResp getToken() {

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        QiniuResp resp = new QiniuResp();
        resp.setToken(upToken);
        resp.setUrl(url);

        baseResp.setData(resp);
        return baseResp.setResultOK();
    }

}
