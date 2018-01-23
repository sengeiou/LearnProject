package com.cococa.shijitools;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cococa.shijitools.commit_bean.CommitItem;
import com.cococa.shijitools.resp_bean.RespObj;
import com.cococa.shijitools.resp_bean.RespTaoItem;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

//    static String path[] = {"https://item.taobao.com/item.htm?id=544540953852",
//            "https://item.taobao.com/item.htm?id=544215190961",
//            "https://item.taobao.com/item.htm?id=15821843045",
//            "https://item.taobao.com/item.htm?id=547768895331",
//            "https://item.taobao.com/item.htm?id=16767959816",
//            "https://item.taobao.com/item.htm?id=543947903264",
//            "https://item.taobao.com/item.htm?id=523210521138",
//    };

    static int url_index = 1;
    static int array_index = 0;
    static final int array_length = 20;
    private List<RespTaoItem> tempList = new ArrayList<>();

    static final String url
            = "/product/tb/list?pageSize=" + array_length + "&keywords=";

    String urlHost = "";
    EditText keywords;
    EditText logED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlHost = ((EditText) findViewById(R.id.server_url)).getText().toString();
        keywords = (EditText) findViewById(R.id.keywords);
        logED = (EditText) findViewById(R.id.log);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //打开系统设置中辅助功能
                    Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "找到SalesService，然后开启服务即可", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        findViewById(R.id.jump).
                setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           doClickJump();
                                       }
                                   }

                );
        findViewById(R.id.clear).
                setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           logED.setText("");
                                       }
                                   }

                );
  findViewById(R.id.reset).
                setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           url_index = 1;
                                           urlHost = ((EditText) findViewById(R.id.server_url)).getText().toString();
                                       }
                                   }

                );


        copy("");


    }


    public void appendLog(String msg) {
        logED.setText(logED.getText() + "\n" + msg);
    }


    private void doClickJump() {

        final String keywordsStr = keywords.getText().toString();
        if (TextUtils.isEmpty(keywordsStr)) {
            Toast.makeText(this, "请输入查找的关键字", Toast.LENGTH_SHORT).show();
            return;
        }

        if (tempList.size() == 0) {

            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                    Log.e("==---", Thread.currentThread().getName());
                    try {

                        OkHttpClient client = new OkHttpClient();



                        Request request = new Request.Builder()
                                .url(urlHost + url + keywordsStr + "&pageNo=" + url_index)
                                .build();

                        Response response = client.newCall(request).execute();
                        e.onNext(response.body().string());
                        Log.e("==---", "onnext");


                    } catch (Exception ex) {
                        Log.e("==---", ex.getMessage());
                    }
                }
            }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull String s) {
                            Log.e("==---", "onnext Observer" + s);
                            url_index++;
                            array_index = 0;
                            RespObj item = JSON.parseObject(s, RespObj.class);
                            tempList.addAll(item.getTbk_item_get_response().getResults().getN_tbk_item());
                            openTB();
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        } else {
            openTB();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        final String msg = getMsg();
        if (!TextUtils.isEmpty(msg)) {
            new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] params) {
                    try {
                        copy("");
                        CommitItem commitItem = new CommitItem(item);
                        commitItem.setSales(Integer.parseInt(msg));
                        String paramsStr = JSON.toJSONString(commitItem);

                        String url
                                = urlHost + "/product/tb/add?json=";

                        String urlEncode = URLEncoder.encode(paramsStr, "UTF-8");

                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(url + urlEncode)
                                .build();

                        Response response = client.newCall(request).execute();
                        String resultMsg = response.body().string();
                        Log.e("------", "resultMsg" + resultMsg);
                    } catch (Exception ex) {
                        Log.e("------", "resultMsg ex" + ex.toString());
                    }
                    return "";
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    appendLog(msg);
                    doClickJump();
                }
            }.execute("");
        }else{
            doClickJump();
        }
    }

    private String getMsg() {
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        return myClipboard.getText().toString();
    }

    private void copy(String msg) {
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        ClipData myClip = ClipData.newPlainText("text", msg);
        myClipboard.setPrimaryClip(myClip);
    }


    RespTaoItem item;

    private void openTB() {
        try {
            if (tempList.size() > 0 && array_index < tempList.size()) {
                openTaobaoClient(tempList.get(array_index).getItem_url());
                item = tempList.get(array_index);
                array_index++;
                if (array_index == array_length) {
                    tempList.clear();
                }
            }else{
                array_index = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void openTaobao() {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        String packageName = "com.taobao.taobao";
        String className = "com.taobao.tao.detail.activity.DetailActivity";
        intent.setClassName(packageName, className);

        Bundle bundle = new Bundle();
        bundle.putString("item_id", "546521914947");
        intent.putExtras(bundle);

        intent.putExtra("pid", android.os.Process.myPid());

        startActivityForResult(intent, 1);
        startActivity(intent);
    }


//    @Override
//    public void onClick(View view) {
//        String tobaoStore = "https://shop.m.taobao.com/shop/shop_index.htm?user_id=45241384&item_id=45111281658&spm=a1z3i.7c.0.ishopheader";
//        String path = "https://h5.m.taobao.com/awp/core/detail.htm?id=45111281658&abtest=30&rn=bf01c2ee009f8b0974b70541c6dd60b1&sid=1b8d1cbdfc2d075ccd646f909d801dae";
//        switch (view.getId()) {
//            case R.id.btn_opentaobao:
//                Toast.makeText(this, "打开淘宝", Toast.LENGTH_SHORT).show();
//                openTaobaoShopping(tobaoStore);
////                openTaobaoClient(tobaoStore);
////                open(tobaoStore);
//
//                break;
//        }
//    }

    private void openTaobaoHome() {
        String url = "https://h5.m.taobao.com/awp/core/detail.htm?id=45111281658&abtest=30&rn=bf01c2ee009f8b0974b70541c6dd60b1&sid=1b8d1cbdfc2d075ccd646f909d801dae"; // web address
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void openTaobaoClient(String goodsPath) {
        Intent intent = new Intent();
        intent.setAction("Android.intent.action.VIEW");
        Uri uri = Uri.parse(goodsPath); // 商品地址
        intent.setData(uri);
        intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
        startActivity(intent);
    }

    private void openTaobaoShopping(String goodspath) {
        if (checkPackage(this, "com.taobao.taobao")) {//判断用户手机是否装有淘宝客户端
            Log.e("Main", "执行1");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri uri = Uri.parse(goodspath);
            intent.setData(uri);
            intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
            startActivity(intent);
        } else {
            Log.e("Main", "执行2");
            openTaobaoHome();
        }
    }

    //检查有没有淘宝客户端
    public static boolean checkPackage(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName))
            return false;
        try {
            context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

    }

    private void open(String goodspath) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri uri = Uri.parse(goodspath);
        intent.setData(uri);
        startActivity(intent);
    }
}
