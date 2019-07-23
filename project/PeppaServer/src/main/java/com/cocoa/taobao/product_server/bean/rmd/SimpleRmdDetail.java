package com.cocoa.taobao.product_server.bean.rmd;


public class SimpleRmdDetail {

    private String title;
    private String num_iid;
    private String pic;

    public SimpleRmdDetail() {

    }

    @Override
    public String toString() {
        return "SimpleRmdDetail{" +
                "title='" + title + '\'' +
                ", num_iid='" + num_iid + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

    public SimpleRmdDetail(String title, String num_iid, String pic) {
        this.title = title;
        this.num_iid = num_iid;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
