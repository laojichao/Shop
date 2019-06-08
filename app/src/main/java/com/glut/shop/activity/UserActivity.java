package com.glut.shop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.glut.shop.R;
import com.glut.shop.bean.GoodsInfo;
import com.glut.shop.database.GoodDBHelper;
import com.glut.shop.util.ToastUtils;

import java.sql.SQLException;

public class UserActivity extends AppCompatActivity {
    private static final String TAG = "UserActivity";
    private String mFilePath = "file:///android_asset/html/index.html";
    private GoodsInfo info = new GoodsInfo();
    private WebView wv_assets_web;
    String url = "http://www.lyxueit.com/BeiJing.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    info = GoodDBHelper.getDbService().getGoodsById("1001");
                    Log.d(TAG, "run: " + info.getTitle());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        // 从布局文件中获取名叫tl_head的工具栏
        Toolbar tl_head = findViewById(R.id.tl_head);
        // 使用tl_head替换系统自带的ActionBar
        setSupportActionBar(tl_head);
        // 给tl_head设置导航图标的点击监听器
        // setNavigationOnClickListener必须放到setSupportActionBar之后，不然不起作用
        tl_head.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView tv_web_path = findViewById(R.id.tv_web_path);
        // 从布局文件中获取名叫wv_assets_web的网页视图
        WebView wv_assets_web = findViewById(R.id.wv_assets_web);
//        tv_web_path.setText("下面网页来源于资产文件：" + mFilePath);
//        wv_assets_web.loadUrl(url);
        wv_assets_web.getSettings().setJavaScriptEnabled(true);
        wv_assets_web.loadUrl("http://120.24.61.225:8080/map.html");
        wv_assets_web.setWebChromeClient(new WebChromeClient());
        // 命令网页视图加载指定路径的网页


        // 给网页视图设置默认的网页浏览客户端
//        wv_assets_web.setWebViewClient(new WebViewClient());
        Log.d(TAG, "onCreate: " + info.getTitle());
        Log.d(TAG, "onCreate: " + info.getId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + info.getTitle());
        ToastUtils.showToast(this, info.getTitle());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
