package dm.cocoa.com.downloadmanager.update;

/**
 * 更新检测时的回调
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.VersionCheckListener.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-30 18:22
 */
public interface VersionCheckListener {
    //开始检测更新
    public void onStart();

    //检测结束
    public void onEnd();

}
