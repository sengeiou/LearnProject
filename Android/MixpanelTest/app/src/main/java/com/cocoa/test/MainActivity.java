package com.cocoa.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.xxxxxxxxxxx);
        Button xx = (Button) findViewById(R.id.xx);
        TextView tv = (TextView) findViewById(R.id.tv);
        ImageView img = (ImageView) findViewById(R.id.img);
        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_LONG).show();

            }
        });

        tv.setOnClickListener(this);
        img.setOnClickListener(this);
        linear.setOnClickListener(this);
        xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("--------","xx");

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                Log.e("--------","tv");
                break;
            case R.id.linear:
                Log.e("--------","linear");
                break;

            default:
                break;


        }
    }




}
