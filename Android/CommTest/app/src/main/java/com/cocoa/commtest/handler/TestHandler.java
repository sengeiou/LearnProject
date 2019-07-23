package com.cocoa.commtest.handler;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cocoa.commtest.R;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cocoa.commtest.handler.TestHandler
 * @author: shenjun@kuaiqiangche.com
 * @date: 16/9/12 15:54
 */
public class TestHandler  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_handler);
        Handler handler = new Handler();

    }
}
