package com.cocoa.taobao.product_server.bean.index;

import com.cocoa.taobao.product_server.bean.sql.IndexBanner;
import com.cocoa.taobao.product_server.bean.sql.IndexRecommond;
import com.cocoa.taobao.product_server.bean.sql.ShijiItem;
import org.springframework.data.domain.Page;

import java.util.List;

public class IndexResult {

    private Page<IndexBanner> banner;
//    private List<SimpleRmdList> recommond;
    private Page<ShijiItem> itemList;

    public Page<IndexBanner> getBanner() {
        return banner;
    }

    public void setBanner(Page<IndexBanner> banner) {
        this.banner = banner;
    }

//    public List<SimpleRmdList> getRecommond() {
//        return recommond;
//    }
//
//    public void setRecommond(List<SimpleRmdList> recommond) {
//        this.recommond = recommond;
//    }

    public Page<ShijiItem> getItemList() {
        return itemList;
    }

    public void setItemList(Page<ShijiItem> itemList) {
        this.itemList = itemList;
    }
}
