package com.cocoa;

import com.google.gson.Gson;
import okhttp3.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

public class main {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    static List<Cookie> mCookieList = new ArrayList<>();

    static String[] SpecialUsers = {"newsapp", "fmessage", "filehelper", "weibo", "qqmail", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "readerapp", "blogapp", "facebookapp", "masssendapp",
            "meishiapp", "feedsapp", "voip", "blogappweixin", "weixin", "brandsessionholder", "weixinreminder", "wxid_novlwrv3lqwv11", "gh_22b87fa7cb3c", "officialaccounts", "notification_messages", "wxitil", "userexperience_alarm"};

    static String currentUserName = "cocoa";

    public static OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            mCookieList.addAll(cookies);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            return mCookieList;
        }
    }).build();

    public static final Map<String, String> emptyMap = new HashMap<>();

//<error><ret>0</ret><message></message><skey>@crypt_22260fe6_13399ae3b4a669979f0c31888782c8ca</skey><wxsid>hyYoW5uF9MXbBUu/</wxsid><wxuin>2503499862</wxuin><pass_ticket>lJus4gzQZeI1nfd7vp1CAlhMrImxj0AeSfoBE15zZwEBKW4Ve%2BnJF76wmoXr34fY</pass_ticket><isgrayscale>1</isgrayscale></error>

    static String qrcodeUrl = "https://login.weixin.qq.com/qrcode/%s?t=webwx";
    static String scanUrl = "https://login.weixin.qq.com/cgi-bin/mmwebwx-bin/login?uuid=%s&tip=1&_=%s";

    public static void main(String[] args) {

        try {
            System.setProperty("jsse.enableSNIExtension", "false");
            String url = "https://login.weixin.qq.com/jslogin?appid=wx782c26e4c19acffb&redirect_uri=https%3A%2F%2Fwx.qq.com%2Fcgi-bin%2Fmmwebwx-bin%2Fwebwxnewloginpage&fun=new&lang=zh_CN&_=";
            String result = getRequest(url + System.currentTimeMillis());
            String uuid = decodeUUID(result);
            System.out.println(uuid);
            String formatedQrcodeUrl = String.format(qrcodeUrl, uuid);
            System.out.println(formatedQrcodeUrl);
            String scanResult = getRequest(String.format(scanUrl, uuid, System.currentTimeMillis()));
            String redirectUriResult = "";
            while (scanResult.indexOf("redirect_uri") < 0) {
                Thread.sleep(1000);
                scanResult = getRequest(String.format(scanUrl, uuid, System.currentTimeMillis()));
            }
            redirectUriResult = decodeRedirectUrl(scanResult);
            System.out.println(redirectUriResult);

            String cookieResult = getRequest(redirectUriResult + "&fun=new");
            System.out.println(cookieResult);
            Map<String, String> map = parseXML(cookieResult);
            map.put("r", System.currentTimeMillis() + "");


            Map<String, String> map1 = new HashMap<>();
            map1.put("r", System.currentTimeMillis() + "");

            Map<String, String> inMap = new HashMap<>();
            inMap.put("Uin", map.get("wxuin"));
            inMap.put("Sid", map.get("wxsid"));
            inMap.put("Skey", map.get("skey"));
            inMap.put("DeviceID", "e17123123312");


            Map<String, Object> outMap = new HashMap<>();
            outMap.put("BaseRequest", inMap);

            String url1 = String.format("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit?pass_ticket=%1$s&skey=%2$s&r=%3$s", map.get("pass_ticket"), map.get("skey"), System.currentTimeMillis() + "");

            postRequest(url1, new Gson().toJson(outMap));


            System.out.println(map.get("skey"));
            System.out.println(map.get("wxsid"));
            System.out.println(map.get("pass_ticket"));

            String contactUrl = String.format("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxgetcontact?r=%s", System.currentTimeMillis() + "");
            String contactMsg = postRequest(contactUrl, "{}");
//            postRequest(contactUrl, "{}");

            MemberResp memberResp = new Gson().fromJson(contactMsg, MemberResp.class);

            List<Member> memberList = memberResp.getMemberList();
            Iterator<Member> iterator = memberList.iterator();
            while (iterator.hasNext()) {
                Member m = iterator.next();
                if (m.getVerifyFlag() != 0 && (m.getVerifyFlag() % 8) == 0) {
                    System.out.println("delete-----" + m.getNickName());
                    iterator.remove();
                    continue;
                }
                if (m.getVerifyFlag() == 29) {
                    System.out.println("delete-----" + m.getNickName());
                    iterator.remove();
                    continue;
                }
                if (currentUserName.equals(m.getNickName())) {
                    System.out.println("delete-----" + m.getNickName());
                    iterator.remove();
                    continue;
                }

                for (String name : SpecialUsers) {
                    if (name.equals(m.getUserName())) {
                        System.out.println("delete-----" + m.getNickName());
                        iterator.remove();
                        break;
                    }
                }
            }
            System.out.println("--" + memberList.size());
            List<RoomMember> mList = new ArrayList<>();

            for (Member m : memberList) {
                System.out.println(m.getNickName());

                if (m.getNickName().equals("胡阿敏")||m.getNickName().equals("viven")||m.getNickName().equals("c")) {
                    mList.add(new RoomMember(m.getUserName()));
                }
            }


            Thread.sleep(1000 * 20);

            // create room  webwxcreatechatroom
            String urlCreateRoom = String.format("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxcreatechatroom?pass_ticket=%1$s&r=%2$s", map.get("pass_ticket"), System.currentTimeMillis() + "");

            outMap.put("MemberCount", mList.size());
            outMap.put("MemberList", mList);
            outMap.put("Topic", "");

            System.out.println(postRequest(urlCreateRoom, new Gson().toJson(outMap)));


        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }


    }


    public static String getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String postRequest(String url, String json) throws IOException {
        Request.Builder builder = new Request.Builder();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        //System.out.println(result);
        return result;
    }


    public static String decodeUUID(String msg) {
        if (msg.isEmpty()) {
            return "";
        }
        if (msg.indexOf("200") > 0) {
            String uuidspan = msg.split("window.QRLogin.uuid = ")[1];
            return uuidspan.replace("\"", "").replace(";", "");
        }
        return "";
    }


    public static String decodeRedirectUrl(String msg) {
        if (msg.isEmpty()) {
            return "";
        }
        if (msg.indexOf("uri=") > 0) {
            String span = msg.split("uri=")[1];
            return span.replace("\"", "").replace(";", "");
        }
        return "";
    }

    public static boolean isEmpey(String msg) {
        return msg == null && msg.length() == 0;
    }

    public static Map<String, String> parseXML(String msg) throws Exception {
        Map<String, String> map = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder的对象
        //创建DocumentBuilder对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        //通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
        Document document = db.parse(new ByteArrayInputStream(msg.getBytes()));
        //获取所有book节点的集合
        NodeList bookList = document.getElementsByTagName("error");

        NodeList child = bookList.item(0).getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            if (child.item(i).getFirstChild() != null) {
                map.put(child.item(i).getNodeName(), child.item(i).getFirstChild().getNodeValue());
            }
        }
        return map;
    }

}
