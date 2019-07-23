package com.cocoa.wechat;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.cocoa.wechat.MainActivity.WEBHOOK_TOKEN;

/**
 * Created by junshen on 2017/12/1.
 * <p>
 * https://oapi.dingtalk.com/robot/send?access_token=b2f5ced4839088ae5426b015ec4f46b9b5dad13f93a682590be7281be1dd54ed
 */

public class FriendsService extends AccessibilityService {

    public static final String TAG = "friends-service";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e(TAG, event.getEventType() + "---" + event.getPackageName() + "=====" + event.getClassName().toString());
        switch (event.getEventType()) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:

                String className = event.getClassName().toString();
                if ("com.tencent.mm.ui.LauncherUI".equalsIgnoreCase(className)) {
                    //index page
                    Log.e(TAG, event.getEventType() + "---" + event.getPackageName() + "===1==");
                    if (TextUtils.isEmpty(getClipData())) {
                        // 没有数据，就返回上一页面，说明是从最后的一个页面来的
                        // back
                        clickBackKey();
                    } else {
                        listNodes(getRootInActiveWindow());
                    }
                } else if ("com.tencent.mm.plugin.search.ui.FTSMainUI".equalsIgnoreCase(className)) {
                    //  搜索

                    if (TextUtils.isEmpty(getClipData())) {
                        // 没有数据，就返回上一页面，说明是从最后的一个页面来的
                        clickBackKey();

                    } else {

                        listEdit(getRootInActiveWindow());

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                List<AccessibilityNodeInfo> list = findNodesByText("查找");
                                for (AccessibilityNodeInfo accessibilityNodeInfo : list) {
                                    accessibilityNodeInfo.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                                }
                            }
                        }, 3000);
                    }

                } else if ("com.tencent.mm.ui.base.i".equalsIgnoreCase(className)) {
                    doPost("查找失败--" + MainActivity.index + "-" +getClipData() + " (请检查微信账号或检查是否操作频繁)");
                    notFoundId("com.tencent.mm:id/akt");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            clickBackKey();
                        }
                    }, 3000);

                } else if ("com.tencent.mm.plugin.profile.ui.ContactInfoUI".equalsIgnoreCase(className)) {
                    // friends detail

                    if (TextUtils.isEmpty(getClipData())) {
                        // 没有数据，就返回上一页面，说明是从最后的一个页面来的
                        clickBackKey();
                    } else {
                        listNodeText("com.tencent.mm:id/am8");
                    }

                } else if ("com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI".equals(className)) {
                    // search
                    if (!TextUtils.isEmpty(getClipData())) {
                        //这个页面可能会进入两次，进入空的判断
                        doPost("已发送添加请求--" + MainActivity.index + "-" + getClipData());
                    }
                    editTag("com.tencent.mm:id/cr2"); // 添加备注
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            clickNodeText("com.tencent.mm:id/h1");
                            copy("");
                        }
                    }, 3000);

                }


                break;
            default:
                break;
        }
    }

    /**
     * 通过ID获取控件，并进行模拟点击
     *
     * @param clickId
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void inputClick(String clickId) {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(clickId);
            for (AccessibilityNodeInfo item : list) {
                item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }

    /**
     * 根据Text搜索所有符合条件的节点, 模糊搜索方式
     */
    public void listNodes(final AccessibilityNodeInfo nodeInfo) {
        if ("搜索".equals(nodeInfo.getContentDescription())) {
            nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            return;
        }
        for (int i = 0; i < nodeInfo.getChildCount(); i++) {
            listNodes(nodeInfo.getChild(i));
        }
    }


    /**
     * 首页搜索界面返回按钮
     */
    public void listBackNodes(final AccessibilityNodeInfo nodeInfo) {
        if ("返回".equals(nodeInfo.getContentDescription())) {
            nodeInfo.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickBackKey();
                }
            }, 1000);
            return;
        }
        for (int i = 0; i < nodeInfo.getChildCount(); i++) {
            listBackNodes(nodeInfo.getChild(i));
        }
    }


    public void listAddNodes(AccessibilityNodeInfo nodeInfo) {
        Log.e(TAG, "listAddNodes=" + nodeInfo.getClassName() + "=======" + nodeInfo.getChildCount() + "--");
        if (nodeInfo.getClassName().toString().contains("ListView")) {
            Log.e(TAG, "listAddNodes=" + nodeInfo.getChildCount());
            nodeInfo.getChild(1).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            return;
        }
        for (int i = 0; i < nodeInfo.getChildCount(); i++) {
            listAddNodes(nodeInfo.getChild(i));
        }
    }

    /**
     * 添加到通讯录  com.tencent.mm:id/am8
     *
     * @param clickId
     */
    public void listNodeText(String clickId) {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            List<AccessibilityNodeInfo> list = rootNode.findAccessibilityNodeInfosByViewId(clickId);

            if (list == null || list.size() == 0) {
                // 已经是好友了，直接返回
                doPost("已经是好友--" + MainActivity.index + "-" + getClipData());
                copy("");
                clickBackKey();
                return;
            }

            for (AccessibilityNodeInfo nodeInfo : list) {
                // 点击添加 ，进入下一页面
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }


    /**
     * 没有改账号  com.tencent.mm:id/akt
     *
     * @param clickId
     */
    public void notFoundId(String clickId) {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            List<AccessibilityNodeInfo> list = rootNode.findAccessibilityNodeInfosByViewId(clickId);
            copy("");
            if (list != null && list.size() > 0) {
                for (AccessibilityNodeInfo nodeInfo : list) {
                    nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }

            }
        }
    }


    public void clickNodeText(String clickId) {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            List<AccessibilityNodeInfo> list = rootNode.findAccessibilityNodeInfosByViewId(clickId);
            for (AccessibilityNodeInfo nodeInfo : list) {
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }


    public void listEdit(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo.getClassName().toString().contains("EditText")) {

            String nameAndId = getClipData();
            String[] nameIdArray = nameAndId.split("@@");
            copy(nameIdArray[2]);

            Bundle arguments = new Bundle();
            arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
                    AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD);
            arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
                    true);
            nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY,
                    arguments);
            nodeInfo.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
            nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PASTE);

            copy(nameIdArray[1] + "-" + nameIdArray[0]);
            return;
        }
        for (int i = 0; i < nodeInfo.getChildCount(); i++) {
            listEdit(nodeInfo.getChild(i));
        }
    }


    public void editTag(String clickId) {

        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            List<AccessibilityNodeInfo> list = rootNode.findAccessibilityNodeInfosByViewId(clickId);
            for (AccessibilityNodeInfo nodeInfo : list) {
//                Bundle arguments = new Bundle();
//                arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
//                        AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD);
//                arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
//                        true);
//                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY,
//                        arguments);
//                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
//                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PASTE);

                Bundle arguments = new Bundle();

                arguments.putCharSequence(
                        AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
                        getClipData());

                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);


            }
        }

    }


    /**
     * 根据Text搜索所有符合条件的节点, 模糊搜索方式
     */
    public List<AccessibilityNodeInfo> findNodesByText(String text) {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            return nodeInfo.findAccessibilityNodeInfosByText(text);
        }
        return null;
    }

    public boolean clickBackKey() {
        return performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
    }


    private void copy(String msg) {
        ClipboardManager c = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        c.setText(msg);
    }

    private String getClipData() {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        return clipboardManager.getText().toString();
    }

    @Override
    public void onInterrupt() {
        int index = MainActivity.index;
        doPost("--程序终止--Excel行号:" + MainActivity.index);
        Toast.makeText(this, "被打断了啊", Toast.LENGTH_LONG).show();
    }

    public boolean getSp() {
        return getApplication().getSharedPreferences("123", MODE_PRIVATE).getBoolean("123", false);
    }

    public void setSp(boolean b) {
        getApplication().getSharedPreferences("123", MODE_PRIVATE).edit().putBoolean("123", b).commit();
    }


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().header("Content-Type", "application/json; charset=utf-8")
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private void doPost(final String textMsg) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Sender sender = new Sender(textMsg);
                String s = post(WEBHOOK_TOKEN, new Gson().toJson(sender));
                Log.e("---", "---" + s);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    private int i;
                    private Disposable mDisposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
