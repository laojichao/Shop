package com.glut.shop.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.glut.shop.R;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.bean.BannerBean;
import com.glut.shop.bean.CategoryBean;
import com.glut.shop.bean.CategoryBean.DataBean;
import com.glut.shop.bean.CategoryBean.DataBean.DataListBean;
import com.glut.shop.bean.HomeBean;
import com.glut.shop.http.OkHttpEngine;
import com.glut.shop.util.GlideImageLoader;
import com.glut.shop.util.ToastUtils;
import com.glut.shop.widget.MarqueeView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


@SuppressLint("DefaultLocale")
public class HomeActivity extends AppCompatActivity {
    private final static String TAG = "HomeActivity";
    private List<HomeBean> data;
    private int height;
    @BindView(R.id.app_home_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.fake_status_bar)
    View fakeStatusBar;
    @BindView(R.id.app_home_title_ll_news)
    LinearLayout appHomeTitleLlNews;
    @BindView(R.id.app_home_title_tv_news)
    AppCompatTextView appHomeTitleTvNews;
    @BindView(R.id.app_home_title_ll_search)
    LinearLayout appHomeTitleLlSearch;
    @BindView(R.id.toolbar)
    LinearLayout mToolbar;
    private String jsonData = null;
    private String bannerData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
                getJsonData();
                getBannerData();
                //延时处理
        try {
            Thread.sleep(200);
            if (jsonData != null && bannerData != null) {
                initView();
            } else {
                onResume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * 获取循环视图数据
    * */
    private void getJsonData() {
        String URL = "http://120.24.61.225:8080/atguigu/json/category.json";
        OkHttpEngine.getInstance(getApplicationContext()).getAsynHttp(URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showToast(getApplicationContext(), "网络获取失败");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonData = response.body().string();
//                Log.d(TAG, jsonData);
            }
        });
    }

    /*
    * 初始化页面视图
    * */
    private void initView() {
        //网格流循环视图适配器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 6);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        CategoryBean categoryBean = new Gson().fromJson(jsonData, CategoryBean.class);
        List<DataBean> dataBeans = categoryBean.getData();
        List<DataListBean> dataListBeans = new ArrayList<>();
        for (int i = 0; i< dataBeans.size(); i++) {
            for (int j = 0; j < dataBeans.get(i).getDataList().size() ; j++){
                dataListBeans.add(dataBeans.get(i).getDataList().get(j));
            }
        }
//        String jsonData = new String(getAssertsFile(getApplicationContext(), "content.json"));
//        data = new Gson().fromJson(jsonData, new TypeToken<List<HomeBean>>() {
//        }.getType());
        HomeAdapter adapter = new HomeAdapter();
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                //根据类型设置占位规则共6列
//                int type = data.get(position).getType();
//                if (type == 1 || type == 2 || type == 3 || type == 5 || type == 6) {
//                    return 6 ;
//                } else if (type == 4) {
//                    return 2;
//                } else if (type == 7) {
//                    return 3;
//                }
//                return 0;
                return 3;
            }
        });
        mRecyclerView.setAdapter(adapter);
        adapter.setHeaderView(getHeaderView(mRecyclerView));
        adapter.setNewData(dataListBeans);
        //设置滚动监听器
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy <= height) {
                    float alpha = (float) totalDy / height;
                    //设置透明Toolbar
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getApplicationContext(), R.color.white), alpha));
                } else {
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getApplicationContext(), R.color.white), 1));
                }
            }
        });
    }

    /*
    * 获取轮播图
    * */
    private void getBannerData() {
        String URL = "http://120.24.61.225:8080/atguigu/json/banner.json";
        OkHttpEngine.getInstance(getApplicationContext()).getAsynHttp(URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                bannerData = response.body().string();
//                Log.d(TAG, bannerData);
            }
        });
    }

    /*
    * 设置头部轮播图
    * */
    private View getHeaderView(RecyclerView v) {
        BannerBean bannerBean = new Gson().fromJson(bannerData, BannerBean.class);
        List<BannerBean.DataBean> list = bannerBean.getData();
        List<String> bannerImg = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            bannerImg.add(list.get(i).getImg());
        }
        //构建头部
        View convertView = LayoutInflater
                .from(getApplicationContext())
                .inflate(R.layout.app_include_home_header, (ViewGroup) v.getParent(), false);
        Banner mBanner = convertView.findViewById(R.id.app_home_header_banner);
        mBanner.setImages(bannerImg)
                .setImageLoader(new GlideImageLoader())     //图片加载
                .setDelayTime(5000)     //设置自动轮播延迟
                .start();
        //自定义轮播组件，轮播文本文字
        MarqueeView marqueeView = convertView.findViewById(R.id.app_home_header_problem);

        List<String> problems=new ArrayList<>();
        problems.add("如何获取更多个人积分");
        problems.add("下单时服务费率规则");
        problems.add("大额预定商品详细交易流程");
        marqueeView.startWithList(problems);

        ViewGroup.LayoutParams bannerParams = mBanner.getLayoutParams();
        int resourceId = getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = getApplicationContext().getResources().getDimensionPixelSize(resourceId);
        height = bannerParams.height - statusBarHeight - 104;

        return convertView;
    }
}