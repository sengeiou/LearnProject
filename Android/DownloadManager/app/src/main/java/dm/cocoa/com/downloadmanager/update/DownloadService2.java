package dm.cocoa.com.downloadmanager.update;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.DownloadService2.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-19 16:37
 */
public class DownloadService2 extends Service {

    public static final String TAG = "DownloadService2";
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;
    private int temp = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    String url;

    @Override
    public void onCreate() {
        super.onCreate();
        mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);

        String appName = getString(getApplicationInfo().labelRes);
        int icon = getApplicationInfo().icon;

        mBuilder.setContentTitle(appName).setSmallIcon(icon);

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String urlStr = intent.getStringExtra("url");

        download(urlStr);

        return super.onStartCommand(intent, flags, startId);
    }

    public void download(String url) {

        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "haha.apk")//
                {
                    @Override
                    public void inProgress(float progress, long total) {
                        int progressInt = (int) (progress * 100);
                        Log.e(TAG, "progressInt :" + progressInt);
                        if (temp != progressInt) {
                            temp = progressInt;
                            mBuilder.setProgress(100, temp, false);

                            String templater  =  "已下载%s";


                            mBuilder.setContentText(String.format(templater,temp)+"%");
                            PendingIntent pendingintent = PendingIntent.getActivity(DownloadService2.this, 0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
                            mBuilder.setContentIntent(pendingintent);
                            mNotifyManager.notify(0, mBuilder.build());
                        }
                    }

                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(File file) {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }


}
