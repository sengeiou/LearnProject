package com.cocoa.taobao.product_server.bean.sql;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
//        `id` int(11) NOT NULL AUTO_INCREMENT,
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
//        `status` int(11) NOT NULL DEFAULT '0',
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=10580 DEFAULT CHARSET=utf8 COLLATE=utf8_bin


@Table(name = "taobao_item")
@Entity
public class CommitItem {

    @Id
    private long id;
    @Column(name = "item_url")
    private String item_url;//private String http:\/\/item.taobao.com\/item.htm?id=43189047510",
    @Column(name = "nick")
    private String nick;//private String 双钱旗舰店",
    @Column(name = "num_iid")
    private String num_iid;// 43189047510,
    @Column(name = "pict_url")
    private String pict_url;//private String http:\/\/img1.tbcdn.cn\/tfscom\/i2\/2355948914\/TB1R_QWKFXXXXXUXXXXXXXXXXXX_!!0-item_pic.jpg",
    @Column(name = "provcity")
    private String provcity;//private String 广西 梧州",
    @Column(name = "reserve_price")
    private String reserve_price;//private String 69.00",
    @Column(name = "seller_id")
    private String seller_id;// 2355948914,
    @Column(name = "small_images")
    private String small_img = "";// {
    @Column(name = "title")
    private String title;//private String 双钱龟苓膏原味易拉罐礼盒|7月生产|250克X12罐",
    @Column(name = "user_type")
    private String user_type;// 1,
    @Column(name = "volume")
    private String volume;// 3153,
    @Column(name = "zk_final_price")
    private String zk_final_price;//private String 41.80"
    @Column(name = "sales")
    private int sales;
    @Column(name = "sales_update_time")
    private Date sales_update_time;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "item_id")
    private String item_id;  // 商品id
    @Column(name="status")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object[] getSqlParams() {
        return new Object[]{item_url, nick, num_iid, pict_url, provcity, reserve_price, seller_id, small_img, title, user_type, volume, zk_final_price, sales, sales_update_time, create_time, item_id,status};
    }


    public CommitItem() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
