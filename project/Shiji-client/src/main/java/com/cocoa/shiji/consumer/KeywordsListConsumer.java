package com.cocoa.shiji.consumer;


import com.cocoa.shiji.bean.taobao.TaobaoAllResp;
import com.cocoa.shiji.util.OkHttpUtil;
import com.cocoa.shiji.util.TextUtil;
import com.google.gson.Gson;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;

public class KeywordsListConsumer {
    public final String TAG = getClass().getSimpleName();
    public static final String TOPIC_KEYWORDS = "topic-keywords-list";

    private String nameSrvAddr;
    private Random mSleepRandom = new Random();
    private Gson mGson = new Gson();


    public KeywordsListConsumer(String nameSrvAddr) {
        this.nameSrvAddr = nameSrvAddr;
    }

    public void start() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("search-consumer");
        consumer.setNamesrvAddr(nameSrvAddr);

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        consumer.subscribe(TOPIC_KEYWORDS, "tagA");

        consumer.setConsumeThreadMax(10);
        consumer.setConsumeThreadMin(7);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                // 执行网络请求
                try {
//                    Thread.sleep(1000 * mSleepRandom.nextInt(5));
//                    if (msgs.size() == 1) {
//                        MessageExt message = msgs.get(0);
//                        String realMsg = new String(message.getBody());
//                        // realMsg example==> 酸奶@@1
//                        String[] kwIndex = realMsg.split("@@");
//                        System.out.println(realMsg);
//                        String jsonStr = TBKApiUtil.getItems(kwIndex[0], Integer.parseInt(kwIndex[1]), 10);
//                        System.out.println(jsonStr);
//
//                        //{"tbk_item_get_response":{"results":{},"total_results":0,"request_id":"12l7tqu7lj9dg"}}
//
//                        if (TextUtil.isEmpty(jsonStr)) {
//                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                        }
//                        TaobaoAllResp taobaoAllResp = mGson.fromJson(jsonStr, TaobaoAllResp.class);
//
//                        List<TaobaoRespItem> taobaoItemList = taobaoAllResp.tbk_item_get_response.results.n_tbk_item;
//                        if (taobaoItemList != null && taobaoItemList.size() > 0) {
//                            //
//                            String resultStr = OkHttpUtil.postRequest("http://127.0.0.1:8898/product/taobao/insertItems", mGson.toJson(taobaoItemList));
//                            System.out.println(resultStr);
//
//                        }
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();

    }
}
