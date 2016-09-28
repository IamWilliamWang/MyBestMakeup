package com.william.mybestmakeup.mainpage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.william.mybestmakeup.R;

import java.util.List;
//我的适配器
public class MainpageAdapter extends RecyclerView.Adapter<MainViewHolder> implements View.OnClickListener {

    private Context mcontext;
    private List<Item> list;

    public OnRecyclerViewItemClickListener mOnItemClickListener = null;//点击

    public MainpageAdapter(Context context,List<Item> list) {
        this.mcontext = context;
        this.list=list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 给ViewHolder设置布局文件
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        v.setOnClickListener(this);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        // 给ViewHolder设置元素
        holder.getMainTitleTextView().setText(list.get(position).getTitle());
        holder.getMainContentTextView().setText(list.get(position).getContent());
//        holder.getMainImageView().setImageDrawable(mcontext.getDrawable(list.get(position).getImageResourceId(mcontext)));
        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        // 返回数据总数
        return list.size();
    }

    /**
     * 将点击事件转移给外面的调用者
     * */
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (String)v.getTag());
        }
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
