package com.cocoa.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by junshen on 2017/12/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected ViewDataBinding mViewDataBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        onActivityCreate(savedInstanceState);
    }

    public abstract int getLayoutId();

    public abstract void onActivityCreate(@Nullable Bundle savedInstanceState);
}
