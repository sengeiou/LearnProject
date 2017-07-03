package com.cococa.source;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private String[] activitys = {
            "com.cococa.source.recyclerview.RecyclerViewActivity",
    };
    MainAdapter mainAdapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mainAdapter = new MainAdapter(activitys, this, this);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    @Override
    public void onClick(View view) {
        if (R.id.parent == view.getId()) {
            try {
                String classStr = (String) view.getTag();
                Class activityClass = Class.forName(classStr);
                Intent it = new Intent(this, activityClass);
                startActivity(it);

            } catch (ClassNotFoundException e) {

            }

        }
    }
}
