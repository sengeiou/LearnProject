package com.cocoa.taobao.product_server.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.exception.RemotingException;

public interface IMQProducerService {

    void sendMsg(String msg, int size);

    SendResult senMsg(String msg, String tag) throws InterruptedException, RemotingException, MQClientException, MQBrokerException;

}
