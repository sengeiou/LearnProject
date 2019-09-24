package com.cocoa.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cocoa.broadcastreceiver.TestReceiver1
 * @author: shenjun@kuaiqiangche.com
 * @date: 16/10/26 11:02
 */
public class TestReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("----","test receiver 2222");
    }
}
