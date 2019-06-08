package com.glut.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        Fresco.initialize(this);
        // 从布局文件中获取名叫tl_head的工具栏
        Toolbar tl_head = findViewById(R.id.tl_head);
        tl_head.setTitle("商品分类");
        // 使用tl_head替换系统自带的ActionBar
        setSupportActionBar(tl_head);
        initView();

        while (jsonData == null) {
            getJsonData();
        }
//        getJsonData();
        loadData();

    }

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

//        product_summary_LinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ClassActivity.this, ProductInfoActivity.class));
//            }
//        });

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
                    tv_product_title.setTextColor(getColor(R.color.orange));
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

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        // 显示菜单项左侧的图标
        MenuUtil.setOverflowIconVisible(featureId, menu);
        Log.d(TAG, "onMenuOpened: ");
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 从menu_overflow.xml中构建菜单界面布局
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        Log.d(TAG, "onCreateOptionsMenu: ");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        int id = item.getItemId();
        if (id == android.R.id.home) { // 点击了工具栏左边的返回箭头
            finish();
        } else if (id == R.id.menu_refresh) { // 点击了刷新图标
            Toast.makeText(this, "当前刷新时间: " + DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss")
                    , Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menu_about) { // 点击了关于菜单项
            Toast.makeText(this, "这个是分类页面", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menu_quit) { // 点击了退出菜单项
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}