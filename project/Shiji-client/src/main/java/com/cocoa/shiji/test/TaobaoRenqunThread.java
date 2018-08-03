package com.cocoa.shiji.test;

import com.cocoa.shiji.util.TextUtil;
import com.google.gson.Gson;
import com.taobao.api.Constants;
import com.taobao.api.internal.util.StringUtils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;

public class TaobaoRenqunThread extends Thread {
    public static String cookies = "v=0; t=2c0bb57a570e0a1e78978ce6ff726987; cookie2=115049a9e7f185c7498c2c6c41aa79a8; _tb_token_=7398b135853e5; cna=BWqnEzefADoCAXPso3IWoiUb; lgc=cocoa6543; tracknick=cocoa6543; dnk=cocoa6543; tg=0; miid=839371638713190478; thw=cn; enc=lEUB0rZyKpV9%2Fq45PeKyCm4mzfkhM7ztaDZGJBlE97376Ll4ICkvfATPC2UKpQBmAtBMxPAvAuoE%2FQdMRNDA9g%3D%3D; hng=CN%7Czh-CN%7CCNY%7C156; uc1=cookie14=UoTeNmnWIPGYBA%3D%3D&lng=zh_CN&cookie16=VT5L2FSpNgq6fDudInPRgavC%2BQ%3D%3D&existShop=false&cookie21=UIHiLt3xSixwG45%2Bs3wzsA%3D%3D&tag=8&cookie15=WqG3DMC9VAQiUQ%3D%3D&pas=0; uc3=nk2=AHXGFJrElL4%2F&id2=UoH4FCmLH0Wq8Q%3D%3D&vt3=F8dBzr2JLAXSgRWnDvc%3D&lg2=UIHiLt3xD8xYTw%3D%3D; existShop=MTUyODg4MTAxMg%3D%3D; csg=634abce5; mt=np=&ci=-1_0; skt=53e107e438c42950; _cc_=Vq8l%2BKCLiw%3D%3D; isg=BJCQT0jT_zFc9KM3RgUjnzMIYdgi8WBP53ysiophXOu-xTBvMmlEM-a0mYslFSx7; _m_h5_tk=0b1e10e02ec5dffa9e73d5d414eb70e6_1528964015955; _m_h5_tk_enc=29bd8133e387920dc12710b7ee6d4568";
    @Override
    public void run() {
        super.run();

        String dStr = new H5ApiD().toString();

        H5ApiData h5ApiData = new H5ApiData(dStr);

        String jsonData = new Gson().toJson(h5ApiData);
        String h5_tk = "1d557dd5e8a6e8d5990555843c62a6b9";

        for (String item : cookies.split(";")) {
            if (!TextUtil.isEmpty(item) && item.contains("_m_h5_tk") && !item.contains("_m_h5_tk_enc")) {
                String result = item.replace("_m_h5_tk=", "");
                h5_tk = result.split("_")[0];
                System.out.println("h5_tk= >" + h5_tk);
                break;
            }
        }

        String appKey = "12574478";
        long time = System.currentTimeMillis();
//        time = 1528953020890L;

        System.out.println(time);//1528966006431

        String url = "https://h5api.m.taobao.com/h5/mtop.taobao.tceget.steins.renqun.xget/1.0/";

        String data = h5_tk + "&" + time + "&" + appKey + "&" + jsonData;

        try {

            System.out.println(data);
            System.out.println(jsonData);
            String sign = encryptMD5(data).toLowerCase();
            System.out.println(sign);

//            sign = "8d12daf96913c54a6c52a27052627cd5";


            Map<String, String> paramsMap = new LinkedHashMap<>();

            paramsMap.put("jsv", "2.4.0");
            paramsMap.put("appKey", appKey);
            paramsMap.put("t", time + "");
            paramsMap.put("sign", sign);
            paramsMap.put("AntiCreep", "true");
            paramsMap.put("api", "mtop.taobao.tceget.steins.renqun.xget");
            paramsMap.put("v", "1.0");
            paramsMap.put("dataType", "jsonp");
            paramsMap.put("timeout", "2000");
            paramsMap.put("type", "jsonp");
            paramsMap.put("callback", "mtopjsonp2");
            paramsMap.put("data", jsonData);

            String[] paramsKeys = paramsMap.keySet().toArray(new String[0]);
//            Arrays.sort(paramsKeys);


            OkHttpClient client = new OkHttpClient.Builder().cookieJar(new RenqunCookirJar()).build();
            HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
            Request.Builder builder = new Request.Builder();
            if (paramsMap != null) {
                for (String key : paramsKeys) {
                    urlBuilder.addEncodedQueryParameter(key, paramsMap.get(key).toString());
//                    builder.addHeader(key, paramsMap.get(key).toString());
                }
            }
            builder.addHeader("cookie", cookies);
            builder.addHeader(":authority", "h5api.m.taobao.com");
            builder.addHeader(":method", "GET");
            builder.addHeader("accept", "*/*");
            builder.addHeader("accept-encoding", "gzip, deflate, br");
            builder.addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7");
            builder.addHeader("cache-control", "no-cache");
            builder.addHeader("pragma", "no-cache");
            builder.addHeader(":scheme", "https");
            String path = urlBuilder.build().url().toString().replace(url,"/h5/mtop.taobao.tceget.steins.renqun.xget/1.0/");
            System.out.println(path);
            builder.addHeader(":path", path);
            builder.addHeader("pragma", "no-cache");
            builder.addHeader("upgrade-insecure-requests", "1");
            builder.addHeader("user-agent", "Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Mobile Safari/537.36");


                    System.out.println(urlBuilder.build().url());
            Request request = builder
                    .url(urlBuilder.build().url())
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());


            response = client.newCall(request).execute();
            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static char hexDigits[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String encryptMD5(String data) throws IOException {

        try {
            byte[] btInput = data.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


}
