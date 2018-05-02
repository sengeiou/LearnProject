package com.cocoa.rxjava.rxjava.gx;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cocoa.rxjava.rxjava.R;

import java.util.List;

/**
 * Created by junshen on 2018/4/11.
 */

public class CommTextAdapter extends BaseAdapter {

    private Context context;
    private List<CommSelectItem> mList;
    private int cellWidth;
    private LayoutInflater mInflater;

    public CommTextAdapter(Context context, List<CommSelectItem> mList, int cellWidth) {
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
    public CommSelectItem getItem(int position) {
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
            convertView = mInflater.inflate(R.layout.item_select_text, null);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);

            AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                    cellWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
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

