package com.cocoa.rmq_client.producer;

import com.cocoa.rmq_client.consumer.KeywordsListConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class KeywordsListProducer extends Thread {
    public final String TAG = getClass().getSimpleName();

    private String nameSrvAddr;
    private String keywords;
    DefaultMQProducer producer;

    public KeywordsListProducer(String nameSrvAddr) {
        this.nameSrvAddr = nameSrvAddr;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void prepare() throws MQClientException {
        producer = new DefaultMQProducer("keywordslist-producer");
        producer.setNamesrvAddr(nameSrvAddr);
        producer.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100; i++) {
                String realMsg = keywords + "-" + i;
                Message m = new Message(KeywordsListConsumer.TOPIC_KEYWORDS, "tag", realMsg.getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult resultMsg = producer.send(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //    public void sendMsg() throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
//
//
//        new Thread() {
//            @Override
//            public void run() throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
//                super.run();
//                for (int i = 0; i < 100; i++) {
//                    String realMsg = keywords + "-" + i;
//                    Message m = new Message(KeywordsListConsumer.TOPIC_KEYWORDS, "tag", realMsg.getBytes(RemotingHelper.DEFAULT_CHARSET));
//
//                    SendResult resultMsg = producer.send(m);
////            System.out.printf(TAG + "%s%n", resultMsg);
//                }
//            }
//        }.start();
//
//    }

}
