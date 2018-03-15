package com.cocoa.rmq_client.bean;


import com.cocoa.rmq_client.bean.sql.ShijiItem;

import java.util.List;

public class PageContent {
    private List<ShijiItem> content;

    public List<ShijiItem> getContent() {
        return content;
    }

    public void setContent(List<ShijiItem> content) {
        this.content = content;
    }
}
