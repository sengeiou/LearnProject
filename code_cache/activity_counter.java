package com.kqc.b2b.ui.base.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.kqc.b2b.ui.base.fragment.BaseFragment;
import com.kqc.b2b.ui.support.util.LogUtil;
import com.kqc.bundle.base.mvp.BasePresenter;
import com.kqc.bundle.ui.activity.AbsBaseActivity;
import com.kqc.bundle.widget.DialogBundle;

import net.sqlcipher.database.SQLiteDatabase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tuyx on 2016/4/22.
 */
public class BaseActivity extends AbsBaseActivity {

    public static final String TAG = BaseFragment.class.getSimpleName();


    private List<BasePresenter> mPresenters = new ArrayList<BasePresenter>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //加载加密数据库lib
        if (savedInstanceState != null) {
            SQLiteDatabase.loadLibs(getApplicationContext());
        }
        super.onCreate(savedInstanceState);
        //网络加载错误布局
        //尽量在isShowToolBar() 为true时使用，否则会全屏显示此页面

//        if (vsNetError != null) {
//            mRootView.addView(vsNetError);
//        }
        //检测基础数据是否初始化完成
        checkApplicationInitialized();
        //竖屏幕
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        //加入堆栈管理
//        ActivityManager.getInstance().push(this);


        Intent it = getIntent();


        Class clazzIt = it.getClass();
        Field[] fsIT = clazzIt.getDeclaredFields();
        if (fsIT != null) {
            for (Field f : fsIT) {
                if ("mComponent".equals(f.getName())) {
                    f.setAccessible(true);
                    try {
                        ComponentName mMap = (ComponentName) f.get(it);

                        Log.e("itititit", mMap.flattenToShortString() + "----");

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Bundle b = it.getExtras();
        if (b != null) {
            Class clazz = b.getClass();
            Field[] fs = clazz.getDeclaredFields();
            if (fs != null) {
                for (Field f : fs) {
                    if ("mMap".equals(f.getName())) {
                        f.setAccessible(true);
                        try {
                            ArrayMap<String, Object> mMap = (ArrayMap<String, Object>) f.get(b);

                            Set<String> keys = mMap.keySet();
                            for (String s : keys) {
                                Log.e("itititit", s+"----type-----"+mMap.get(s).getClass().getName());
                            }

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


    }

    /**
     * GrowingIo设置页面别名
     *
     * @param resId 标题资源Id
     */
    @Override
    public void getTitlePageNameId(int resId) {
//      GrowingIO.getInstance().setPageName(this, mContext.getString(resId));
        LogUtil.e("tag", mContext.getString(resId));
        Log.e("itititit", mContext.getString(resId)+"------"+getClass().getName());
    }

    @Override
    public void getTitlePageNameId(String title) {
        super.getTitlePageNameId(title);
//        GrowingIO.getInstance().setPageName(this, title);
        LogUtil.e("tag", title);

    }

    /**
     * 重写这个方法，避免Fragment 状态保留
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //尝试解决java.lang.UnsatisfiedLinkError
//        try {
//            //加载加密数据库lib
//            SQLiteDatabase.loadLibs(getApplicationContext());
//        } catch (Exception e) {
//            Log.e(TAG, e.getMessage(), e);
//            throw new RuntimeException("lib is already loaded!");
//        }
    }

    @Override
    public int getEmptyViewLayoutId() {
        return 0;
    }


    @Override
    public boolean isShowToolBar() {
        return false;
    }

    @Override
    public boolean isUseToolBarColor() {
        return false;
    }

    @Override
    public boolean isUseToolBarDrawable() {
        return true;
    }

    @Override
    public boolean isUseMenuImg() {
        return false;
    }

    @Override
    public boolean isUseMenuTxt() {
        return false;
    }

    @Override
    public void menuOnClickEvent() {

    }

    @Override
    public int getMenuImageResId() {
        return 0;
    }

    /**
     * 检测基础数据是否初始化完成
     */

    protected void checkApplicationInitialized() {
        //检测是否初始化完成，如果没有进行初始化，则跳到LaunchUI页面
        //目的是为了防止 App 被Kill，然后从Home返回App，导致Top Activity
        //显示，而Root Activity 没有 被onCreate 的错误，
        //http://stackoverflow.com/questions/14375720/android-destroying-activities-killing-processes
//        if (!ActivityManager.initialized()) {
//            //重启
//            ApplicationIo.getInstance(this).kill(true);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }


//    public void postMsg() {
//        SharedPreferences sp = getSharedPreferences("TEST_TEMP", Context.MODE_PRIVATE);
//
//        String radomStr = sp.getString("key", null);
//        if (radomStr == null) {
//            String base = "abcdefghijklmnopqrstuvwxyz0123456789";
//            Random random = new Random();
//            StringBuffer sb = new StringBuffer();
//            sb.append("修复成功_");
//            for (int i = 0; i < 10; i++) {
//                int number = random.nextInt(base.length());
//                sb.append(base.charAt(number));
//            }
//            radomStr = sb.toString();
//            sp.edit().putString("key", radomStr).commit();
//        }
//
//        String key = "equipment";
//        Toast.makeText(this, radomStr, Toast.LENGTH_SHORT).show();
//        KqcHttpClient.getInstance(mContext).postMsg(key, radomStr, new JsonCallback(this){
//            @Override
//            public void onResponse(JSONObject response) {
//                super.onResponse(response);
//                String s = null;
//            }
//
//            @Override
//            public void onError(Call call, Exception e) {
//                super.onError(call, e);
//                String ss = null;
//            }
//        });
//    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterPresenter();
//        ActivityManager.getInstance().remove(this);
    }

    /**
     * 注册Presenter
     *
     * @param presenter
     */
    protected void registerPresenter(BasePresenter presenter) {
        if (!mPresenters.contains(presenter)) {
            mPresenters.add(presenter);
        }
    }

    /**
     * 注销Presenter、执行onDestroy
     */
    protected void unregisterPresenter() {
        int size = mPresenters.size();
        for (int i = 0; i < size; i++) {
            mPresenters.get(i).onDestroy();
        }
        mPresenters.clear();
    }


    /**
     * 显示TOAST
     */
    public void showToast(final String text) {
        if (!TextUtils.isEmpty(text) && !isActivityDestroyed && mContext != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new DialogBundle.ToastDialog.Builder(mContext).setAlert(text).build().show();
                }
            });
        }
    }

    /**
     * 显示TOAST
     */
    public void showToast(final int resId) {
        if (resId > 0) {
            if (!isActivityDestroyed && mContext != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new DialogBundle.ToastDialog.Builder(mContext).setAlert(resId).build().show();
                    }
                });
            }
        }
    }

    /**
     * 隐藏软键盘输入
     */
    public void hideSoftKeyboard() {
        InputMethodManager manager = ((InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE));
        if (manager != null && getCurrentFocus() != null) {
            manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    /**
     * 显示输入键盘
     */
    public void showSoftKeyboard(View view) {
        if (view != null) {
            view.requestFocus();
            InputMethodManager manager = ((InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE));
            if (manager != null) {
                manager.showSoftInput(view, InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        }
    }

    /**
     * Activity 管理类
     *//*
    public static class ActivityManager {

        //实例
        volatile static ActivityManager instance;
        //Activity 堆栈
        Stack<Activity> activityStack = new Stack<Activity>();

        *//**
     * 初始化
     *//*
        static public void initialize() {
            if (instance == null) {
                synchronized (ApplicationIo.class) {
                    if (instance == null) {
                        instance = new ActivityManager();
                    }
                }
            }
        }

        *//**
     * 是否初始化过该IO
     *//*
        public static synchronized boolean initialized() {
            return instance != null;
        }

        *//**
     * 获取对象
     *//*
        static public ActivityManager getInstance() {
            if (instance == null) {
                throw new RuntimeException(String.format("initialized %s ?", BaseActivity.class.getName()));
            }
            return instance;
        }

        *//**
     * 添加一个 Activity
     *//*
        public void push(Activity activity) {
            activityStack.push(activity);
        }

        *//**
     * 删除一个Activity
     *//*
        public void remove(Activity activity) {
            activityStack.remove(activity);
        }

        public int activityStackSize() {
            return activityStack.size();
        }

        *//**
     * 清空Activity，仅仅剩下指定的Activity， 且只有一个实例
     *//*
        public void remain(Class<?>... remainClzArray) {
            Set<String> clzNameSet = new HashSet<String>();
            //去重
            for (Class<?> clz : remainClzArray) {
                clzNameSet.add(clz.getName());
            }
            Iterator<Activity> iterator = activityStack.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next();
                if (!clzNameSet.contains(activity.getClass().getName())) {
                    //不在留存的集合中
                    //finish
                    activity.finish();
                    //删除
                    iterator.remove();
                } else {
                    //仅仅留下一个
                    clzNameSet.remove(activity.getClass().getName());
                }
            }
        }
    }*/
}
