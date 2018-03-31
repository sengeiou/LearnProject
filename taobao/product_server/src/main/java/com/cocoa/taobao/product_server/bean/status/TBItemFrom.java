package com.cocoa.taobao.product_server.bean.status;

public enum TBItemFrom {

    DEFAULT(-1,"default"), // 默认或未知
    TKAPI(0,"toaboke_api"), // 淘宝客商品搜索 api
    FIND_ID(1,"find_id"),   // 根据商品id 加入（一般为人工寻找）
    RECOMMEND(2,"recommend")// 淘宝客商品推荐 api
    ;

    private int value;
    private String des;

    TBItemFrom(int value, String des) {
        this.value = value;
        this.des = des;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
