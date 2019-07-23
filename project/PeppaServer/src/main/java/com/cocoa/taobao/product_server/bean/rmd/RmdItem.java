package com.cocoa.taobao.product_server.bean.rmd;


import java.util.List;

public class RmdItem extends BaseRmdItem{

    private List<RmdDetail> list;

    public List<RmdDetail> getList() {
        return list;
    }

    public void setList(List<RmdDetail> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return super.toString()+"   RmdItem{" +
                "list=" + list +
                '}';
    }
}
