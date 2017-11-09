package com.cococa.gradle.testgradle;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = (TextView) findViewById(R.id.textview);
        textview.setText(
                "appurl = " + BuildConfig.appurl + "\n\n" +
                        "LOG_DEBUG = " + BuildConfig.LOG_DEBUG + "\n\n" +
                        "pf_buildConfigField = " + BuildConfig.pf_buildConfigField + "\n\n" +
                        "appName = " + getString(R.string.appName) + "\n\n" +
                        "pf_value = " + getString(R.string.pf_value) + "\n\n" +
                        "metadata XXX_ID = " + getMetaData("XXX_ID")

        );


    }

    public String getMetaData(String name) {
        String channel = "";
        try {
            ApplicationInfo appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            channel = appInfo.metaData.getString(name);
        } catch (Exception e) {
            channel = e.getLocalizedMessage();
        }
        return channel;
    }

}
