package com.glut.shop.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.glut.shop.R;
import com.glut.shop.bean.CartInfo;
import com.glut.shop.bean.GoodsInfo;
import com.glut.shop.bean.UpdataButton;
import com.glut.shop.database.CartDBHelper;
import com.glut.shop.database.GoodDBHelper;
import com.glut.shop.util.DateUtil;
import com.glut.shop.util.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.SQLException;

public class UserActivity extends AppCompatActivity {
    private static final String TAG = "UserActivity";
    private String mFilePath = "file:///android_asset/html/index.html";
    private GoodsInfo info ;
    private WebView wv_assets_web;
    String url = "http://www.lyxueit.com/BeiJing.html";
    private GoodDBHelper mHelper;
    private CartDBHelper cartDBHelper;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        String goods_id = getIntent().getStringExtra("goods_id");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    info = GoodDBHelper.getDbService().getGoodsById(goods_id);
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
    }


    private Runnable insertData= new Runnable() {
        @Override
        public void run() {
            CartInfo cartInfo = new CartInfo();
            cartInfo.setGoods_id(info.getId());
            cartInfo.setPrice(Float.parseFloat(info.getPrice()));
            cartInfo.setShop(info.getShop());
            cartInfo.setTitle(info.getTitle());
            cartInfo.setPrice(Float.parseFloat(info.getPrice()));
            cartInfo.setCount(1);
            cartInfo.setImage(info.getImg().get(0));
            cartInfo.setUpdate_time(DateUtil.getNowTime());
            cartInfo.setIsSelect(1);
            cartDBHelper.insert(cartInfo);
            ToastUtils.showToast(getApplicationContext(), "插入完成");
            Log.d(TAG, "run: 插入完成");
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        cartDBHelper = CartDBHelper.getInstance(this, 1);
        cartDBHelper.openReadLink();
        mHandler.postDelayed(insertData, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cartDBHelper.closeLink();
    }
}
