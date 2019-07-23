package com.cocoa.shiji.bean.client;

public class InsertParams  extends BaseParams {

    private String listUrl; //get items from taobao
    private String listParamsStatus = "prepared";
    private String updateParamsStatus = "inserted";
    private String insertUrl; // add shiji
    private String num_iid;
    private String updateUrl ; // update taobao


    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getListUrl() {
        return listUrl;
    }

    public void setListUrl(String listUrl) {
        this.listUrl = listUrl;
    }

    public String getListParamsStatus() {
        return listParamsStatus;
    }

    public void setListParamsStatus(String listParamsStatus) {
        this.listParamsStatus = listParamsStatus;
    }

    public String getUpdateParamsStatus() {
        return updateParamsStatus;
    }

    public void setUpdateParamsStatus(String updateParamsStatus) {
        this.updateParamsStatus = updateParamsStatus;
    }

    public String getInsertUrl() {
        return insertUrl;
    }

    public void setInsertUrl(String insertUrl) {
        this.insertUrl = insertUrl;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }
}
