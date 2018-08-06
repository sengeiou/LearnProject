package com.cocoa.taobao.product_server.bean.status;

import java.util.ArrayList;
import java.util.List;

/**
 * taobao_item 的状态枚举
 */
public enum ShopStatus {


    NEW("new", 0),  // 刚添加
    ONLINE("online", 1), // 上线的
    OFFLINE("offline", 400); // 下线

    private String des;
    private int value;

    ShopStatus(String des, int value) {
        this.des = des;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "des='" + des + '\'' +
                ", value=" + value +
                '}';
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

    public static ShopStatus getStatus(String statusStr) {
        for (ShopStatus status : ShopStatus.values()) {
            if (status.des.equals(statusStr)) {
                return status;
            }
        }
        return null;
    }

    public static List<StatusTemp> getStatusInfo() {
        List<StatusTemp> statusList = new ArrayList<>(ShopStatus.values().length + 2);
        for (ShopStatus status : ShopStatus.values()) {
            statusList.add(new StatusTemp(status.getDes(), status.getValue()));
        }
        return statusList;
    }

}


