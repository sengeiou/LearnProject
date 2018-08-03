package com.cocoa.shiji.worker;

import com.cocoa.shiji.util.TextUtil;
import com.google.gson.*;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Product extends BaseWorker {

    public Product() {
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                    JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        mGson = builder.create();
        initPropreties();
    }

    public Product(String consumerGroup, String topic, String subExpression) {
        initPropreties();
        this.consumerGroup = consumerGroup;
        this.topic = topic;
        this.subExpression = subExpression;

    }

    public abstract void initPropreties();

}
