package com.cococa.shijitools.commit_bean;

import com.cococa.shijitools.resp_bean.RespSmallImage;
import com.cococa.shijitools.resp_bean.RespTaoItem;

import java.util.Date;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.shiji.commit_bean.CommitItem
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/8/23 11:49
 */
//CREATE TABLE `taobao_item` (
//        `id` int(11) NOT NULL,
//        `item_url` varchar(120) COLLATE utf8_bin DEFAULT NULL,
//        `nick` varchar(80) COLLATE utf8_bin DEFAULT NULL,
//        `num_iid` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        `pict_url` varchar(120) COLLATE utf8_bin DEFAULT NULL,
//        `provcity` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        `reserve_price` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        `seller_id` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        `small_images` varchar(400) COLLATE utf8_bin DEFAULT NULL,
//        `title` varchar(120) COLLATE utf8_bin DEFAULT NULL,
//        `user_type` int(11) DEFAULT NULL,
//        `volume` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        `zk_final_price` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        `sales` int(11) DEFAULT NULL,
//        `sales_update_time` datetime DEFAULT NULL,
//        `create_time` datetime DEFAULT NULL,
//        `item_id` varchar(45) COLLATE utf8_bin DEFAULT NULL,
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

public class CommitItem {

    private String item_url;//private String http:\/\/item.taobao.com\/item.htm?id=43189047510",
    private String nick;//private String 双钱旗舰店",
    private String num_iid;// 43189047510,
    private String pict_url;//private String http:\/\/img1.tbcdn.cn\/tfscom\/i2\/2355948914\/TB1R_QWKFXXXXXUXXXXXXXXXXXX_!!0-item_pic.jpg",
    private String provcity;//private String 广西 梧州",
    private String reserve_price;//private String 69.00",
    private String seller_id;// 2355948914,
    private String small_img = "";// {
    private String title;//private String 双钱龟苓膏原味易拉罐礼盒|7月生产|250克X12罐",
    private String user_type;// 1,
    private String volume;// 3153,
    private String zk_final_price;//private String 41.80"
    private int sales;
    private Date sales_update_time;
    private Date create_time;
    private String item_id;  // 商品id


    public Object[] getSqlParams() {
        return new Object[]{item_url, nick, num_iid, pict_url, provcity, reserve_price, seller_id, small_img, title, user_type, volume, zk_final_price, sales, sales_update_time, create_time, item_id};
    }


    public CommitItem() {

    }

    public CommitItem(RespTaoItem respTaoItem) {
        this.item_url = respTaoItem.getItem_url();
        this.nick = respTaoItem.getNick();
        this.num_iid = respTaoItem.getNum_iid();
        this.pict_url = respTaoItem.getPict_url();
        this.provcity = respTaoItem.getProvcity();
        this.reserve_price = respTaoItem.getReserve_price();
        this.seller_id = respTaoItem.getSeller_id();

        RespSmallImage img = respTaoItem.getSmall_images();
        if (img != null) {
            String[] imgArray = img.getString();
            if (imgArray != null && imgArray.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : imgArray) {
                    sb.append(str).append("@@");
                }
                this.small_img = sb.substring(0, sb.length() - 1);
            }
        }

        this.title = respTaoItem.getTitle();
        this.user_type = respTaoItem.getUser_type();
        this.volume = respTaoItem.getVolume();
        this.zk_final_price = respTaoItem.getZk_final_price();
    }


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

    public String getSmall_img() {
        return small_img;
    }

    public void setSmall_img(String small_img) {
        this.small_img = small_img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Date getSales_update_time() {
        return sales_update_time;
    }

    public void setSales_update_time(Date sales_update_time) {
        this.sales_update_time = sales_update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
