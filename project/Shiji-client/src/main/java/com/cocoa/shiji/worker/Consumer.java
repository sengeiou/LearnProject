package com.cocoa.shiji.worker;

import com.cocoa.shiji.util.TextUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Consumer extends BaseWorker {

    public abstract ConsumerStatus dispatchMsg(String msg);

    protected int maxThread = 5;
    protected int maxRetryNum = 2;
    protected long threadSleepSecond = 5L;
    public Map<String, Integer> retryHashmap = new HashMap<>();

    public String[] dbArray = new String[4];  // 需要查询的四个数据库
    public Consumer() {
        initPropreties();
    }

    public Consumer(String consumerGroup, String topic, String subExpression) {
        initPropreties();
        this.consumerGroup = consumerGroup;
        this.topic = topic;
        this.subExpression = subExpression;
    }


    public abstract void initPropreties();

    @Override
    public void run() {
        super.run();

        DefaultMQPushConsumer consumer =
                new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(NAME_SEV_ADDR);
        try {
            //订阅PushTopic下Tag为push的消息
            consumer.subscribe(topic, subExpression);
            /**
             * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
             * 如果非第一次启动，那么按照上次消费的位置继续消费
             */
            consumer.setConsumeThreadMin(1);
            if (maxThread > 0) {
                consumer.setConsumeThreadMax(maxThread);
            }
            consumer.setConsumeFromWhere(
                    ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(
                    new MessageListenerConcurrently() {
                        public ConsumeConcurrentlyStatus consumeMessage(
                                List<MessageExt> msgs,
                                ConsumeConcurrentlyContext Context) {

                            String msg = new String(msgs.get(0).getBody());

                            System.out.println(msg);

                            if (TextUtil.isEmpty(msg)) {
                                // report  null and toaString
                                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                            }

                            if (retryHashmap.get(msg) != null && retryHashmap.get(msg) >= getMaxRetryNum()) {
                                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                            }

                            ConsumerStatus result = dispatchMsg(msg);
                            if (result != null && result.getStatus() == ConsumeConcurrentlyStatus.RECONSUME_LATER) {

                                System.out.println(result.getMsg());
                                System.out.println(result.getE().getMessage());

                                //report ding msg
                                if (retryHashmap.get(msg) == null) {
                                    retryHashmap.put(msg, 0);
                                } else {
                                    retryHashmap.put(msg, retryHashmap.get(msg) + 1);
                                }
                                //result.getMsg();
                            }
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        }
                    }
            );
            retryHashmap.clear();
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getMaxThread() {
        return maxThread;
    }

    public void setMaxThread(int maxThread) {
        this.maxThread = maxThread;
    }

    public long getThreadSleepSecond() {
        return threadSleepSecond;
    }

    public void setThreadSleepSecond(long threadSleepSecond) {
        this.threadSleepSecond = threadSleepSecond;
    }

    public int getMaxRetryNum() {
        return maxRetryNum;
    }

    public void setMaxRetryNum(int maxRetryNum) {
        this.maxRetryNum = maxRetryNum;
    }


    @Override
    public String toString() {
        return "Consumer{" +
                "TAG='" + TAG + '\'' +
                ", FORMAT_TAG='" + FORMAT_TAG + '\'' +
                ", consumerGroup='" + consumerGroup + '\'' +
                ", topic='" + topic + '\'' +
                ", subExpression='" + subExpression + '\'' +
                ", maxThread=" + maxThread +
                ", maxRetryNum=" + maxRetryNum +
                ", threadSleepSecond=" + threadSleepSecond +
                ", retryHashmap=" + retryHashmap +
                '}';
    }
}
