package com.cocoa.shiji.test;

import com.cocoa.shiji.util.TextUtil;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenqunCookirJar implements CookieJar {

    private final Map<String, List<Cookie>> cookiesMap = new HashMap<String, List<Cookie>>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        System.out.println("saveFromResponse");
        forEachCookies(cookies);
        String host = url.host();
        List<Cookie> cookiesList = cookiesMap.get(host);
        if (cookiesList != null) {
            cookiesMap.remove(host);
        }
        cookiesMap.put(host, cookies);
    }

    public List<Cookie> loadForRequest(HttpUrl url) {
        System.out.println("loadForRequest");
        List<Cookie> cookiesList = cookiesMap.get(url.host());
        if (cookiesList == null) {
            cookiesList = new ArrayList<>();

            for(String item : TaobaoRenqunThread.cookies.split(";")){
                if(!TextUtil.isEmpty(item)) {
                    Cookie temp = Cookie.parse(HttpUrl.parse("https://taobao.com"), item);

                    System.out.println("temp");
                    System.out.println(temp.domain());
                    cookiesList.add(temp);
                }

            }


        }


        forEachCookies(cookiesList);
        return cookiesList;
    }


    public void forEachCookies(List<Cookie> cookiesList) {
        for (Cookie cookie : cookiesList) {
            System.out.println(cookie.toString());
        }
    }


}
