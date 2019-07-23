package com.cocoa.retrofit.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SSActivity extends AppCompatActivity {


    private Button start;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        msg = (TextView)findViewById(R.id.msg);
        msg.setText("SSActivity");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SSActivity.this,MainActivity.class);

                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                it.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);


                startActivity(it);

            }
        });


    }
}
