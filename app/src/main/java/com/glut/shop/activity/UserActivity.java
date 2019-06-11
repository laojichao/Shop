package com.glut.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.glut.shop.R;
import com.glut.shop.application.MainApplication;
import com.glut.shop.bean.User;
import com.glut.shop.model.EventModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import com.glut.shop.util.ToastUtils;
import com.glut.shop.util.Utils;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "UserActivity";
    private TextView tv_settings;   //设置
    private TextView tv_login;  //登录
    private TextView tv_register;   //注册
    private RelativeLayout rl_un_login, rl_login;//未登录和登录后的布局
    private TextView tv_nickname;

    private LinearLayout linearLayout_history;
    private LinearLayout linearLayout_collection;

    private float alphaHeight = 0;//透明度渐变的高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initViews();
        initData();     //必须先注册EventBus再初始化ui

    }

    private void initData() {
        alphaHeight = Utils.dip2px(this, 160);
        EventBus.getDefault().register(this);//订阅
    }

    private void initViews() {
        linearLayout_history = (LinearLayout)findViewById(R.id.linearLayout_history);
        linearLayout_history.setOnClickListener(this);
        linearLayout_collection = (LinearLayout)findViewById(R.id.linearLayout_collection);
        linearLayout_collection.setOnClickListener(this);
        tv_settings = (TextView)findViewById(R.id.tv_settings);
        tv_settings.setOnClickListener(this);
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);
        tv_register = (TextView)findViewById(R.id.tv_register);
        tv_register.setOnClickListener(this);
        rl_un_login = (RelativeLayout) findViewById(R.id.rl_un_login);
        rl_login = (RelativeLayout) findViewById(R.id.rl_login);
        tv_nickname  = findViewById(R.id.tv_nickname);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_settings:
                Intent intentsettings = new Intent(this, ChangeProfileActivity.class);
                startActivity(intentsettings);
                break;
            case R.id.tv_login:
                Intent intentlogin = new Intent(this, LoginActivity.class);
                startActivity(intentlogin);
                break;
            case R.id.tv_register:
                Intent intentregister = new Intent(this,RegisteredActivity.class);
                startActivity(intentregister);
                break;
            case R.id.linearLayout_history:
                if (TextUtils.isEmpty(MainApplication.getInstance().getUser_id())) {
                    ToastUtils.showToast(this, "请登录账户");
                } else {
                    startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                }
                break;
            case R.id.linearLayout_collection:
                ToastUtils.showToast(this, "我的收藏");
                break;
        }
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserEvent(User user) {
        tv_nickname.setText(user.getUsername());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//解除订阅
    }
}
