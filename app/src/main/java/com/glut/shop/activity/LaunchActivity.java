package com.glut.shop.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.glut.shop.R;
import com.glut.shop.util.PermissionUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LaunchActivity extends AppCompatActivity {
    private static final String TAG = "LaunchActivity";
    @BindView(R.id.iv_background)
    ImageView iv_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);     //数据绑定
        iv_background.setEnabled(false);
        loadImage();    //启动图加载
//        PermissionUtil.checkPermission(LaunchActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, 0);
        check();
    }

    private void check() {
        boolean result = PermissionUtil.checkMultiPermission(LaunchActivity.this, permissions, 0);      //权限检查
        if (result == true) {
            iv_background.setEnabled(true);
            mHandler.postDelayed(mLaunch, 1000);
        } else {
            Toast.makeText(this, "需要允许相应的权限才能开启应用", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void loadImage() {
        String url = "http://120.24.61.225:8080/atguigu/img/launch.jpg";
        Glide.with(this).load(url).into(iv_background);
    }

    String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private Handler mHandler = new Handler();
    private  Runnable mLaunch = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(), StoreActivity.class));
        }
    };

    @OnClick(R.id.iv_background)
    public void onClick() {
        mHandler.removeCallbacks(mLaunch);
        mHandler.post(mLaunch);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
