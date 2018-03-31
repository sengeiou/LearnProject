package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.service.IMQProducerService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MQProducerImpl implements IMQProducerService {


    //    @Value("${namesrv.addr}")
    private String nameSrvAddr = "116.196.79.208:9876";

    //    @Value("${namesrv.topic.keywordslist}")
    private String topicKeywordslist = "topic-keywords-list";

    DefaultMQProducer producer = null;

    public MQProducerImpl() throws MQClientException {
        System.out.println(nameSrvAddr);
        producer = new DefaultMQProducer("keywords-producer");
        producer.setNamesrvAddr(nameSrvAddr);
        producer.start();
    }

    @Override
    public void sendMsg(String msg) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    for (int i = 0; i < 600; i++) {
                        Message m = new Message(topicKeywordslist, "tagA", (msg + "@@" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                        SendResult result = producer.send(m);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
