package com.cocoa.rmq_client;

import com.cocoa.rmq_client.consumer.KeywordsConsumer;
import com.cocoa.rmq_client.consumer.KeywordsListConsumer;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

public class Main {


    private static final String NAME_SEV_ADDR = "116.196.79.208:9876";




    public static void main(String[] args) {

        try {

            KeywordsListConsumer searchConsumer = new KeywordsListConsumer(NAME_SEV_ADDR);
            searchConsumer.start();

//            KeywordsConsumer keywordsConsumer = new KeywordsConsumer(NAME_SEV_ADDR);
//            keywordsConsumer.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
