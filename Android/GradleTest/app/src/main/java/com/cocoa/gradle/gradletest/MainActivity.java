package com.cocoa.gradle.gradletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.things.pio.PeripheralManagerService;
import com.google.android.things.userdriver.UserSensorDriver;
import com.google.android.things.userdriver.UserSensorReading;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeripheralManagerService peripheralManagerService =  new PeripheralManagerService();

        List<String> mList = peripheralManagerService.getPwmList();

        for(String gpioName : mList){
            Log.e("GPIO", gpioName);
        }


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("GPIO", "button clicked");

            }
        });

    }
}
