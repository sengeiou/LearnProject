package com.cocoa.taobao.product_server.service;

public interface IMQProducerService {
    void sendMsg(String msg);
}
