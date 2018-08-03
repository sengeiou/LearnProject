package com.cocoa.shiji.bean.h5;

/**
 * 手淘网页版的 api 的 json 实体类
 */
public class H5apiJson {
    private  String api;
    private  String v;
    private  H5apiData data;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public H5apiData getData() {
        return data;
    }

    public void setData(H5apiData data) {
        this.data = data;
    }
}
