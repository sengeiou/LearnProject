package com.cocoa.shiji.bean.rmd;


import java.util.List;

public class RmdDetail {

    private String title;
    private List<RmdDetailContent> contentList;
    private String num_iid;
    private String pic;
    private String price;

    public RmdDetail() {

    }

    public RmdDetail(String tilte,String price, String num_iid, String pic) {
        this.title = tilte;
        this.num_iid = num_iid;
        this.price = price;
        this.pic = pic;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RmdDetailContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<RmdDetailContent> contentList) {
        this.contentList = contentList;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
