package com.cocoa.taobao.product_server.bean.rmd;


import java.util.Date;
import java.util.List;

public class BaseRmdItem {

    private String _id;
    private long createData;
    private int status;
    private String title;
    private String bannerImg;
    private int likeCount = 0;
    private int viewCount = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public long getCreateData() {
        return createData;
    }

    public void setCreateData(long createData) {
        this.createData = createData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "BaseRmdItem{" +
                "_id='" + _id + '\'' +
                ", createData=" + createData +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", bannerImg='" + bannerImg + '\'' +
                ", likeCount=" + likeCount +
                ", viewCount=" + viewCount +
                '}';
    }
}
