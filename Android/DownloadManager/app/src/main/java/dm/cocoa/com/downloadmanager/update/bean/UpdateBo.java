package dm.cocoa.com.downloadmanager.update.bean;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.bean.UpdateBo.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-19 14:22
 */
public class UpdateBo {
   private String app_id;// 8,
           private String app_name;//private String ceshi",
           private String app_code;// 2,
           private String app_version;//private String 1.1.2",
           private String app_release;// 0,
           private String app_adate;// 0,
           private String app_type;// 1,
           private String app_url;//private String http:\/\/a5.pc6.com\/pc6_soure\/2016-4\/com.kqc.user_9.apk",
           private String app_desc;//private String hhahahaprivate String ,
           private String app_classify;// 1,
           private String app_force;// 0,  1 强制更新 0 不用强制更新
           private String upgrade_flag;// 1,
           private String deleted_at;// 0,
           private String created_at;//private String 1462344081",
           private String updated_at;//


    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getApp_release() {
        return app_release;
    }

    public void setApp_release(String app_release) {
        this.app_release = app_release;
    }

    public String getApp_adate() {
        return app_adate;
    }

    public void setApp_adate(String app_adate) {
        this.app_adate = app_adate;
    }

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getApp_desc() {
        return app_desc;
    }

    public void setApp_desc(String app_desc) {
        this.app_desc = app_desc;
    }

    public String getApp_classify() {
        return app_classify;
    }

    public void setApp_classify(String app_classify) {
        this.app_classify = app_classify;
    }

    public String getApp_force() {
        return app_force;
    }

    public void setApp_force(String app_force) {
        this.app_force = app_force;
    }

    public String getUpgrade_flag() {
        return upgrade_flag;
    }

    public void setUpgrade_flag(String upgrade_flag) {
        this.upgrade_flag = upgrade_flag;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "UpdateBo{" +
                       "app_id='" + app_id + '\'' +
                       ", app_name='" + app_name + '\'' +
                       ", app_code='" + app_code + '\'' +
                       ", app_version='" + app_version + '\'' +
                       ", app_release='" + app_release + '\'' +
                       ", app_adate='" + app_adate + '\'' +
                       ", app_type='" + app_type + '\'' +
                       ", app_url='" + app_url + '\'' +
                       ", app_desc='" + app_desc + '\'' +
                       ", app_classify='" + app_classify + '\'' +
                       ", app_force='" + app_force + '\'' +
                       ", upgrade_flag='" + upgrade_flag + '\'' +
                       ", deleted_at='" + deleted_at + '\'' +
                       ", created_at='" + created_at + '\'' +
                       ", updated_at='" + updated_at + '\'' +
                       '}';
    }
}
