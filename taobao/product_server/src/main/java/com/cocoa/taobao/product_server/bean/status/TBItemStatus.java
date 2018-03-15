package com.cocoa.taobao.product_server.bean.status;

/**
 * taobao_item 的状态枚举
 */
public enum TBItemStatus {


    DEFAULT("default", -1), // 默认或未知
    NEW("new", 0),  // 刚从淘宝抓取的
    PREPARED("prepared", 1),  // 准备加入实际
    INSERTED("inserted", 2),  // 已经入了shiji
    DELETE("delete", 400), // 放弃不用的数据
    IGNORE("ignore", 401); // 大流量店铺

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


