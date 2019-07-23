package com.cocoa.taobao.product_server.bean.sql;

import com.cocoa.taobao.product_server.bean.status.TBItemStatus;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "banner")
@Entity
public class IndexBanner {

    @Id
    private long id;

    @Column(name = "create")
    private Date create;

    @Column(name = "realid")
    private String realid;

    @Column(name = "type")
    private int type;

    @Column(name = "img")
    private String img;

    @Column(name = "msg")
    private String msg;

    @Column(name="status")
    private int status = TBItemStatus.ONLINE.getValue();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public String getRealid() {
        return realid;
    }

    public void setRealid(String realid) {
        this.realid = realid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
