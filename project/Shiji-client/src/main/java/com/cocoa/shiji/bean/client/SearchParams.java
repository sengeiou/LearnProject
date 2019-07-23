package com.cocoa.shiji.bean.client;

public class SearchParams extends BaseParams {

    private String keywords;
    private int pageSize = 20;
    private int pageIndex = 0;
    private int maxPageIndex = 1000;  // 最大的查询条数
    private String listUrl;
    private String updateUrl;
    private int currntIndex;


    public int getCurrntIndex() {
        return currntIndex;
    }

    public void setCurrntIndex(int currntIndex) {
        this.currntIndex = currntIndex;
    }

    public String getListUrl() {
        return listUrl;
    }

    public void setListUrl(String listUrl) {
        this.listUrl = listUrl;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxPageIndex() {
        return maxPageIndex;
    }

    public void setMaxPageIndex(int maxPageIndex) {
        this.maxPageIndex = maxPageIndex;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public String toString() {
        return "{" +
                "kw-'" + keywords + '\'' +
                ", s-" + pageSize +
                ", -" + currntIndex +
                ", i-" + pageIndex +
                ", mI-" + maxPageIndex +
                ", -" + sleepTime +
                ", -'" + listUrl + '\'' +
                ", -'" + updateUrl + '\'' +
                '}';
    }
}
