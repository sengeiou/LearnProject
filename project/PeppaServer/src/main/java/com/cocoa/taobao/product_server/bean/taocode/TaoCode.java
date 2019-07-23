package com.cocoa.taobao.product_server.bean.taocode;

public class TaoCode {

    private String clickUrl;//https://s.click.taobao.com/t?e=m%3D2%26s%3D8W0DBxEvjiwcQipKwQzePOeEDrYVVa64K7Vc7tFgwiHjf2vlNIV67r5yHEGgmVFy8FptwqKhdbHwF85t35Ty34FD6bh9d7Ay0fRPrtWpsxiYL4FePZzoq2KwnKbZSFuIzzRZ2L75aq%2B5Ll4iK81ro%2FjRhh9YLbxFomfkDJRs%2BhU%3D&pvid=10_115.236.163.114_4459_1524817629706",
    private String couponLink;//",
    private String tkCommonRate;//2.00",
    private String taoToken;//￥OAKp0HUl0z5￥",
    private String qrCodeUrl;////gqrcode.alicdn.com/img?type=hv&text=https%3A%2F%2Fs.click.taobao.com%2FgK1qXRw%3Faf%3D3&h=300&w=300",
    private String type;//auction",
    private String couponShortLinkUrl;//": null,
    private String shortLinkUrl;//https://s.click.taobao.com/gK1qXRw"


    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getCouponLink() {
        return couponLink;
    }

    public void setCouponLink(String couponLink) {
        this.couponLink = couponLink;
    }

    public String getTkCommonRate() {
        return tkCommonRate;
    }

    public void setTkCommonRate(String tkCommonRate) {
        this.tkCommonRate = tkCommonRate;
    }

    public String getTaoToken() {
        return taoToken;
    }

    public void setTaoToken(String taoToken) {
        this.taoToken = taoToken;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCouponShortLinkUrl() {
        return couponShortLinkUrl;
    }

    public void setCouponShortLinkUrl(String couponShortLinkUrl) {
        this.couponShortLinkUrl = couponShortLinkUrl;
    }

    public String getShortLinkUrl() {
        return shortLinkUrl;
    }

    public void setShortLinkUrl(String shortLinkUrl) {
        this.shortLinkUrl = shortLinkUrl;
    }
}
