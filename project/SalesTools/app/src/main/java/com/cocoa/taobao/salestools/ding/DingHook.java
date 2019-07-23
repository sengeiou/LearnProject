package com.cocoa.taobao.salestools.ding;

/**
 * Created by junshen on 2018/1/10.
 */

public class DingHook {

    private String msgtype = "link";
    private Link link;

    public DingHook(String text, String title, String picUrl, String messageUrl) {
        if (link == null) {
            link = new Link(text, title, picUrl, messageUrl);
        }
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
