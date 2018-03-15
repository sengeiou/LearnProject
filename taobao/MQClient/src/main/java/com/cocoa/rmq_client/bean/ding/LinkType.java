package com.cocoa.rmq_client.bean.ding;

public class LinkType {
    private String text;

    private String title;
    private String picUrl;
    private String messageUrl;

    public LinkType(String text, String title, String picUrl, String messageUrl) {
        this.text = text;
        this.title = title;
        this.picUrl = picUrl;
        this.messageUrl = messageUrl;
    }
}
