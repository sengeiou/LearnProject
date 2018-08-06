package com.cocoa.taobao.product_server.bean.sql;


import javax.persistence.*;
import java.util.Date;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.shiji.commit_bean.CommitItem
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/8/23 11:49
 */



@Table(name = "taobao_item" )

@Entity
public class CommitItem extends ShijiResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name="status")
    private int status;
    @Column(name="search_kw")
    private String search_kw;
    @Column(name="tb_from")
    private int tb_from;


    public Object[] getSqlParams() {
        return new Object[]{item_url, nick, num_iid, pict_url, provcity, reserve_price, seller_id, small_img, title, user_type, volume, zk_final_price, sales, sales_update_time, create_time, status,search_kw};
    }


    public CommitItem() {

    }

    public int getFrom() {
        return tb_from;
    }

    public void setFrom(int tb_from) {
        this.tb_from = tb_from;
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



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSearch_kw() {
        return search_kw;
    }

    public void setSearch_kw(String search_kw) {
        this.search_kw = search_kw;
    }
}
