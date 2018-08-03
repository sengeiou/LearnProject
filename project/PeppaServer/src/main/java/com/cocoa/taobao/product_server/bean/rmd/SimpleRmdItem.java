package com.cocoa.taobao.product_server.bean.rmd;


import java.util.List;

public class SimpleRmdItem extends BaseRmdItem{

    private List<SimpleRmdDetail> list;

    public List<SimpleRmdDetail> getList() {
        return list;
    }

    public void setList(List<SimpleRmdDetail> list) {
        this.list = list;
    }
}
