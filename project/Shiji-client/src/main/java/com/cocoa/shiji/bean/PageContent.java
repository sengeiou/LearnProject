package com.cocoa.shiji.bean;


import com.cocoa.shiji.bean.sql.ShijiItem;

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
