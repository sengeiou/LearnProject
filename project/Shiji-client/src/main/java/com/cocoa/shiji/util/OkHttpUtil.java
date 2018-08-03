package com.cocoa.shiji.util;

import okhttp3.*;

import java.util.Iterator;
import java.util.Map;

public class OkHttpUtil {


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public static  String getRequest(String url) throws Exception {
        return getRequest(url, null);
    }


    public static String getRequest(String url, Map<String, Object> map) throws Exception {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        if (map != null) {
            Iterator<String> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                urlBuilder.addEncodedQueryParameter(key, map.get(key).toString());
            }
        }
        Request request = new Request.Builder()
                .url(urlBuilder.build().url())
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static String getRequest(Request request) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }



    public static String postRequest(String url, String msg) throws Exception {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = RequestBody.create(JSON, msg);

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
