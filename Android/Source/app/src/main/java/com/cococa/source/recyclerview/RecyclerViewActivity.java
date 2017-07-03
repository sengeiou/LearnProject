package com.cococa.source.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cococa.source.R;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.source.recyclerview.RecyclerViewActivity
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/6/29 16:49
 */
public class RecyclerViewActivity extends Activity {

    RecyclerView mRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
    }
}
