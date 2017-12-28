package com.cocoa.shiji;

import android.app.Application;
import android.util.Log;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.facebook.soloader.SoLoader;

/**
 * Created by junshen on 2017/12/27.
 * http://console.baichuan.taobao.com/authimg.htm?spm=a3c0d.8115102.0.0&appId=111057
 *
 * https://developer.android.com/topic/libraries/data-binding/index.html  databinding
 *
 */

public class ShijiApplication extends Application {

    public static final String TAG = "ShijiApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this,false);
        AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                Log.e(TAG, "alibc---" + "success");
            }

            @Override
            public void onFailure(int code, String msg) {
                Log.e(TAG, "alibc---" + msg + code);
            }
        });

    }
}
