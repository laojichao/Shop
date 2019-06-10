package com.glut.shop.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.glut.shop.R;
import com.glut.shop.adapter.LinearDynamicAdapter;
import com.glut.shop.application.MainApplication;
import com.glut.shop.bean.CartInfo;
import com.glut.shop.bean.GoodsInfo;
import com.glut.shop.bean.HistoryInfo;
import com.glut.shop.database.CartDBHelper;
import com.glut.shop.database.HistoryDBHelper;
import com.glut.shop.util.ToastUtils;
import com.glut.shop.widget.SpacesItemDecoration;
import com.glut.shop.widget.RecyclerExtras.OnItemLongClickListener;
import com.glut.shop.widget.RecyclerExtras.OnItemClickListener;
import com.glut.shop.widget.RecyclerExtras.OnItemDeleteClickListener;
/**
 * RecyclerDynamicActivity
 *
 * @author lao
 * @date 2019/6/10
 */

@SuppressLint("DefaultLocale")
public class RecyclerDynamicActivity extends AppCompatActivity implements
        OnItemClickListener, OnItemLongClickListener, OnItemDeleteClickListener {
    private static final String TAG = "RecyclerDynamicActivity";
    private RecyclerView rv_dynamic; // 声明一个循环视图对象
    private LinearDynamicAdapter mAdapter; // 声明一个线性适配器对象
    private ArrayList<HistoryInfo> goodsArray = null;
    private HistoryDBHelper mHistoryDBHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_dynamic);
//        findViewById(R.id.btn_recycler_add).setOnClickListener(this);

    }

    // 初始化动态线性布局的循环视图
    private void initRecyclerDynamic() {
        // 从布局文件中获取名叫rv_dynamic的循环视图
        rv_dynamic = findViewById(R.id.rv_dynamic);
        // 创建一个垂直方向的线性布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(
                this, LinearLayout.VERTICAL, false);
        // 设置循环视图的布局管理器
        rv_dynamic.setLayoutManager(manager);
        // 构建一个公众号列表的线性适配器
        mAdapter = new LinearDynamicAdapter(this, goodsArray);
        // 设置线性列表的点击监听器
        mAdapter.setOnItemClickListener(this);
        // 设置线性列表的长按监听器
        mAdapter.setOnItemLongClickListener(this);
        // 设置线性列表的删除按钮监听器
        mAdapter.setOnItemDeleteClickListener(this);
        // 给rv_dynamic设置公众号线性适配器
        rv_dynamic.setAdapter(mAdapter);
        // 设置rv_dynamic的默认动画效果
        rv_dynamic.setItemAnimator(new DefaultItemAnimator());
        // 给rv_dynamic添加列表项之间的空白装饰
        rv_dynamic.addItemDecoration(new SpacesItemDecoration(1));
    }

    // 一旦点击循环适配器的列表项，就触发点击监听器的onItemClick方法
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getApplicationContext(), ProductInfoActivity.class);
        intent.putExtra("goods_id", goodsArray.get(position).getGoods_id());
        startActivity(intent);
    }

    // 一旦长按循环适配器的列表项，就触发长按监听器的onItemLongClick方法
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: " + position);
        HistoryInfo item = goodsArray.get(position);
        item.setSelect(!item.isSelect());
        goodsArray.set(position, item);
        // 通知适配器列表在第几项发生变更
        mAdapter.notifyItemChanged(position);
    }

    // 一旦点击循环适配器列表项的删除按钮，就触发删除监听器的onItemDeleteClick方法
    public void onItemDeleteClick(View view, int position) {
        HistoryInfo info = goodsArray.get(position);
        Log.d(TAG, "onItemDeleteClick: " + info.getUser_id() + info.getGoods_id());
        mHistoryDBHelper.delete(String.format("user_id='%s' and goods_id='%s'", info.getUser_id(), info.getGoods_id()));
        // 通知适配器列表在第几项删除数据
        goodsArray.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHistoryDBHelper = HistoryDBHelper.getInstance(this, 1);
        mHistoryDBHelper.openWriteLink();
        goodsArray = mHistoryDBHelper.query("user_id=" + MainApplication.getInstance().getUser_id());
        if (goodsArray != null) {
            initRecyclerDynamic(); // 初始化动态线性布局的循环视图
        } else {
            ToastUtils.showToast(getApplicationContext(), "当前历史记录为空");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHistoryDBHelper.closeLink();
    }
}
