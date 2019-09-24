package com.cocoa.retrofit.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button start;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        msg = (TextView)findViewById(R.id.msg);

        if(TextUtils.isEmpty(getIntent().getStringExtra("ss"))){
            msg.setText("MainActivity");
        }else{
            msg.setText(getIntent().getStringExtra("ss"));
        }
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,SSActivity.class);

                startActivity(it);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,MainActivity.class);
                it.putExtra("ss","MainActivity2");
                startActivity(it);
            }
        });


    }
}
