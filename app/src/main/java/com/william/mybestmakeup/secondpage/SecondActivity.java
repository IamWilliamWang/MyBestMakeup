package com.william.mybestmakeup.secondpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.william.mybestmakeup.R;
import com.william.mybestmakeup.mainpage.MainActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_FROM_MAINPAGE = "啊哈";

    private String mainTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//基类
        setContentView(R.layout.activity_second);

        mainTitle = getIntent().getExtras().getString(KEY_FROM_MAINPAGE);

        TextView tv = (TextView) findViewById(R.id.textView);
//        tv.setText("按下的是第"+ mainTitle +"个按钮。");
        switch (mainTitle) {
            case "品牌":
                tv.setText("这里是品牌");
                break;
            case "护肤":
                tv.setText("这里是护肤");
                break;
            case "彩妆":
                tv.setText("这里是彩妆");
                break;
            case "香水":
                tv.setText("这里是香水");
                break;
        }
    }

}
