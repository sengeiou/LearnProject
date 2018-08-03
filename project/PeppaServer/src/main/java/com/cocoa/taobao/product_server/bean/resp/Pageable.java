package com.cocoa.taobao.product_server.bean.resp;

import java.io.Serializable;
import java.util.List;

public class Pageable implements Serializable {

    private long total;
    private Object content;
    private Object ext1;

    public Object getExt1() {
        return ext1;
    }

    public void setExt1(Object ext1) {
        this.ext1 = ext1;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
