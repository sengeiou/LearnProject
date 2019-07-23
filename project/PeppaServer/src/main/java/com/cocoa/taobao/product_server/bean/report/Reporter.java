package com.cocoa.taobao.product_server.bean.report;


public class Reporter {

//    void report(String msg, LogLevel level, Plat plat);
    private LogLevel logLevel;
    private String title;
    private String msg;
    private String msgUrl;
    private String num_iid;


    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Reporter(LogLevel logLevel, String title, String msg,String num_iid) {
        this.num_iid = num_iid;
        this.logLevel = logLevel;
        this.title = title;
        this.msg = msg;
    }


//class Plat {
//    public final static Plat SERVER = new Plat("SERVER");
//    public final static Plat CLIENT = new Plat("CLIENT");
//
//    private String plat;
//
//    public Plat(String plat) {
//        this.plat = plat;
//    }
//}


}