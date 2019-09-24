package com.cocoa.wechat;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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

import static com.cocoa.wechat.R.id.wechat;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int REQUEST_EXTERNAL_STRONGE = 0X123;
    ArrayList<ArrayList<Object>> list;
    EditText code;
    TextView msg;
    boolean temp = false;

    public static String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=b2f5ced4839088ae5426b015ec4f46b9b5dad13f93a682590be7281be1dd54ed";
//    public static String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=47611548ad6b02af49318296e77f6a69bc839d6c95553525d638f386806be696";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = (EditText) findViewById(R.id.code);
        msg = (TextView) findViewById(R.id.msg);
        InputStream inStream = getResources().openRawResource(R.raw.wechat);
        list = ExcelUtil.readExcel2007(inStream);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 隐式调用系统设置界面
                Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
            }
        });
        findViewById(wechat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                temp = true;
                start();
            }
        });
        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    check();
                    index = Integer.parseInt(code.getText().toString());

                    if (index >= list.size()) {
                        Toast.makeText(MainActivity.this, "设置的行数大于excel的行数", Toast.LENGTH_LONG).show();
                        index = 1;
                        return;
                    }

                } catch (Exception e) {
                    index = 1;
                    Toast.makeText(MainActivity.this, "请设置正确的行数", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    static int index = 1;
    AtomicInteger atomicInteger = new AtomicInteger();

    static final Object o = new Object();

    @Override
    protected void onResume() {
        super.onResume();
        synchronized (o) {
            if (temp) {
                if (getSp()) {
                    setSp(false);
                    int preIndex = index - 1;
                    ArrayList<Object> item = list.get(preIndex);
                    String errorItem = item.get(0).toString() + "--" + item.get(1).toString() + "--" + item.get(2).toString();
                    doPost(errorItem + "   出现异常，请手动检查！！");
                }
                if (index <= 0 || index >= list.size()) {
                    Sender sender = new Sender("微信好友添加结束！");
                    String msg = new Gson().toJson(sender);
                    doPost(msg);
                    return;
                }
                Toast.makeText(MainActivity.this, "暂停60秒,防止频繁操作", Toast.LENGTH_LONG).show();
                ArrayList<Object> item = list.get(index);
                String s = item.get(0).toString() + "--" + item.get(1).toString() + "--" + item.get(2).toString();
                msg.setText("当前行号:" + (index) + "  即将添加:" + s.replace(".00", ""));

                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {

                        if ((index % 10) == 0) {
                            Thread.sleep(4 * 60 * 1000);
                        } else {
                            Thread.sleep(3 * 60 * 1000);
                        }
                        e.onComplete();

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
                                start();
                            }
                        });

            }

        }
    }

    public void start() {
        if (index <= 0 || index >= list.size()) {
            return;
        }
        ArrayList<Object> item = list.get(index);
        String s = item.get(0).toString() + "@@" + item.get(1).toString() + "@@" + item.get(2).toString();
        copy(s.replace(".00", ""));

        Intent intent = new Intent();
        ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(cmp);
        startActivity(intent);
        index++;

    }


    private void check() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, REQUEST_EXTERNAL_STRONGE);
        } else {
//            doPost();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//根据请求是否通过的返回码进行判断，然后进一步运行程序
        if (requestCode == REQUEST_EXTERNAL_STRONGE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            doPost();
        }

    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"我就是我, 是不一样的烟火\"}}";

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

    private void copy(String msg) {
        ClipboardManager c = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        c.setText(msg);
    }


    public boolean getSp() {
        return getApplication().getSharedPreferences("aaa123", MODE_PRIVATE).getBoolean("aaa123", false);
    }

    public void setSp(boolean b) {
        getApplication().getSharedPreferences("aaa123", MODE_PRIVATE).edit().putBoolean("aaa123", b).commit();
    }
}
