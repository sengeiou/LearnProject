package dm.cocoa.com.downloadmanager.update;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import dm.cocoa.com.downloadmanager.R;
import okhttp3.Call;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.DownloadService.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-19 16:37
 */
public class DownloadService extends Service {

    public static final String TAG = "DownloadService";
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;
    private int temp = 0;
    private String templater;
    private static final String SIGN ="%";
    private static final int MAX_PROGRESS = 100;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);
        templater = getString(R.string.update_is_download);
        int icon = getApplicationInfo().icon;
        mBuilder.setContentTitle(getString(R.string.update_updating)).setSmallIcon(icon);

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String urlStr = intent.getStringExtra(Constants.APK_DOWNLOAD_URL);
        String nameStr = intent.getStringExtra(Constants.APK_DOWNLOAD_NAME);
        String fileStr = intent.getStringExtra(Constants.APK_DOWNLOAD_FILE);
        download(urlStr, fileStr, nameStr);
        return super.onStartCommand(intent, flags, startId);
    }

    public void download(String url, String file, String name) {
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(file, name)//
                {
                    @Override
                    public void inProgress(float progress, long total) {
                        int progressInt = (int) (progress * MAX_PROGRESS);
                        Log.e(TAG, "progressInt :" + progressInt);
                        if (temp != progressInt) {
                            temp = progressInt;
                            mBuilder.setProgress(MAX_PROGRESS, temp, false);

                            mBuilder.setContentText(String.format(templater, temp) + SIGN);
                            PendingIntent pendingintent = PendingIntent.getActivity(DownloadService.this, 0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
                            mBuilder.setContentIntent(pendingintent);
                            mNotifyManager.notify(0, mBuilder.build());

                            Intent intent = new Intent("com.cocoa.update");
                            intent.putExtra("data", progressInt);
                            sendBroadcast(intent);


                        }
                    }

                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(File file) {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                        Intent intent = new Intent("com.cocoa.update");
                        intent.putExtra("file", file.toString());
                        sendBroadcast(intent);
                    }
                });
    }


}
