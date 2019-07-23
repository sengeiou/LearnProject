package com.cocoa.shiji.bean.mongo;

/*
 真实的mongo 存储的类，所有数据都是这样，真实的数据以 json 的形式存在 data 字段中
 */
public class MongoResult {

    public String data;
    public Long date;
    public String fm_date;
    public String num_iid;

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getFm_date() {
        return fm_date;
    }

    public void setFm_date(String fm_date) {
        this.fm_date = fm_date;
    }
}
