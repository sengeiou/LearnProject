package dm.cocoa.com.downloadmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.utils.L;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import dm.cocoa.com.downloadmanager.update.UpdateFragment;
import dm.cocoa.com.downloadmanager.update.UpdateManager;
import dm.cocoa.com.downloadmanager.update.VersionCheckListener;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://120.55.185.35:8080/old.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      final ImageView img = (ImageView) findViewById(R.id.img);
//
//        OkHttpUtils
//                .get()//
//                .url("http://image.kuaiqiangche.com/data/attachment/2016-04-26/o_1ah8asnbk9uc17931tajgek5fb7.jpg")//
//                .build()//
//                .execute(new BitmapCallback()
//                {
//
//                    @Override
//                    public void onError(Call call, Exception e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Bitmap bitmap)
//                    {
//                        img.setImageBitmap(bitmap);
//                    }
//                });
        Glide.with(this)
//                    .load(temp.getImage_src())
//                .load("http://image.kuaiqiangche.com/data/attachment/2016-04-26/o_1ah8asnbk9uc17931tajgek5fb7.jpg")
                .load("http://120.55.185.35:8080/o_1ah8asnbk9uc17931tajgek5fb7.jpg")
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
//                    .crossFade()
                .into(img);

        final FragmentManager fm = getSupportFragmentManager();
//        String name = VersionUtil.getVersionName(this);
//        int code = VersionUtil.getVersionCode(this);
//        Log.e("--", name + "---------" + code);
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://new_api.kuaiqiangche.cc/app/check_version";
                Map<String, String> map = new HashMap<String, String>();
                map.put("version", "1.0.0");
                map.put("client_type", "mobile_android");
                map.put("client_os_type", "23");

                Map<String, String> heads = new HashMap<String, String>();
                heads.put("Accept", "version=1.0.1&client_type=wap");

                final UpdateManager updateManager = new UpdateManager(url, map, heads, 1, fm, MainActivity.this);
                updateManager.getLastVersion(new VersionCheckListener() {
                    @Override
                    public void onStart() {
                        Toast.makeText(MainActivity.this, "startCheck", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEnd() {
                        Toast.makeText(MainActivity.this, "endCheck", Toast.LENGTH_SHORT).show();
                        boolean show = updateManager.checkVersion();
//                        Toast.makeText(MainActivity.this,"endCheck---"+show,Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });


    }


}