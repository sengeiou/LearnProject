package com.cocoa.taobao.product_server.bean.sql;

import com.cocoa.taobao.product_server.bean.content_img.ContentDetail;
import com.cocoa.taobao.product_server.bean.h5.H5apiRate;
import com.cocoa.taobao.product_server.bean.rate.RateDetail;
import com.cocoa.taobao.product_server.bean.taocode.TaoCode;

import java.util.ArrayList;
import java.util.List;

public class BaseItem {
    public TaoCode taoCode;
    public H5apiRate rate;
    public List<ContentDetail> contentDetailList = new ArrayList<>();
    public List<RateDetail> rateDetailList = new ArrayList<>();
}
