package com.cococa.source;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.source.MainAdapter
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/6/29 17:00
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemHolder> {

    private String[] activitys;
    private Context context;
    View.OnClickListener onClickListener;

    public MainAdapter(String[] activitys, Context context, View.OnClickListener onClickListener) {
        this.activitys = activitys;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent,false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.name.setText(activitys[position]);
        holder.parent.setTag(activitys[position]);
        holder.parent.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return activitys.length;
    }


    class ItemHolder extends RecyclerView.ViewHolder {

        TextView name;
        View parent;

        public ItemHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }

}
