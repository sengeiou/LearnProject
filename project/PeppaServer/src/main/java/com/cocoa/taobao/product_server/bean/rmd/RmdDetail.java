package com.cocoa.taobao.product_server.bean.rmd;

public class RmdDetail extends SimpleRmdDetail {

    private String desc;
    private Object ext;

    public RmdDetail() {

    }

    public RmdDetail(String title, String num_iid, String pic, String desc, Object ext) {
        super(title, num_iid, pic);
        this.desc = desc;
        this.ext = ext;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }
}
