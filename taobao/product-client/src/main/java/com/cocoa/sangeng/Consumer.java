package com.cocoa.sangeng;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

//tengxun  118.126.66.230    !     2018-07   RMB120   1核2G、1M带宽
//        jd       116.196.79.208    ?      2018-09   RMB188  1核2G
//        aliyun   120.79.51.243     ?      2018-11   RMB330  1核1G
public class Consumer extends Thread {

    private int count = 0;

    @Override
    public void run() {
        super.run();
        try {
         /*
         * Instantiate with specified consumer group name.
         */
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("DefaultMQPushConsumer");
            consumer.setNamesrvAddr("116.196.79.208:9876");

        /*
         * Specify name server addresses.
         * <p/>
         *
         * Alternatively, you may specify name server addresses via exporting environmental variable: NAMESRV_ADDR
         * <pre>
         * {@code
         * consumer.setNamesrvAddr("name-server1-ip:9876;name-server2-ip:9876");
         * }
         * </pre>
         */

        /*
         * Specify where to start in case the specified consumer group is a brand new one.
         */
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        /*
         * Subscribe one more more topics to consume.
         */
            consumer.subscribe("TopicTest", "*");

        /*
         *  Register callback to execute on arrival of messages fetched from brokers.
         */
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {

                    count++;
                    System.out.println(msgs.size());
//                    System.out.println(Thread.currentThread().getName() + "=============" + count);
//                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

        /*
         *  Launch the consumer instance.
         */
            consumer.start();

            System.out.printf("Consumer Started.%n");

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException, MQClientException {
       Consumer consumerA =  new Consumer();
       consumerA.setName("A");
       consumerA.start();

//        Consumer consumerB =  new Consumer();
//        consumerB.setName("B");
//        consumerB.start();
    }
}