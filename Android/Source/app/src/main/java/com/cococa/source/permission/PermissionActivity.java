package com.cococa.source.permission;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cococa.source.R;

import java.io.File;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.source.permission.PermissionActivity
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/8/10 13:51
 */
@RuntimePermissions
public class PermissionActivity extends AppCompatActivity {

    private String sdPath;//SD卡的路径
    private String picPath;//图片存储路径


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        findViewById(R.id.readSDCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionActivityPermissionsDispatcher.showReadFileWithCheck(PermissionActivity.this);
            }
        });
    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void showReadFile() {
        sdPath = Environment.getExternalStorageDirectory().getPath();
        picPath = sdPath + "/" + "temp.png";

        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uri = Uri.fromFile(new File(picPath));
        //为拍摄的图片指定一个存储的路径
        intent2.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent2, 0x12);
    }

//    @OnShowRationale(Manifest.permission.CAMERA)
//     void showReadFileHao(final PermissionRequest request){
//        new AlertDialog.Builder(this)
//                .setMessage(R.string.app_name)
//                .setPositiveButton(R.string.app_name, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        request.proceed();
//                    }
//                })
//                .setNegativeButton(R.string.app_name, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        request.cancel();
//                    }
//                })
//                .show();
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        // NOTE: delegate the permission handling to generated method
//        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
//    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void showDeniedForRead() {
        Toast.makeText(this, "showDeniedForRead", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void showNeverAskForRead() {
        Toast.makeText(this, "showNeverAskForRead", Toast.LENGTH_SHORT).show();
    }


}
