package com.cocoa.shiji.bean.rmd;

import java.util.Date;
import java.util.List;

public class RmdList {

    private List<RmdDetail> detailList;
    private Date date;
    private long dateLong;
    private String title;
    private String[] bannerImg;

    private long likeCount = 0L;
    private long viewCount = 0L;


    public long getDateLong() {
        return dateLong;
    }

    public void setDateLong(long dateLong) {
        this.dateLong = dateLong;
    }

    public List<RmdDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<RmdDetail> detailList) {
        this.detailList = detailList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String[] bannerImg) {
        this.bannerImg = bannerImg;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }
}
