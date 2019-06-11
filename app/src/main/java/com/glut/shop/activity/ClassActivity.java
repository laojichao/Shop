package com.glut.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.facebook.common.logging.LoggingDelegate;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.glut.shop.bean.CategoryBean;
import com.glut.shop.R;
import com.glut.shop.adapter.CategoryAdapter;
import com.glut.shop.adapter.CategoryProductAdapter;
import com.glut.shop.http.OkHttpEngine;
import com.glut.shop.util.DateUtil;
import com.glut.shop.util.MenuUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ClassActivity extends AppCompatActivity {
    private static final String TAG = " ClassActivity";
    private List<String> categoryList = new ArrayList<>();
    private List<CategoryBean.DataBean> categoryProList = new ArrayList<>();
    private List<Integer> showTitle;
    private ListView lv_category;
    private ListView lv_category_product;
    private CategoryAdapter categoryAdapter;
    private CategoryProductAdapter categoryProductAdapter;
    private int currentItem;
    private TextView tv_product_title;
    private LinearLayout product_summary_LinearLayout;
    private String jsonData = null;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        initView();
        Fresco.initialize(this);
        getJsonData();
        mHandler.postDelayed(mLoad, 100);
    }

    private Runnable mLoad = new Runnable() {
        @Override
        public void run() {
            if (jsonData != null) {
                loadData();

            } else {
                Log.d(TAG, "run: 延迟");
                mHandler.postDelayed(this ,100);
            }
        }
    };

    private void initView() {
        Log.d(TAG, "initView: ");
        lv_category = (ListView)findViewById(R.id.lv_category);
        lv_category_product = (ListView)findViewById(R.id.lv_category_product);
        tv_product_title = (TextView)findViewById(R.id.tv_product_title);
        product_summary_LinearLayout = (LinearLayout)findViewById(R.id.product_summary_LinearLayout);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        lv_category.setAdapter(categoryAdapter);

        categoryProductAdapter = new CategoryProductAdapter(this, categoryProList);
        lv_category_product.setAdapter(categoryProductAdapter);

        lv_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                categoryAdapter.setSelectItem(position);
                categoryAdapter.notifyDataSetInvalidated();
                tv_product_title.setText(categoryList.get(position));
                lv_category_product.setSelection(showTitle.get(position));
            }
        });

        lv_category_product.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                this.scrollState = scrollState;
            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    return;
                }
                int current = showTitle.indexOf(firstVisibleItem);
                if (currentItem != current && current >= 0) {
                    currentItem = current;
                    tv_product_title.setText(categoryList.get(currentItem));
                    tv_product_title.setTextColor(getColor(R.color.love));
                    categoryAdapter.setSelectItem(currentItem);
                    categoryAdapter.notifyDataSetInvalidated();
                }
            }
        });
        Log.d(TAG, "initView: 初始化完成");
    }

    private void loadData() {
        Log.d(TAG, "loadData: ");
        CategoryBean categoryBean = JSONObject.parseObject(jsonData, CategoryBean.class);
        showTitle = new ArrayList<>();
        for (int i = 0; i < categoryBean.getData().size(); i++) {
            CategoryBean.DataBean dataBean = categoryBean.getData().get(i);
            categoryList.add(dataBean.getModuleTitle());
            showTitle.add(i);
            categoryProList.add(dataBean);
        }

        tv_product_title.setText(categoryBean.getData().get(0).getModuleTitle());

        categoryAdapter.notifyDataSetChanged();
        categoryProductAdapter.notifyDataSetChanged();
        Log.d(TAG, "loadData: ,数据加载完成");
    }

    private void getJsonData() {
        String Url = "http://120.24.61.225:8080/atguigu/json/category.json";
        OkHttpEngine.getInstance(getApplicationContext()).getAsynHttp(Url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    jsonData = response.body().string().replaceAll("[\\n]","");
//                    Log.d("jsondata",jsonData);
                }
            }
        });
    }


}