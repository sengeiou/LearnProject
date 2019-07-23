package com.cocoa.taobao.product_server.bean.rmd;


import java.util.Date;
import java.util.List;

public class BaseRmdItem {

    private String _id;
    private long createDate;
    private long updateDate;
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
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

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "BaseRmdItem{" +
                "_id='" + _id + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", bannerImg='" + bannerImg + '\'' +
                ", likeCount=" + likeCount +
                ", viewCount=" + viewCount +
                '}';
    }
}
