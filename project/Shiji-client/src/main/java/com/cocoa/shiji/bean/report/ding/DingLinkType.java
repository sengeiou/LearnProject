package com.cocoa.shiji.bean.report.ding;

import com.cocoa.shiji.bean.report.Reporter;

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


    public DingLinkType(Reporter reporter) {
        this.text = reporter.getMsg();
        this.title = reporter.getTitle();
        this.picUrl = "";
        this.messageUrl = reporter.getMsgUrl();
    }



}
