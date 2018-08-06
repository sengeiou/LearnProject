package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.service.IMQProducerService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MQProducerImpl implements IMQProducerService {


    @Value("${mq.namesrv.addr}")
    private String nameSrvAddr;

    @Value("${mq.topic}")
    private String mq_topic;

    DefaultMQProducer producer = null;

    public void start() throws MQClientException {
        System.out.println(nameSrvAddr);
        producer = new DefaultMQProducer("keywords-producer");
        producer.setNamesrvAddr(nameSrvAddr);
        producer.start();

    }

    @Override
    public void sendMsg(String msg, int size) {
        if (producer == null) {
            try {
                start();
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    for (int i = 0; i < 200; i++) {
                        Message m = new Message(mq_topic, "keywords", (msg + "@@" + i + "@@" + size).getBytes(RemotingHelper.DEFAULT_CHARSET));
                        SendResult result = producer.send(m);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public SendResult senMsg(String msg, String tag) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        if (producer == null) {
            try {
                start();
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }

        Message message = new Message(mq_topic, tag, msg.getBytes());
        return producer.send(message);
    }


    public void getMoreDetail(String num_iid, String... tags) {
        for (String tag : tags) {
            try {
                SendResult sendResult = senMsg(num_iid, tag);
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
