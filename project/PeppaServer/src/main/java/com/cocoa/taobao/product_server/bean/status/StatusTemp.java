package com.cocoa.taobao.product_server.bean.status;

import java.io.Serializable;

public class StatusTemp implements Serializable{

    private static final long serialVersionUID = 1532961179117L;

    private String des;
    private int value;

    public  StatusTemp(String des, int value) {
        this.des = des;
        this.value = value;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
