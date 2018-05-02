package com.cocoa.rmq_client;

import com.cocoa.rmq_client.consumer.KeywordsConsumer;
import com.cocoa.rmq_client.consumer.KeywordsListConsumer;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import okhttp3.*;

import java.io.IOException;
import java.util.Random;

public class Main {


    private static final String NAME_SEV_ADDR = "116.196.79.208:9876";


    public static void main(String[] args) {

//        try {
//
//            KeywordsListConsumer searchConsumer = new KeywordsListConsumer(NAME_SEV_ADDR);
//            searchConsumer.start();
//
////            KeywordsConsumer keywordsConsumer = new KeywordsConsumer(NAME_SEV_ADDR);
////            keywordsConsumer.start();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
        try {
            run();

        } catch (Exception e) {

        }


    }


    public static void run() throws Exception {
        String cooKieStr = "v=0; cookie2=14d1d3efbb54e575d22e62a26d90adc5";

        final OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuild = new Request.Builder()
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .url("http://pub.alimama.com/common/code/getAuctionCode.json?auctionid=542588340756&adzoneid=28096268&siteid=8206093&scenes=1&t=1524817792423&_tb_token_=eee73113e3e63&pvid=10_115.236.163.114_4459_1524817629706");
        ;

        for(String str : cooKieStr.split("; ")){
            requestBuild  = requestBuild.addHeader("Cookie",str);
        }

        Request request = requestBuild.build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            }
        });
    }
}

