package com.cocoa.shiji.worker;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


import java.io.IOException;

public class TaobaoLogin {

//    String TAO_LOGIN_URL = "https://login.taobao.com/member/login.jhtml?style=mini&newMini2=false&css_style=alimama&from=alimama&redirectURL=http%3A%2F%2Fwww.alimama.com&full_redirect=true";
//
////
////        "accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
////            "accept-encoding", "gzip, deflate, br",
////            "accept-language", "zh-CN,zh;q=0.8,en;q=0.6",
////            "cache-control", "max-age=0",
////            "upgrade-insecure-requests", "1",
////        "user-agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)"
////    }
////
//
//    public void login(String name, String pwd) {
//
//
//        WebClient webClient = new WebClient();//创建WebClient
//
//        webClient.addRequestHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//        webClient.addRequestHeader("accept-encoding", "gzip, deflate, br");
//        webClient.addRequestHeader("accept-language", "zh-CN,zh;q=0.8,en;q=0.6");
//        webClient.addRequestHeader("cache-control", "max-age=0");
//        webClient.addRequestHeader("upgrade-insecure-requests", "1");
//        webClient.addRequestHeader("user-agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)");
//
//        HtmlPage page = null;
//        try {
//            page = webClient.getPage(TAO_LOGIN_URL);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        sleep(3*1000);
//
//        HtmlElement usernameEle = (HtmlElement) page.getElementById("TPL_username_1");
//        HtmlElement passwordEle = (HtmlElement) page.getElementById("TPL_password_1");
//
//        sleep(2*1000);
//
//        usernameEle.focus();   //设置输入焦点
//        try {
//            usernameEle.type(name);  //填写值
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        passwordEle.focus();   //设置输入焦点
//        try {
//            passwordEle.type(pwd);  //填写值
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        sleep(2*1000);
//
//        HtmlElement loginEle = (HtmlElement) page.getElementById("J_SubmitStatic");
//
//        try {
//            Page page1 = loginEle.click();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    void sleep(long time) {
//        try {
//            Thread.sleep(time);
//        } catch (Exception e) {
//
//        }
//    }


}
