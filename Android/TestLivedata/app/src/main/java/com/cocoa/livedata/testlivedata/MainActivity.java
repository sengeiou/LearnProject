package com.cocoa.livedata.testlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private UserProfileViewModel mUserProfileViewModel;

    private String userId = "1022";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        mUserProfileViewModel.init(userId);
        mUserProfileViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {

            }
        });

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserProfileViewModel.init(userId);
            }
        });
    }
}
