package dm.cocoa.com.downloadmanager.update.bean;

import dm.cocoa.com.downloadmanager.update.Constants;
import dm.cocoa.com.downloadmanager.update.util.TextUtil;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.bean.UpdateBo.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-19 14:22
 */
public class UpdateResult {

    private String code;
    private String msg;
    private UpdateBo data;


    public boolean isSuccess() {
        return Constants.UPDATE_JSON_SUCCESS.equals(code);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UpdateBo getData() {
        return data;
    }

    public void setData(UpdateBo data) {
        this.data = data;
    }
}
