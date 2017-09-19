package com.company;

import com.taobao.api.Constants;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.TbkItemRecommendGetRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by sj on 17/8/25.
 */
public class UpdateTaoItem extends BaseMain {

    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/taobao?characterEncoding=utf8&useSSL=true";
    static final String user = "root";
    static final String password = "cocoa";
    static final String SQL_SELECT_ALL = "SELECT * FROM taobao_item";
    static final String HMAC = "hmac";


    public static void main(String[] args) {

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery(SQL_SELECT_ALL);
                set.next();
                String url = set.getString("item_url");
                Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Mobile Safari/537.36").get();

                System.out.println(url);
                System.out.println(doc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    public static Map<String, String> getMap() {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("method", "taobao.tbk.item.info.get");
//        map.put("app_key", appkey);
//        map.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        map.put("format", "json");
//        map.put("v", "2.0");
//        map.put("sign_method", HMAC);
//        return map;
//    }
//
//
//    public static String getParamsStr(Map<String, String> map) {
//        Iterator<String> iterator = map.keySet().iterator();
//        StringBuilder sb = new StringBuilder();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            String value = map.get(key);
//            sb.append(key + "=" + value + "&");
//        }
//        return sb.substring(0, sb.length() - 1);
//    }
//
//
//    public static String signTopRequest(Map<String, String> params, String secret, String signMethod) throws IOException {
//        // 第一步：检查参数是否已经排序
//        String[] keys = params.keySet().toArray(new String[0]);
//        Arrays.sort(keys);
//
//        // 第二步：把所有参数名和参数值串在一起
//        StringBuilder query = new StringBuilder();
//        if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
//            query.append(secret);
//        }
//        for (String key : keys) {
//            String value = params.get(key);
//            if (StringUtils.areNotEmpty(key, value)) {
//                query.append(key).append(value);
//            }
//        }
//
//        // 第三步：使用MD5/HMAC加密
//        byte[] bytes;
//        if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {
//            bytes = encryptHMAC(query.toString(), secret);
//        } else {
//            query.append(secret);
//            bytes = encryptMD5(query.toString());
//        }
//
//        // 第四步：把二进制转化为大写的十六进制
//        return byte2hex(bytes);
//    }
//
//    public static byte[] encryptHMAC(String data, String secret) throws IOException {
//        byte[] bytes = null;
//        try {
//            SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constants.CHARSET_UTF8), "HmacMD5");
//            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
//            mac.init(secretKey);
//            bytes = mac.doFinal(data.getBytes(Constants.CHARSET_UTF8));
//        } catch (GeneralSecurityException gse) {
//            throw new IOException(gse.toString());
//        }
//        return bytes;
//    }
//
//    public static byte[] encryptMD5(String data) throws IOException {
//        return encryptMD5(data.getBytes(Constants.CHARSET_UTF8).toString());
//    }
//
//    public static String byte2hex(byte[] bytes) {
//        StringBuilder sign = new StringBuilder();
//        for (int i = 0; i < bytes.length; i++) {
//            String hex = Integer.toHexString(bytes[i] & 0xFF);
//            if (hex.length() == 1) {
//                sign.append("0");
//            }
//            sign.append(hex.toUpperCase());
//        }
//        return sign.toString();
//    }
//
//
//    try {
//        Map<String, String> paramsMap = getMap();
//        String result = signTopRequest(paramsMap, secret, HMAC);
//
//        paramsMap.put("sign", result);
//
//        String paramsStr = getParamsStr(paramsMap);
//
//        OkHttpClient client = new OkHttpClient();
//
//        String finalUrl = "http://gw.api.taobao.com/router/rest?"+paramsStr;
//
//        System.out.println(finalUrl);
//
//        Request request = new Request.Builder()
//                .url(finalUrl)
//                .build();
//
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
//
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
}
