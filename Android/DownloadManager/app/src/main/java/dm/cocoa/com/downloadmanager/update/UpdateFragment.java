package dm.cocoa.com.downloadmanager.update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.io.File;

import dm.cocoa.com.downloadmanager.R;
import dm.cocoa.com.downloadmanager.update.bean.UpdateBo;
import dm.cocoa.com.downloadmanager.update.util.TextUtil;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.UpdateFragment.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-19 14:24
 */
public class UpdateFragment extends DialogFragment implements View.OnClickListener {


    public static final String CACHR_NAME = "VersionSP";
    public static final String CACHR_KEY = "VersionJSON";
    private boolean force = false;
    private UpdateBo mUpdateBo;
    private String url;
    private ProgressBar updateProgress;
    private TextView updateUpdate;
    private TextView updateCancle;

    private DownloadReceiver mDownloadReceiver = new DownloadReceiver();

    public static UpdateFragment getInstance(UpdateBo updateBo) {
        UpdateFragment f = new UpdateFragment();
        f.mUpdateBo = updateBo;
        f.url = updateBo.getApp_url();
        f.force = Constants.UPDATE_FORCE.equals(updateBo.getApp_force());
        f.force = true;
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_update_dialog, null);
        TextView updateContent = (TextView) view.findViewById(R.id.update_content);
        updateProgress = (ProgressBar) view.findViewById(R.id.update_progress);
        updateUpdate = (TextView) view.findViewById(R.id.update_update);
        updateCancle = (TextView) view.findViewById(R.id.update_cancle);
        updateContent.setText(mUpdateBo.getApp_desc());

        updateUpdate.setOnClickListener(this);
        updateCancle.setOnClickListener(this);
        getActivity().registerReceiver(mDownloadReceiver, new IntentFilter("com.cocoa.update"));
        if (force) {
            this.setCancelable(false);
            updateCancle.setVisibility(View.GONE);
        }

        builder.setView(view);
        Dialog dialog = builder.create();
        return dialog;
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void unregisterReceiver() {
        try {
            if (mDownloadReceiver != null) {
                getActivity().unregisterReceiver(mDownloadReceiver);
            }
        } catch (Exception E) {

        }
    }

    private void goToDownload(String url) {
        String parentFile = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intent intent = new Intent(getActivity().getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, url);
        intent.putExtra(Constants.APK_DOWNLOAD_NAME, parseName(url));
        intent.putExtra(Constants.APK_DOWNLOAD_FILE, parentFile);
        getActivity().startService(intent);
    }


    private void saveData(Context context, String json) {
        SharedPreferences sp = context.getSharedPreferences(CACHR_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(CACHR_KEY, json).commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update_cancle:
                this.dismiss();
                break;
            case R.id.update_update:
                goToDownload(url);
                if (!force) {   //不是强制更新，则可以关闭对话框
                    this.dismiss();
                }
                break;
            default:
                break;
        }
    }


    class DownloadReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            int progress = intent.getIntExtra("data", 0);
            String file = intent.getStringExtra("file");
            Log.d("-------", "--data--------" + progress);
            if (progress > 0 && progress <= 100) {
                updateProgress.setVisibility(View.VISIBLE);
                updateProgress.setProgress(progress);
            }
//            if (progress == 100 ) {
//                unregisterReceiver();
//            }
            if (file != null && file.length() > 0) {
                installAPK(new File(file));
//                unregisterReceiver();
            }

        }
    }

    private String parseName(String url) {
        if (TextUtil.isEmpty(url)) {
            return null;
        }
        int positon = url.lastIndexOf("/") + 1;
        int length = url.length();
        if (positon < length - 1) {
            return url.substring(positon,length);
        }
        return null;
    }


    private void installAPK(File file) {
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        startActivity(it);
    }

    private void installAPK(String file, String name) {
        File apkFile = new File(file, name);
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.setDataAndType(Uri.fromFile(apkFile),
                "application/vnd.android.package-archive");
        startActivity(it);
    }


}
