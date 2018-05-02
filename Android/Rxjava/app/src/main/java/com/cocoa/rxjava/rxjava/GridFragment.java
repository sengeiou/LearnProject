package com.cocoa.rxjava.rxjava;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.cocoa.rxjava.rxjava.gx.BrandItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junshen on 2018/4/10.
 */

public class GridFragment extends Fragment {
    private GridView gridView;
    private List<BrandItem> dataList;
    private BaseAdapter adapter;
    private Listener listener;
    private int cellWidth;

    public static GridFragment newInstance(List<BrandItem> mList, int cellWidth, Listener listener) {
        GridFragment newInstance = new GridFragment();
        newInstance.listener = listener;
        newInstance.dataList = new ArrayList<>();
        newInstance.dataList.addAll(mList);
        newInstance.cellWidth = cellWidth;
        return newInstance;
    }


    public void change(String id) {
        if (adapter == null || dataList == null) {
            return;
        }
        for (BrandItem item : dataList) {
            if (item.getId().equals(id)) {
                item.setClickTag(true);
            } else {
                item.setClickTag(false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);

        gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setHorizontalSpacing(20);
        gridView.setVerticalSpacing(20);
        gridView.setNumColumns(4);
        adapter = new MyAdapter(getActivity(), dataList, cellWidth);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                BrandItem item = dataList.get(position);
                listener.change(item.getId());
            }
        });

        return view;
    }


}


interface Listener {
    void change(String id);
}

class MyAdapter extends BaseAdapter {

    private Context context;
    private List<BrandItem> mList;
    private int cellWidth;
    private LayoutInflater mInflater;

    public MyAdapter(Context context, List<BrandItem> mList, int cellWidth) {
        this.context = context;
        this.mList = mList;
        this.cellWidth = cellWidth;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public BrandItem getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_select_brand, null);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);

            AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                    cellWidth,
                    cellWidth);
            convertView.setLayoutParams(param);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(getItem(position).getText());

        if (getItem(position).isClickTag()) {
            convertView.setBackgroundColor(Color.parseColor("#FFE3CD"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#F2F2F2"));
        }

        return convertView;
    }

    static class ViewHolder {
        public TextView text;

    }

}


