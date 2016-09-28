package com.william.mybestmakeup.mainpage;

import android.content.Context;

/**
 * Created by william on 2016/8/17.
 */
public class Item {
    private String title;
    private String content;
    private String picName;

    public Item(String title, String content,String picName) {
        this.title = title;
        this.content = content;
        this.picName = picName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImageResourceId( Context context )
    {
        try
        {
            return context.getResources().getIdentifier(this.picName, "drawable", context.getPackageName());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}
