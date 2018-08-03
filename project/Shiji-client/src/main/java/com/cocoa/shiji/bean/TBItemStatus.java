package com.cocoa.shiji.bean;


/**
 * taobao_item 的状态枚举
 */
public enum TBItemStatus {

    DEFAULT("default", 0), // 默认或未知
    NEW("new", 1),  // 刚从淘宝抓取的
    REQ_UPDATED("require_update", 2),  // 已经入了shiji, 但是需要更新附加数据
    ONLINE("online", 1),  //  可以线上使用的数据

    DELETE("delete", 400), // 放弃不用的数据
    IGNORE("ignore", 401), // 大流量店铺
    EXPIRD("expird", 402);  // 过期商品


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


