package com.cocoa.taobao.product_server.bean.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.stereotype.Repository;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import java.util.List;

public class ContentImg {


    private List<String> imgs;

    public ContentImg() {

    }

    public ContentImg(List<String> imgs) {
        this.imgs = imgs;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
