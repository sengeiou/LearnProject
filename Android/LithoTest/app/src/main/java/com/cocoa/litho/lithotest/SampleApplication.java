package com.cocoa.litho.lithotest;

import android.app.Application;

/**
 * Created by junshen on 2017/9/13.
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this,false);
    }
}
