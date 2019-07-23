package com.cocoa.taobao.product_server.bean.report.ding;

public class DingUploader  {

    private String msgtype;
    private DingLinkType link;


    public DingUploader(String msgtype, DingLinkType link) {
        this.msgtype = msgtype;
        this.link = link;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public DingLinkType getLink() {
        return link;
    }

    public void setLink(DingLinkType link) {
        this.link = link;
    }
}
