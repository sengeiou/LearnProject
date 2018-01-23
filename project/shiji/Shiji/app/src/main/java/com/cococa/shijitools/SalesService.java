package com.cococa.shijitools;

import android.accessibilityservice.AccessibilityService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.shiji.SalesService
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/8/11 16:53
 */
public class SalesService extends AccessibilityService {

    public static final String TAG = "salesService";

    public static final int MAX_SECOND = 1000 * 10;


    private Long startTime;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        Log.e(TAG, event.toString());
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:

                if (event.getClassName().equals("com.taobao.tao.detail.activity.DetailActivity")) {
                    startTime = System.currentTimeMillis();
                    performTaobaoDetailAction(event);
                } else if (event.getClassName().equals("com.cococa.shiji.MainActivity")) {
                    //performControllerAction(event);
                }
                break;
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                Log.e(TAG, event.toString());
                break;
            default:
                break;

        }


    }


    @Override
    public void onInterrupt() {

    }

    private void performControllerAction(AccessibilityEvent event) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            AccessibilityNodeInfo rootNodeInfo = getRootInActiveWindow();
            for (int i = 0; i < rootNodeInfo.getChildCount(); i++) {
                AccessibilityNodeInfo child = rootNodeInfo.getChild(i);
                if ("jump".equalsIgnoreCase(child.getText().toString())) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    child.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }

    private void listNode() {
        AccessibilityNodeInfo rootNodeInfo = getRootInActiveWindow();
        for (int i = 0; i < rootNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo child = rootNodeInfo.getChild(i);

            if (child.getClassName().toString().endsWith("ScrollView")) {
                Log.e("----", "start1" + child);
                printChildNodeInfo(child);
                while (TextUtils.isEmpty(result)) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if ((System.currentTimeMillis() - startTime) > MAX_SECOND) {
                        Log.e("----", "chaoshi");
                        break;
                    }
                    listNode();
                }
                break;
            }
        }
    }

    private String getMsg() {
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        return myClipboard.getText().toString();
    }

    private void performTaobaoDetailAction(AccessibilityEvent event) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            listNode();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            copy(result);
            result = "";
            // 返回
            performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);

        }
    }

    private void copy(String msg) {
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        ClipData myClip = ClipData.newPlainText("text", msg);
        myClipboard.setPrimaryClip(myClip);
    }


    String result = "";

    public void printChildNodeInfo(AccessibilityNodeInfo rootNodeInfo) {
        for (int i = 0; i < rootNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo child = rootNodeInfo.getChild(i);
            if (child != null) {
                if (child.getChildCount() == 0) {
                    try {
                        if (child != null && child.getText() != null) {
                            String msg = child.getText().toString();
                            if (msg.startsWith("月销") && msg.endsWith("笔")) {
                                result = msg.replace("月销", "").replace("笔", "");
                            }
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "the sales is " + e.toString());
                    }
                } else {
                    printChildNodeInfo(child);
                }
            }
        }
    }

}
