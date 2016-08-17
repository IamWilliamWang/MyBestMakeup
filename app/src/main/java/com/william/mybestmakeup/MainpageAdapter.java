package com.william.mybestmakeup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by william on 2016/8/16.
 */
public class MainpageAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private Context mcontext;
    private List<Item> list;

    public MainpageAdapter(Context context,List<Item> list) {
        this.mcontext = context;
        this.list=list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 给ViewHolder设置布局文件
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        // 给ViewHolder设置元素
        holder.getMainTitleTextView().setText(list.get(position).getTitle());
        holder.getMainContentTextView().setText(list.get(position).getContent());
//        holder.getMainImageView().setImageDrawable(mcontext.getDrawable(list.get(position).getImageResourceId(mcontext)));
    }

    @Override
    public int getItemCount() {
        // 返回数据总数
        return list.size();
    }
}
