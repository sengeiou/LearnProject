package com.cocoa.taobao.product_server.bean.report.ding;

public class DingLinkType {
    private String text;
    private String title;
    private String picUrl;
    private String messageUrl;

    public DingLinkType(String text, String title, String picUrl, String messageUrl) {
        this.text = text;
        this.title = title;
        this.picUrl = picUrl;
        this.messageUrl = messageUrl;
    }
}
