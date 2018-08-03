package com.cocoa.t_rxjava.oper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cocoa.t_rxjava.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junshen on 2018/2/7.
 */

public class BaseActivity extends AppCompatActivity {

    public Context mContext;
    public final String TAG = this.getClass().getSimpleName();

    public ListView listview;
    public TextView mTitle;
    public TextView mContent;
    public List<String> items = new ArrayList<>();
    public BaseAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        mContext = this;
        listview = (ListView) findViewById(R.id.opt_listview);
        mTitle = (TextView) findViewById(R.id.log_title);
        mContent = (TextView) findViewById(R.id.log_content);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                reflectClick(items.get(position));
            }
        });
    }

    public void reflectClick(String oper) {
        if (TextUtils.isEmpty(oper)) {
            return;
        }
        clearMsg();
        Class clazz = this.getClass();
        try {
            Method method = clazz.getMethod(oper);
            method.invoke(this);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public  void appendTitle(String s) {
        mTitle.append("\n"+s);
    }

    public  void appendContent(String s) {
        mContent.append("\n\n"+s);
    }

    public void clearMsg(){
        mContent.setText("");
        mTitle.setText("");
    }


    public void clearAddNewItems(String[] itemArray) {
        items.clear();
        items.addAll(Arrays.asList(itemArray));
        adapter.notifyDataSetChanged();
    }

    public void printMsg(String msg) {
        Log.d(TAG, msg);
    }
}
