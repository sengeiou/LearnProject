package com.cococa.source;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cococa.source.MainAdapter
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/6/29 17:00
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] activitys;
    private Context context;
    View.OnClickListener onClickListener;
    List<MainItem> itemList;

    public MainAdapter(List<MainItem> itemList, String[] activitys, Context context, View.OnClickListener onClickListener) {
        this.itemList = itemList;
        this.activitys = activitys;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == MainItem.TYPE_IMG) {
            return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false));
        } else {
            return new TitleHolder(LayoutInflater.from(context).inflate(R.layout.item_main_title, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {
        if (viewholder instanceof ItemHolder) {
            ItemHolder holder = (ItemHolder) viewholder;
            holder.name.setImageResource(itemList.get(position).url);
            holder.parent.setTag(activitys[position]);
            holder.parent.setOnClickListener(onClickListener);
        } else {
            TitleHolder holder = (TitleHolder) viewholder;
            holder.name.setText(activitys[position]);
            holder.parent.setTag(activitys[position]);
            holder.parent.setOnClickListener(onClickListener);
        }


    }

    @Override
    public int getItemCount() {
        return activitys.length;
    }


    class ItemHolder extends RecyclerView.ViewHolder {

        ImageView name;
        View parent;

        public ItemHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = (ImageView) itemView.findViewById(R.id.name);
        }
    }


    class TitleHolder extends RecyclerView.ViewHolder {

        TextView name;
        View parent;

        public TitleHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }


}
