package com.cocoa.taobao.product_server.bean.status;

import java.io.Serializable;

public class StatusTemp implements Serializable{

    private static final long serialVersionUID = 1532961179117L;

    private String desc;
    private int value;

    public  StatusTemp(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
