package com.cococa.source;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private String[] activitys = {
            "com.cococa.source.permission.PermissionActivity",
            "com.cococa.source.glide.GlideActivity",
            "com.cococa.source.recyclerview.RecyclerViewActivity",
            "com.cococa.source.recyclerview.RecyclerViewActivity",
            "com.cococa.source.recyclerview.RecyclerViewActivity",
            "com.cococa.source.recyclerview.RecyclerViewActivity",
            "com.cococa.source.recyclerview.RecyclerViewActivity",
    };
    MainAdapter mainAdapter;
    List<MainItem> itemList = new ArrayList<>();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < activitys.length; i++) {
            MainItem item = new MainItem();
            if (i == 0 || i == 7) {
                item.type = MainItem.TYPE_TITLE;
            }
            itemList.add(item);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mainAdapter = new MainAdapter(itemList, activitys, this, this);
        recyclerView.setAdapter(mainAdapter);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (itemList.get(position).type == MainItem.TYPE_TITLE) {
                    return manager.getSpanCount();
                }
                return 1;
            }
        });


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
