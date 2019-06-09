package com.glut.shop.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.glut.shop.R;
import com.glut.shop.adapter.ShoppingCartAdapter;
import com.glut.shop.adapter.ShoppingCartAdapter.OnRecyclerViewItemClickListener;
import com.glut.shop.adapter.ShoppingCartAdapter.OndeleteidClickListener;
import com.glut.shop.bean.CartInfo;
import com.glut.shop.bean.ShoppingBean;
import com.glut.shop.bean.ShoppingBean.DataBean;
import com.glut.shop.bean.UpdataButton;
import com.glut.shop.database.CartDBHelper;
import com.glut.shop.http.OkHttpEngine;
import com.glut.shop.widget.CommomDialog;
import com.glut.shop.util.ToastUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/*
* 
* 购物车页面
* 店铺点击监听器
* 店铺删除监听器
* 视图点击监听器
* */
public class CartActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener,
        OnClickListener, OndeleteidClickListener {
    private static final String TAG = "CartActivity";
    
    @BindView(R.id.iv_return)
    ImageView iv_return;     //返回
    @BindView(R.id.rl_mygoods)
    RelativeLayout rl_mygoods;
    @BindView(R.id.rv_shopcart)
    RecyclerView rv_shopcart;       //循环视图
    @BindView(R.id.rl_shopcart_have)
    RelativeLayout rl_shopcart_have;
    @BindView(R.id.cb_shopcart_allselect)
    CheckBox cb_shopcart_allselect;      //全选
    @BindView(R.id.tv_shopcart_totalprice)
    TextView tv_shopcart_totalprice;  //总价
    @BindView(R.id.tv_shopcart_totalnum)
    TextView tv_shopcart_totalnum;
    @BindView(R.id.tv_shopcart_submit)
    TextView tv_shopcart_submit;      //提交结算
    @BindView(R.id.ll_pay)
    LinearLayout ll_pay;
    @BindView(R.id.empty_view)
    View empty_view;
    private List<DataBean> data;
    private ShoppingCartAdapter rv_ShopCartAdapter;
    boolean isSelect = false;
    private static final String URL = "http://120.24.61.225:8080/atguigu/json/shoppingcart.json";
    private String jsonData = null;
    private CartDBHelper mHelper;
    private List<CartInfo> info = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
//        initView();
        //注册事件
        EventBus.getDefault().register(this);
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHelper = CartDBHelper.getInstance(this, 1);
        //打开数据库
        mHelper.openWriteLink();
//        getShoppingCartData();
        info = mHelper.query("1=1");
        if (info != null) {
            init();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHelper.closeLink();
    }

    private void initListener() {
        //点击返回监听器
        iv_return.setOnClickListener(this);
        //全选监听器
        cb_shopcart_allselect.setOnClickListener(this);
        //提交订单监听器
        tv_shopcart_submit.setOnClickListener(this);
    }

    //获取json数据
    private void getShoppingCartData() {
        OkHttpEngine.getInstance(getApplicationContext()).getAsynHttp(URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonData = response.body().string();
//                Log.d(TAG, jsonData);
            }
        });
    }

    private void init() {
        Gson gson = new Gson();
//        shopCartBeans = gson.fromJson(jsonData, ShoppingBean.class);
//        data = null;
//        data = shopCartBeans.getData();
        List<DataBean> dataBeans = new ArrayList<>();            //店铺项列表
        for (int i = 0; i < info.size(); i++) {
            DataBean.ListBean listBean = new DataBean.ListBean();       //商品项
            listBean.setGoods_name(info.get(i).getTitle());
            listBean.setGoods_price(info.get(i).getPrice());
            listBean.setGoods_num(info.get(i).getCount());
            listBean.setGoods_image(info.get(i).getImage());
            listBean.setGoods_id(info.get(i).getGoods_id());

            List<DataBean.ListBean> listBeans = new ArrayList<>();      //商品项列表
            DataBean dataBean = new DataBean();         //店铺

            String name = info.get(i).getShop();        //获取当前店铺名字
            dataBean.setStore_name(name);               //设置前项的店铺名
            boolean isSame = false;
            for (int j = 0; j < dataBeans.size(); j++) {
                if (name.equals(dataBeans.get(j).getStore_name())) {
                    //当遇到同名店铺，则添加到同名店铺之下
                    dataBeans.get(j).getList().add(listBean);
                    isSame = true;
                    break;
                }
            }
            if (!isSame) {
                listBeans.add(listBean);        //每个商品项添加进商品列表
                dataBean.setList(listBeans);        //商品列表添加进商店
                dataBeans.add(dataBean);        //店铺添加进店铺列表
            }

        }
        initData(dataBeans);
    }


    /**
     * 设置数据
     */
    private void initData(List<DataBean> bean) {
//
        data = bean;
        if (rv_ShopCartAdapter != null) {
            rv_ShopCartAdapter.setDatas(data);
            //通知改变
            rv_ShopCartAdapter.notifyDataSetChanged();
        } else {
            rv_ShopCartAdapter = new ShoppingCartAdapter(this, data, mHelper);
            //设置垂直流循环视图
            rv_shopcart.setLayoutManager(new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false));
            rv_shopcart.setAdapter(rv_ShopCartAdapter);
            rv_ShopCartAdapter.setOnItemClickListener(this);      //商品项点击
            rv_ShopCartAdapter.setOndeleteidClickListener(this); //删除的点击
        }
    }

    @Override
    public void onItemClick(View view, ShoppingBean.DataBean data) {
        Log.d(TAG, "onItemClick: ");
        ToastUtils.showToast(getApplicationContext(), "店铺页暂时未实现");

    }

    //这里用了eventBus来进行实时价格的UI更改。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(UpdataButton event) {
        //刷新UI
        tv_shopcart_totalprice.setText("￥" + event.getDiscribe());
        tv_shopcart_totalnum.setText("商品数量：" + event.getCount() + "（含运费）");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messEventBus(DataBean bean) {
        //刷新UI
        Log.d(TAG, "messEventBus: ");
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getStore_name().equals(bean.getStore_name())) {
                data.remove(i);
            }
        }
        initData(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return: //返回
                finish();
                break;
            case R.id.cb_shopcart_allselect: //全选
                if (isSelect) {
                    cb_shopcart_allselect.setChecked(false);
                    isSelect = false;
                    //通知全选
                    rv_ShopCartAdapter.setAllselect(false);
                } else {
                    cb_shopcart_allselect.setChecked(true);
                    isSelect = true;
                    rv_ShopCartAdapter.setAllselect(true);
                }
                break;

            case R.id.tv_shopcart_submit:
                Toast.makeText(CartActivity.this, "支付功能暂未开通", Toast.LENGTH_SHORT).show();
                break;
        }
    }
 
    /**
     * 删除的点击事件
     *
     * @param view  视图
     * @param list 要删除id的集合
     */
    @Override
    public void onIdClick(View view, final List<String> list) {
        //圆形的警告框
        new CommomDialog(CartActivity.this, R.style.dialog, "", new CommomDialog.OnCloseListener() {
            @Override
            public void onClick(Dialog dialog, boolean confirm) {
                if (confirm) {
//                    mHelper.delete("");
                    for (String id : list) {
                        mHelper.delete(String.format("goods_id='%s'", id));
                        ToastUtils.showToast(getApplicationContext(),  "商品被删除了");
                    }
                    dialog.dismiss();
                    init();
                }
            }
        }).setTitle("你确定要删除吗？").show();
    }

}