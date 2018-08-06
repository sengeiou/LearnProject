package com.cocoa.taobao.product_server.bean.status;

import java.util.ArrayList;
import java.util.List;

/**
 * Recommend 的状态枚举
 */
public enum RecommendStatus {


    ONLINE("online", 1), // 上线的
    top("top", 2), // 置顶
    OFFLINE("offline", 400); // 下线



    private String des;
    private int value;

    RecommendStatus(String des, int value) {
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

    public static RecommendStatus getStatus(String statusStr) {
        for (RecommendStatus status : RecommendStatus.values()) {
            if (status.des.equals(statusStr)) {
                return status;
            }
        }
        return null;
    }

    public static List<StatusTemp> getStatusInfo() {
        List<StatusTemp> statusList = new ArrayList<>(RecommendStatus.values().length + 1);
        for (RecommendStatus status : RecommendStatus.values()) {
            statusList.add(new StatusTemp(status.getDes(), status.getValue()));
        }
        return statusList;
    }
}


