package com.cocoa.taobao.product_server.bean.rate;

public class RateDetail {

    private String num_iid;
    private String auctionSku;// "口味:（原味）1盒+（抹茶味）1盒",
    private String gmtCreateTime;// 1525875795000,
    private String[] pics;//
    private String rateContent;//": "快递是顺丰冷链物流的，所以隔天就到了，里面有冰袋放着的，到手里芝士还是冰的。口感可以说是相当棒了，好利来的芝士不是吹的，但是不适合吃多的，一次就差不多只能吃两个，这样也不会吃腻，也不会吃太胖，个人更喜欢抹茶味的芝士，哎反正每个味道各有各的味道！都是好吃的！",
    private String rateDate;// "2018-05-09 22:23:15",


    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getAuctionSku() {
        return auctionSku;
    }

    public void setAuctionSku(String auctionSku) {
        this.auctionSku = auctionSku;
    }

    public String getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(String gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public String[] getPics() {
        return pics;
    }

    public void setPics(String[] pics) {
        this.pics = pics;
    }

    public String getRateContent() {
        return rateContent;
    }

    public void setRateContent(String rateContent) {
        this.rateContent = rateContent;
    }

    public String getRateDate() {
        return rateDate;
    }

    public void setRateDate(String rateDate) {
        this.rateDate = rateDate;
    }
}
