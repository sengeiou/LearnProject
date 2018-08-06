package com.cocoa.taobao.product_server.bean.taobao;

import com.cocoa.taobao.product_server.bean.sql.ShijiItem;

import javax.persistence.Column;
import javax.persistence.Id;

public class TaobaoRespItem {

    private String item_url;//private String http:\/\/taobao.com\/htm?id=43189047510",
    private String nick;//private String 双钱旗舰店",
    private String num_iid;// 43189047510,
    private String pict_url;//private String http:\/\/img1.tbcdn.cn\/tfscom\/i2\/2355948914\/TB1R_QWKFXXXXXUXXXXXXXXXXXX_!!0-item_pic.jpg",
    private String provcity;//private String 广西 梧州",
    private String reserve_price;//private String 69.00",
    private String seller_id;// 2355948914,
    private TaobaoSmallimg small_img ;// {
    private String title;//private String 双钱龟苓膏原味易拉罐礼盒|7月生产|250克X12罐",
    private int user_type;// 1,
    private String volume;// 3153,
    private String zk_final_price;//private String 41.80"

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getPict_url() {
        return pict_url;
    }

    public void setPict_url(String pict_url) {
        this.pict_url = pict_url;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public String getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(String reserve_price) {
        this.reserve_price = reserve_price;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public TaobaoSmallimg getSmall_img() {
        return small_img;
    }

    public void setSmall_img(TaobaoSmallimg small_img) {
        this.small_img = small_img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }
    
    public ShijiItem convert(){
        ShijiItem shijiItem = new ShijiItem();
        shijiItem.setNum_iid(getNum_iid());
        shijiItem.setNick(getNick());
        shijiItem.setItem_url(getItem_url());
        shijiItem.setPict_url(getPict_url());
        shijiItem.setProvcity(getProvcity());
        shijiItem.setReserve_price(getReserve_price());
        shijiItem.setSeller_id(getSeller_id());
        shijiItem.setTitle(getTitle());
        shijiItem.setUser_type(getUser_type());
        shijiItem.setVolume(getVolume());
        shijiItem.setZk_final_price(getZk_final_price());
        Long currentTime = System.currentTimeMillis();
        shijiItem.setCreate_time(currentTime);
        shijiItem.setSales_update_time(currentTime);


        TaobaoSmallimg img = getSmall_img();
        if (img != null && img.getString() != null && img.getString().size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String imgUrl : img.getString()) {
                sb.append(imgUrl + "@@");
            }
            shijiItem.setSmall_images(sb.substring(0, sb.length() - 2));
        }
        return shijiItem;
    }
    
    
    
}
