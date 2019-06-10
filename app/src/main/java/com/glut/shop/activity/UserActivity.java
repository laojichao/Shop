package com.glut.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.glut.shop.R;
import com.glut.shop.model.EventModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import com.glut.shop.util.Utils;
import com.glut.shop.widget.view.MyScrollView;

public class UserActivity extends AppCompatActivity implements View.OnClickListener, MyScrollView.ScrollingListener {

    private Toolbar toolbar;
    private MyScrollView my_scroll_view;
    private View divider0;
    private ImageView iv_back, iv_settings;//返回,设置
    private TextView tv_title, tv_login;//"个人中心",登录
    private RelativeLayout rl_un_login, rl_login;//未登录和登录后的布局
    private TextView tv_history;

    private float alphaHeight = 0;//透明度渐变的高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initViews();
        initData();

        setToolbar();
        setListeners();
    }

    private void initData() {
        alphaHeight = Utils.dip2px(this, 160);
        tv_title.setVisibility(View.INVISIBLE);//"个人中心"暂时不可见

        EventBus.getDefault().register(this);//订阅
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        my_scroll_view = (MyScrollView) findViewById(R.id.my_scroll_view);
        divider0 = findViewById(R.id.divider0);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_settings = (ImageView) findViewById(R.id.iv_settings);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_login = (TextView) findViewById(R.id.tv_login);
        rl_un_login = (RelativeLayout) findViewById(R.id.rl_un_login);
        rl_login = (RelativeLayout) findViewById(R.id.rl_login);
        tv_history = findViewById(R.id.tv_history);
    }

    private void setListeners() {
        iv_back.setOnClickListener(this);
        iv_settings.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        my_scroll_view.setScrollingListener(this);
        tv_history.setOnClickListener(this);
    }

    private void setToolbar() {
        //设置导航图标要在setSupportActionBar方法之后
        Utils.initToolbar(this, toolbar, "", "", 0, null);

        toolbar.setAlpha(0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_settings:
                Intent intent = new Intent(this, ChangeProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login:
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
            case R.id.tv_history:
//                startActivity(new Intent(this, HistoryActivity.class));
                startActivity(new Intent(this, RecyclerDynamicActivity.class));
        }
    }


    @Override
    public void onScrolling(int l, int t, int oldl, int oldt) {
        float alpha = t * 1.0f / alphaHeight;
        if (alpha < 0.4f) {
            alpha = 0;
            if (divider0.getVisibility() == View.VISIBLE) {
                divider0.setVisibility(View.INVISIBLE);
                tv_title.setVisibility(View.INVISIBLE);
            }
        } else {
            if (divider0.getVisibility() == View.INVISIBLE) {
                divider0.setVisibility(View.VISIBLE);
                tv_title.setVisibility(View.VISIBLE);
            }
        }
        toolbar.setAlpha(alpha);
    }

    //ThreadMode共四个:MAIN UI线程 BACKGROUND 后台线程 POSTING 和发布者处在同一个线程 ASYNC 异步线程
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(EventModel event) {
        switch (event.getEventCode()) {
            case EventModel.CODE_LOGIN://登录
                rl_login.setVisibility(View.VISIBLE);
                rl_un_login.setVisibility(View.GONE);
                break;
            case EventModel.CODE_LOGOUT://登出
                rl_un_login.setVisibility(View.VISIBLE);
                rl_login.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//解除订阅
    }
}
