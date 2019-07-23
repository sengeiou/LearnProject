package com.cocoa.taobao.product_server.bean.client;

public class BasicRespData {

    private BasicParams basicParams;
    private SearchParams searchParams;
    private InsertParams insertParams;

    public BasicParams getBasicParams() {
        return basicParams;
    }

    public void setBasicParams(BasicParams basicParams) {
        this.basicParams = basicParams;
    }

    public SearchParams getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(SearchParams searchParams) {
        this.searchParams = searchParams;
    }

    public InsertParams getInsertParams() {
        return insertParams;
    }

    public void setInsertParams(InsertParams insertParams) {
        this.insertParams = insertParams;
    }
}
