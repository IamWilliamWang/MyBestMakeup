package com.william.mybestmakeup.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.william.mybestmakeup.R;
import com.william.mybestmakeup.secondpage.SecondActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class MainActivty: public AppCompatActivity
public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private MainpageAdapter mainpageAdapter;
    RecyclerViewHeader header;

    private String[] title = {"品牌","护肤","彩妆","香水"}, info = {"品牌1,品牌2,品牌3", "护肤1,护肤2,护肤3", "彩妆1,彩妆2,彩妆3", "香水1,香水2,香水3"}, imageResouce = {"ic_launcher.png", "ic_launcher.png", "ic_launcher.png", "ic_launcher.png"};
    List<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*AlphaAnimation aa = new AlphaAnimation(0,1);
        aa.setDuration(500);
        mainRecyclerView.startAnimation(aa);*/

        /* 获取RecycleView*/
        mainRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);

        for (int i = 0; i < title.length; i++)
            list.add(new Item(title[i], info[i], imageResouce[i]));

        // 设置LayoutManager布局管理器
        mainRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        // 设置ItemAnimator
        mainRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        mainRecyclerView.setHasFixedSize(true);
        // 初始化自定义的适配器
        mainpageAdapter = new MainpageAdapter(this, list);
        // 为RecyclerView设置适配器
        mainRecyclerView.setAdapter(mainpageAdapter);
        //增加点击事件
        mainpageAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String title) {
//                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                Intent secondPage = new Intent(MainActivity.this, SecondActivity.class);
                secondPage.putExtra(SecondActivity.KEY_FROM_MAINPAGE,title);
                startActivity(secondPage);
            }
        });


        //设置头部
        header = RecyclerViewHeader.fromXml(this, R.layout.recyclerviewheader);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);
        // set LayoutManager for your RecyclerView
        header.attachTo(recyclerView);
        //把头部置顶
        findViewById(R.id.headerlinearlayout).bringToFront();

        //具有TextIuput的搜索框
        final TextInputLayout textInputLayout= (TextInputLayout) findViewById(R.id.textInput);
        textInputLayout.setHint("点击这里搜索：");
        final EditText source_editText = textInputLayout.getEditText();
        source_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                textInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(MainActivity.this,source_editText.getText(),Toast.LENGTH_SHORT)
                        .show();
            }
        });

//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editText.setText("");
//            }
//        });

        /*标题栏*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainpagetoolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.ic_launcher);
        setSupportActionBar(toolbar);

        /*浮动窗*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        doExitApp();
    }

}
