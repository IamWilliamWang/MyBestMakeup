package com.william.mybestmakeup;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/** 重写的自定义ViewHolder
  * Created by william on 2016/8/16.
 */
public class MainViewHolder extends RecyclerView.ViewHolder{

    private TextView mainTitleTextView;
    private TextView mainContentTextView;
    private ImageView mainImageView;

    public MainViewHolder(View itemView) {
        super(itemView);
        mainTitleTextView = (TextView) itemView.findViewById(R.id.mainTitleText);
        mainContentTextView = (TextView) itemView.findViewById(R.id.mainContentText);
        mainImageView = (ImageView) itemView.findViewById(R.id.mainPic);
    }

    public TextView getMainTitleTextView() {
        return mainTitleTextView;
    }

    public TextView getMainContentTextView() {
        return mainContentTextView;
    }

    public ImageView getMainImageView() {
        return mainImageView;
    }
}
