package com.cocoa.shiji.bean.client;

public class BasicParams {
    private String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=ba895b6c33bc212547af72395d37dd29f246bd337ceab884e63491d8099f2a09";
    private String baseUrl;


    public String getDingUrl() {
        return dingUrl;
    }

    public void setDingUrl(String dingUrl) {
        this.dingUrl = dingUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
