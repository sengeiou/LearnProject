package com.cocoa.taobao.product_server.bean.content_img;

public enum ContentDetailType {

    IMG("img"),
    TXT("txt");

    private String value;
    private ContentDetailType( String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
