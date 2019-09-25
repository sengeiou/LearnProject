package com.cocoa.wechat;

/**
 * Created by junshen on 2017/12/1.
 */

public class Sender {

    private String msgtype = "text";
    private Content text = new Content();


    Sender(String content){
        text.content = content;
    }

    class Content {
       public String content;
    }
}
