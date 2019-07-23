package com.cocoa.taobao.product_server.bean.h5;

public class H5apiSellerEvaluates {
    public String title;// "宝贝描述",
    public String score;// "4.8 ",
    public String type;// "desc",
    public String level;// "1"

    @Override
    public String toString() {
        return "H5apiSellerEvaluates{" +
                "title='" + title + '\'' +
                ", score='" + score + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
