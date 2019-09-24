package com.cocoa.livedata.testdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    User user;

    @Inject
    User admin;

    UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userComponent = DaggerUserComponent.create();
        userComponent.inject(this);
        Log.e("----", user.toString());
        Log.e("----", admin.toString());
    }


}
