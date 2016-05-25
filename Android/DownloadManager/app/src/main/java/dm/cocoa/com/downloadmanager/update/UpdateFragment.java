package dm.cocoa.com.downloadmanager.update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Field;

import dm.cocoa.com.downloadmanager.R;
import dm.cocoa.com.downloadmanager.VersionUtil;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: dm.cocoa.com.downloadmanager.update.UpdateFragment.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-05-19 14:24
 */
public class UpdateFragment extends DialogFragment {

    public static final String URL = "http://120.55.185.35:8080/old.apk";

    public static final String CACHR_NAME = "VersionSP";
    public static final String CACHR_KEY = "VersionJSON";
    private boolean force = false;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_update_dialog, null);
        TextView updateContent = (TextView) view.findViewById(R.id.update_content);
        updateContent.setText("1.更新了什什么什么什么什么么 \n2.更新了什么 \n3.更新了什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么");

        builder.setView(view)
                // Add action buttons
                .setPositiveButton("更新",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                 goToDownload(URL);

                            }
                        });

        if (force) {
            this.setCancelable(false);
        } else {
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {



                    File dir = StorageUtils.getCacheDirectory(getActivity());
                    String apkName=URL.substring(URL.lastIndexOf("/")+1, URL.length());
                    File apkFile = new File(dir, apkName);



                    Intent it = new Intent(Intent.ACTION_VIEW);
                    it.setDataAndType(Uri.fromFile(apkFile),
                            "application/vnd.android.package-archive");

                    startActivity(it);

                }
            });
        }

        Dialog dialog = builder.create();
        return dialog;
    }


    private void goToDownload(String url) {
        Intent intent=new Intent(getActivity().getApplicationContext(),DownloadService2.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, url);
        getActivity().startService(intent);
    }



    public void show(Dialog dialog, boolean show) throws NoSuchFieldException, IllegalAccessException {
        Field field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
        field.setAccessible(true);
        field.set(dialog, show); // false - 使之不能关闭(此为机关所在，其它语句相同)
    }

    /**
     * 检测是否需要更新
     *
     * @param urlP     检测的url
     * @param contextP Context
     * @return
     */
    public boolean checkVersion(String urlP, Context contextP) throws JSONException {

        String json = "";

        JSONObject updateBo = new JSONObject(json);

        if (updateBo == null) {
            return false;
        }
        int currntVersionCode = VersionUtil.getVersionCode(contextP);
        int serverVersionCode = updateBo.optInt("code");

        if (serverVersionCode > 0 && currntVersionCode > 0 && serverVersionCode > currntVersionCode) {
            saveData(contextP, json);
            return true;
        }
        return false;
    }


    private void saveData(Context context, String json) {
        SharedPreferences sp = context.getSharedPreferences(CACHR_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(CACHR_KEY, json).commit();
    }


}
