package com.cocoa.taobao.product_server.bean.h5;

public class H5apiData {


    public H5apiNameValue[] apiStack;// // 基本信息
    public H5apiItem item;// 基本信息
    public String mockData;// "{"delivery";//{},"feature";//{},"price";//{"price";//{"priceText";//"60.00"}},"skuCore";//{"sku2info";//{"0";//{"price";//{"priceMoney";//6000,"priceText";//"60.00","priceTitle";//"价格"},"quantity";//100}},"skuItem";//{"hideQuantity";//true}},"trade";//{"buyEnable";//true,"cartEnable";//true}}",
    public H5apiParams params;// + {... },
    public Object props;// key value 形式 暂时不用
    public Object props2;//{},  为空，暂时不用
    public H5apiRate rate;// + 评论
    public Object resource;// 提问相关的，不用
    public H5apiSeller seller;//  卖家信息相关
    public Object skuBase;// 暂时不用， 包含两个子类 skus: sku 相关,  props: 尺码相关
    public Object vertical;// 暂时不用，提问相关
}
