package com.cocoa;

import java.util.Arrays;

public class H5apiItem {

    public String itemId;// "522844070204",
    public String title;// "天天特价 即食烤虾干山东特产零食虾干大对虾干虾仁250g海鲜包邮",
    public String subtitle;// "",
    public String[] images;
    public String categoryId;// "50009559",
    public String rootCategoryId;// "50002766",
    public String brandValueId;// "9565805",
    public Object countMultiple;//[],
    public String commentCount;// "17",
    public String favcount;// "206",
    public String taobaoDescUrl;// "http;////h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=522844070204&type=0&f=TB1e82mcFTM8KJjSZFl8quO8Fla&sellerType=C",
    public String tmallDescUrl;// "//mdetail.tmall.com/templates/pages/desc?id=522844070204",
    public String taobaoPcDescUrl;// "http;////h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=522844070204&type=1&f=TB1iCOEb6gy_uJjSZPx8qunNpla&sellerType=C"

    @Override
    public String toString() {
        return "H5apiItem{" +
                "itemId='" + itemId + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", images=" + Arrays.toString(images) +
                ", categoryId='" + categoryId + '\'' +
                ", rootCategoryId='" + rootCategoryId + '\'' +
                ", brandValueId='" + brandValueId + '\'' +
                ", countMultiple=" + countMultiple +
                ", commentCount='" + commentCount + '\'' +
                ", favcount='" + favcount + '\'' +
                ", taobaoDescUrl='" + taobaoDescUrl + '\'' +
                ", tmallDescUrl='" + tmallDescUrl + '\'' +
                ", taobaoPcDescUrl='" + taobaoPcDescUrl + '\'' +
                '}';
    }
}
