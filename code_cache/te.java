package com.kqc.b2b.ui.splash;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.growingio.android.sdk.collection.GrowingIO;
import com.kqc.b2b.R;
import com.kqc.b2b.io.app.ApplicationIo;
import com.kqc.b2b.io.http.constant.ResponseCst;
import com.kqc.b2b.io.http.model.splash.SplashImg;
import com.kqc.b2b.io.kv.KvIo;
import com.kqc.b2b.io.mcr.McrIo;
import com.kqc.b2b.ui.base.activity.BaseActivity;
import com.kqc.b2b.ui.main.MainActivity;

import java.util.Timer;

import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements SplashView, Runnable, View.OnClickListener {
    //请求读取通讯录权限code
    static final int REQUEST_CODE_REQUEST_PERMISSION = 1000;
    //外部启动目标intent
    static final String GOTO_INTENT = "GOTO_INTENT";

    public static boolean CLICK_FLAG = false;

    public static final int MESSAGE_UPDATE = 0x123;


    //加载样式图片
    Handler handler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case MESSAGE_UPDATE:

                    String secStr = (String) msg.obj;
                    if (splashBreak != null) {
                        splashBreak.setVisibility(View.VISIBLE);
                        splashBreak.setText(secStr + " " + getString(R.string.breakstr));
                    }

                    break;
                default:
                    break;
            }


        }
    };

    @Override
    public boolean isShowToolBar() {
        return false;
    }


    private ImageView splashImg;
    private TextView splashBreak;

    private SplashPresenter<SplashImg> splashPresenter;


    private boolean STOP_TAG = false;  // activity  停止标志 ，


    /**
     * 从App外部启动主页面
     *
     * @param context    上下文
     * @param gotoIntent 启动主页后,立即跳转的页面, 可以为空, gotoIntent才会生效
     */
    static public Intent startAppOutside(Context context, @Nullable Intent gotoIntent) {
        Intent intent = new Intent(context, SplashActivity.class);
        //添加模拟HOME进入的标志
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        if (gotoIntent != null) {
            intent.putExtra(GOTO_INTENT, gotoIntent);
        }
        //从外部进入，则还需要添加NEW_TASK, 避免App被杀死，无法进入的问题
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        return intent;
    }

    private Timer timer;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        {
            splashPresenter = new SplashPresenter<>(this, mContext);
            registerPresenter(splashPresenter);
        }

        splashImg = (ImageView) findViewById(R.id.splash_img);
        splashImg.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.app_splash));
        splashBreak = (TextView) findViewById(R.id.splash_break);


        //初始化
        ApplicationIo.getInstance(getApplicationContext()).tryInitializeCore();
        //GrowingIo统计页面显示
        GrowingIO.getInstance().setPageName(SplashActivity.this, mContext.getString(R.string.splash));

        delayedToMainActivity();
        splashBreak.setOnClickListener(this);
        splashImg.setOnClickListener(this);


//         每次启动app , 都从缓存去找广告位的图片,暂时不做
//        SplashImg splashImg = SplashImgCache.getImg(this);
//        if (splashImg != null) {
//            loadImg(splashImg.getImage()); // 加载广告图片
//        }
        //获取最新的广告图片信息,成功后显示
        splashPresenter.getStartUpImg();

        // 从外部url 进入，传递进mainActivity，需要进行页面跳转
        jsonStr = getIntent().getStringExtra(ResponseCst.MSG);

        if (!TextUtils.isEmpty(jsonStr)) {
            CLICK_FLAG = true;
        }

    }


    String jsonStr;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.splash_img:
                Object o = splashImg.getTag(R.id.splash_img); //加载了广告才能点击
                if (o != null) {

                }

                break;
            case R.id.splash_break:
                try {
                    handler.removeCallbacks(SplashActivity.this);//取消默认的3秒加载图片
                    handler.removeCallbacks(timeRunnable);  //取消加载图片后的3秒倒计时
                    startMainActivity();
                } catch (Exception e) {
                }
                break;
            default:
                break;

        }
    }

    /**
     * 延迟跳转到主页面
     * 并行请求广告位图片  3秒内请求到广告图后，会取消这个延迟的runnable
     */
    private void delayedToMainActivity() {
        //跳转
        handler.postDelayed(this, 3000);
    }


    private void startMainActivity() {
        //判断是不是第一次安装
        if (KvIo.getInstance(getApplicationContext()).getKv(KvIo.ProfileKv.class).getIsFirstInstall()) {
            Log.d(SplashActivity.class.getName(), "获取读取联系人权限");
            McrIo.getInstance(getApplicationContext()).readContact();
            KvIo.getInstance(getApplicationContext()).getKv(KvIo.ProfileKv.class).setIsFirstInstall(false);
        }

        Intent gotoIntent = getIntent().getParcelableExtra(GOTO_INTENT);
        if (gotoIntent != null) {
            //外部启动
            MainActivity.startAppOutside(mContext, gotoIntent);
        } else {
            //正常启动
            MainActivity.startMe(mContext, CLICK_FLAG, jsonStr);
        }
        CLICK_FLAG = false; // 清空点击事件的tag ，解决部分手机再次进入CLICK_FLAG 为true 的情况
        SplashActivity.this.finish();
    }


    private void loadImg(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!STOP_TAG) {
            splashImg.setTag(R.id.splash_img, url); //设置tag ，后续的点击事件要依赖这个tag
            Glide.with(this)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.mipmap.app_splash)
                    .error(R.mipmap.app_splash)
                    .into(splashImg);
        }
    }


    /**
     * 申请权限
     */
    void applyForPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            //已经授权
            delayedToMainActivity();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_REQUEST_PERMISSION);
            //没有权限,判断是否会弹权限申请对话框
            boolean shouldShow = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS);
            if (shouldShow) {
                //申请权限
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_REQUEST_PERMISSION);
            } else {
                //被禁止
                delayedToMainActivity();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_REQUEST_PERMISSION) {
            delayedToMainActivity();
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //permission granted
//
//            } else {
//                //permission denied
//            }
        } else {
            finish();
        }
    }

    /**
     * 避免检测，因为是第一个页面
     */
    @Override
    protected void checkApplicationInitialized() {
        //初始化该页面
//        ActivityManager.initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onBackPressed() {
        //不能进行回退
    }


    @Override
    public void onLoadStart() {

    }

    @Override
    public void onLoadAfter() {

    }


    @Override
    public void onStop() {
        super.onStop();
        STOP_TAG = true;
    }

    @Override
    public void onSplashImgSuccess(SplashImg res) {
        if (res != null) {
            handler.removeCallbacks(SplashActivity.this);
            SplashImgCache.cacheImg(this, res);
            loadImg(res.getImage()); // 加载广告图片
            delayedToMainActivity();
            startTimer();
        }
    }

    private TimeRunnable timeRunnable;

    private void startTimer() {
        timeRunnable = new TimeRunnable();
        new Thread(timeRunnable).start();
    }


    @Override
    public void onSplashImgError(String error) {

    }

    /**
     * 默认跳转到主页
     */
    @Override
    public void run() {
        startMainActivity();
    }


    /**
     * 广告倒计时
     */
    class TimeRunnable implements Runnable {
        private int count = 3;

        @Override
        public void run() {
            while (count != 0) {
                Message msg = new Message();
                msg.obj = String.valueOf(count);
                msg.what = MESSAGE_UPDATE;
                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
            }
        }
    }

}
piccolo:inject error javassist.NotFoundException: onClick(..) is not found in com.kqc.b2b.ui.logic.palacechoice.ProvinceActivity$4$1
piccolo:methodInstanceStr com.kqc.b2b.support.util.Logger.onItemClicked(this.this$0,intent,adapterView,view,position);