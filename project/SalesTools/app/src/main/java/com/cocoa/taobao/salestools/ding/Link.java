package com.cocoa.taobao.salestools.ding;

/**
 * Created by junshen on 2018/1/10.
 */

public class Link {

    private String text = "";//
    private String title = "";// "时代的火车向前开",
    private String picUrl = "";// "",
    private String messageUrl = "";// "https://mp.weixin.qq.com/s?

    public Link(String text, String title, String picUrl, String messageUrl) {
        this.text = text;
        this.title = title;
        this.picUrl = picUrl;
        this.messageUrl = messageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }
}
