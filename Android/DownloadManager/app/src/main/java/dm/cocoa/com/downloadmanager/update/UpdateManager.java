package dm.cocoa.com.downloadmanager.update;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Map;

import dm.cocoa.com.downloadmanager.R;
import dm.cocoa.com.downloadmanager.update.bean.UpdateBo;
import dm.cocoa.com.downloadmanager.update.util.TextUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.UpdateManager.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-30 17:20
 */
public class UpdateManager {

    private static final String DEFAULT_METHOD = "set";
    private static final String DEFAULT_JSON_CODE = "code";
    private static final String DEFAULT_JSON_DATA = "data";
    private static final String DEFAULT_CODE_SUCCESS = "0";
    private String updateUrl;
    private Map<String, String> params;
    private Map<String, String> heads;
    private int currentVersion;
    private final OkHttpClient client = new OkHttpClient();
    private UpdateBo mUpdateBo;
    private FragmentManager fm;
    private Context mContext;

    /**
     * @param updateUrl      更新的URL
     * @param params         get的参数
     * @param heads          get的head参数
     * @param currentVersion 当前的app的版本
     * @param fm             FragmentManager
     */
    public UpdateManager(String updateUrl, Map<String, String> params, Map<String, String> heads, int currentVersion, FragmentManager fm, Context context) {
        this.updateUrl = updateUrl;
        this.mContext = context;
        this.params = params;
        this.heads = heads;
        this.currentVersion = currentVersion;
        this.fm = fm;
    }


    /**
     * 有更新内容时显示的对话框
     */
    public void showUpdateDialog() {
        if (mUpdateBo == null || !checkVersion(false)) {
            throw new NullPointerException("not update");
        }
        UpdateFragment updateFragment =  UpdateFragment.getInstance(mUpdateBo );
        updateFragment.show(fm, "UpdateFragment");
    }


    /**
     * 检查版本
     *
     * @param showDialog 是否需要显示更新框，如果
     * @return 是否需要更新
     */
    public boolean checkVersion(boolean showDialog) {
        if (mUpdateBo == null) {
            return false;
        }
        String appcode = mUpdateBo.getApp_code();
        if (TextUtil.isEmpty(appcode)) {
            return false;
        }
        int appcodeInt = Integer.parseInt(appcode);
        if (appcodeInt > currentVersion) {
            if (showDialog) {
                showUpdateDialog();
            }
            return true;
        } else {
            if (showDialog) {
                Toast.makeText(mContext, R.string.update_no_newversion, Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }


    /**
     * 检查版本，如果有新版本，默认跳出更新对话框
     */
    public boolean checkVersion() {
        return checkVersion(true);
    }


    /**
     * 获取最新的版本
     *
     * @param versionCheckListener 检测时的回调
     */
    public void getLastVersion(final VersionCheckListener versionCheckListener) {
        OkHttpUtils.get().params(params).url(updateUrl).headers(heads).build().execute(new com.zhy.http.okhttp.callback.Callback<UpdateBo>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                if (versionCheckListener != null) {
                    versionCheckListener.onStart();
                }
            }

            @Override
            public void onAfter() {
                super.onAfter();
                if (versionCheckListener != null) {
                    versionCheckListener.onEnd();
                }
            }

            @Override
            public UpdateBo parseNetworkResponse(Response response) throws Exception {
                JSONObject jsonObject = new JSONObject(response.body().string());
                String codeStr = jsonObject.optString(DEFAULT_JSON_CODE);
                if (DEFAULT_CODE_SUCCESS.equals(codeStr)) {
                    JSONObject dataJsonObj = jsonObject.getJSONObject(DEFAULT_JSON_DATA);
                    if (dataJsonObj != null) {
                        Class boClass = UpdateBo.class;
                        Method[] methods = boClass.getDeclaredMethods();
                        UpdateBo bo = new UpdateBo();
                        for (Method f : methods) {
                            String fName = f.getName();
                            if (fName.startsWith(DEFAULT_METHOD)) {
                                String fieldName = fName.replace(DEFAULT_METHOD, "").toLowerCase();
                                f.invoke(bo, dataJsonObj.optString(fieldName));
                            }
                        }
                        return bo;
                    }
                }
                return null;
            }

            @Override
            public void onError(Call call, Exception e) {
                Log.d("--------", "---onError----");
            }

            @Override
            public void onResponse(UpdateBo response) {
                if (response != null) {
                    mUpdateBo = response;
                }
            }
        });
    }

    /**
     * 获取最新的版本信息
     *
     * @return
     */
    public UpdateBo getUpdateBo() {
        return mUpdateBo;
    }


}
