package com.cocoa.shiji.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class KeywordsConsumer {

//    public final String TAG = getClass().getSimpleName();
//    public static final String TOPIC_KEYWORDS = "topic-keywords";
//    private String nameSrvAddr;
//    KeywordsListProducer producer = null;
//
//    public KeywordsConsumer(String nameSrvAddr) throws MQClientException {
//        this.nameSrvAddr = nameSrvAddr;
//        producer = new KeywordsListProducer(nameSrvAddr);
//        producer.prepare();
//    }
//
//    public void start() throws MQClientException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("keywords-consumer");
//        consumer.setNamesrvAddr(nameSrvAddr);
//
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//
//        consumer.subscribe(TOPIC_KEYWORDS, "*");
//
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                // 执行网络请求
//                try {
//                    System.out.println(TAG + "===" + msgs.size());
//                    if (msgs.size() == 1) {
//                        MessageExt message = msgs.get(0);
//                        String realMsg = new String(message.getBody());
//
//                        producer.setKeywords(realMsg);
//                        producer.start();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                }
//                System.out.println("===========================");
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//        consumer.start();
//
//    }

}
