package com.cocoa.taobao.product_server.bean.sql;

import com.cocoa.taobao.product_server.bean.content_img.ContentDetail;
import com.cocoa.taobao.product_server.bean.h5.H5apiRate;
import com.cocoa.taobao.product_server.bean.rate.RateDetail;
import com.cocoa.taobao.product_server.bean.taocode.TaoCode;

import java.util.ArrayList;
import java.util.List;

public class ShijiResult {
    private TaoCode taoCode;
    private H5apiRate rate;
    private List<ContentDetail> contentDetailList = new ArrayList<>();
    private List<RateDetail> rateDetailList = new ArrayList<>();
    private ShijiItem shijiItem;

    public TaoCode getTaoCode() {
        return taoCode;
    }

    public void setTaoCode(TaoCode taoCode) {
        this.taoCode = taoCode;
    }

    public H5apiRate getRate() {
        return rate;
    }

    public void setRate(H5apiRate rate) {
        this.rate = rate;
    }

    public List<ContentDetail> getContentDetailList() {
        return contentDetailList;
    }

    public void setContentDetailList(List<ContentDetail> contentDetailList) {
        this.contentDetailList = contentDetailList;
    }

    public List<RateDetail> getRateDetailList() {
        return rateDetailList;
    }

    public void setRateDetailList(List<RateDetail> rateDetailList) {
        this.rateDetailList = rateDetailList;
    }

    public ShijiItem getShijiItem() {
        return shijiItem;
    }

    public void setShijiItem(ShijiItem shijiItem) {
        this.shijiItem = shijiItem;
    }
}
