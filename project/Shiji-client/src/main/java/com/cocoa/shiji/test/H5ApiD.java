package com.cocoa.shiji.test;

import com.google.gson.Gson;

public class H5ApiD {

    public String tce_sid = "1891397";
    public String tce_vid = "0";
    public String tid = "";
    public String tab = "0";
    public String topic = "60289_renqun_2018_index_489";
    public String count = "";
    public String psId = "60289";
    public String env = "online";
    public String groupId = "489";
    public String tabId = "";
    public String itemId = "559213745367";
    public String contentId = "";
    public String type = "";
    public String page = "0";
    public String size = "10";
    public String refresh = "false";
    public String from = "";
    public String bctype = "";
    public String orgid = "";
    public String src = "phone";


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
