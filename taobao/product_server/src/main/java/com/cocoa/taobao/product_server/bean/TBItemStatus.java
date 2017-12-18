package com.cocoa.taobao.product_server.bean;

/**
 * taobao_item 的状态枚举
 */
public enum TBItemStatus {

    NEW("new", 0),  // 刚从淘宝抓取的
    INSERTED("inserted", 1),  // 已经入了shiji库
    DELETE("delete", -1); // 放弃不用的数据

    private String des;
    private int value;

    TBItemStatus(String des, int value) {
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

    public static TBItemStatus getStatus(String statusStr) {
        for (TBItemStatus tbItemStatus : TBItemStatus.values()) {
            if (tbItemStatus.des.equals(statusStr)) {
                return tbItemStatus;
            }
        }
        return null;
    }


}


