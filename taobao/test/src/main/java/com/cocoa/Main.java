package com.cocoa;

import com.google.gson.Gson;
import com.sun.javafx.binding.StringFormatter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    static final String url = "http://116.196.79.208:8898/product/shiji/additem_id?id=";

    public static void main(String[] args) {
//        String url = "http://h5api.m.taobao.com/h5/mtop.taobao.detail.getdetail/6.0/?jsv=2.4.8&appKey=12574478&t=1513130908745&sign=4cca0b2f4172fb146369c9b59f3b5116&api=mtop.taobao.detail.getdetail&v=6.0&ttid=2016%40taobao_h5_2.0.0&isSec=0&ecode=0&AntiFlood=true&AntiCreep=true&H5Request=true&type=jsonp&dataType=jsonp&callback=mtopjsonp1&data=%7B%22exParams%22%3A%22%7B%5C%22id%5C%22%3A%5C%22%s%5C%22%7D%22%2C%22itemNumId%22%3A%22%s%22%7D";
//
//        try {
//
//
//            String message = getRequest(url.replace("%s","522844070204"));
//            message = message.replace("mtopjsonp1(", "");
//            message = message.substring(0, message.length() - 1);
//
//            System.out.println(message);
//            H5apiJson json = new Gson().fromJson(message,H5apiJson.class);
//
//            System.out.println(json.getData());
//            System.out.println(json.getData().apiStack[0].getValue());
//            System.out.println(json.getData().item);
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
        try {

            StringBuilder sb = new StringBuilder();
            Document document = Jsoup.parse(new File("/Users/junshen/Documents/LearnProject/taobao/test/src/main/java/com/cocoa/fav.txt"), "utf-8");

            Elements elements = document.getElementsByClass("findsame-btn");

            for (Element e : elements) {
                String href = e.attr("href");
                String id = href.split("=")[1].replace("&cat", "");

                Thread.sleep(2000);

                System.out.print(id+"---");
                System.out.println(getRequest(url + id));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }


    public static String getRequest(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }
}
