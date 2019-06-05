package com.glut.shop.activity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.glut.shop.R;
import com.glut.shop.adapter.ShoppingCartAdapter;
import com.glut.shop.bean.ShoppingBean;
import com.glut.shop.bean.UpdataButton;
import com.glut.shop.http.OkHttpEngine;
import com.glut.shop.util.CommomDialog;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class CartActivity extends AppCompatActivity implements
        ShoppingCartAdapter.OnRecyclerViewItemClickListener,
        View.OnClickListener, ShoppingCartAdapter.OndeleteidClickListener {
    private static final String TAG = "CartActivity";

    private CheckBox tvShopCartSelect;
    private TextView tvShopCartTotalPrice;
    private ImageView mBock_return;
    private RecyclerView rlvShopCart;
    private TextView tvShopCartSubmit;
    private ShoppingBean shopCartBeans;
    private List<ShoppingBean.DataBean> data;
    private ShoppingCartAdapter mallShopCartAdapter;
    boolean isSelect = false;
    private static final String URL = "http://120.24.61.225:8080/atguigu/json/content.json";
    private String jsonData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getShoppingCartData();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mBock_return.setOnClickListener(this);
        tvShopCartSelect.setOnClickListener(this);
        tvShopCartSubmit.setOnClickListener(this);
    }

    //获取json数据,暂时获取不了
     private void getShoppingCartData() {
        OkHttpEngine.getInstance(getApplicationContext()).getAsynHttp(URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonData = response.body().string();
                Log.d(TAG, jsonData);
            }
        });
     }

    /**
     *  设置数据
     */
    private void initData() {
        //测试用的数据转换成实体类，赋值到adapter中
        //网络中获取的json数据
        String jsonData="{\"status\":true,\"msg\":\"\",\"data\":[{\"store_name\":\"天天商城\",\"user_id\":\"229\",\"store_id\":\"14828331510902860000\",\"list\":[{\"goods_price\":183,\"cart_id\":\"15232812841628050000\",\"user_id\":\"229\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15162475454444720000\",\"goods_num\":\"1\",\"goods_name\":\"飞科FC5901专业发廊理发器电推剪电动推子成人老人儿童剃头\",\"goods_image\":\"http://img.lion-mall.com/goods/20180118/dbff92fc8dee4e26c39b21ee207a18a8.jpg\",\"spec_desc\":\"\",\"spec1_name\":\"型号\",\"spec1_value\":\"FC5901(积分价)\",\"spec2_name\":\"\",\"spec2_value\":\"\",\"proportion_return\":\"50\",\"goods_points\":66,\"is_have_point\":\"1\",\"model_id\":\"15162475454434460000\"}]},{\"store_name\":\"本港海产\",\"user_id\":\"3096\",\"store_id\":\"15132364355633290000\",\"list\":[{\"goods_price\":33,\"cart_id\":\"15232812763901580000\",\"user_id\":\"3096\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15156635008014120000\",\"goods_num\":\"1\",\"goods_name\":\"本港海产 即食大片海苔原味辣味125g包邮\",\"goods_image\":\"http://img.lion-mall.com/goods/20180111/65aae13eb49e93939850c707dbf69966.jpg\",\"spec_desc\":\"\",\"spec1_name\":\"规格\",\"spec1_value\":\"1*125g(积分价)\",\"spec2_name\":\"\",\"spec2_value\":\"\",\"proportion_return\":\"50\",\"goods_points\":7,\"is_have_point\":\"1\",\"model_id\":\"15156635008003640000\"}]},{\"store_name\":\"智能生活屋\",\"user_id\":\"3090\",\"store_id\":\"15110923292896270000\",\"list\":[{\"goods_price\":98,\"cart_id\":\"15232812214585490000\",\"user_id\":\"3090\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15154810744781680000\",\"goods_num\":\"1\",\"goods_name\":\"杜酷（DUKU） 无线蓝牙键盘多屏双通道蓝牙键盘通用\",\"goods_image\":\"http://img.lion-mall.com/goods/20180109/8885a44d743b75ccb0f3601686ddb719.jpg\",\"spec_desc\":\"\",\"spec1_name\":\"颜色\",\"spec1_value\":\"金色(积分价)\",\"spec2_name\":\"\",\"spec2_value\":\"\",\"proportion_return\":\"50\",\"goods_points\":31,\"is_have_point\":\"1\",\"model_id\":\"15154810744751190000\"}]},{\"store_name\":\"聚美佳品\",\"user_id\":\"2985\",\"store_id\":\"15028511939255260000\",\"list\":[{\"goods_price\":48,\"cart_id\":\"15232475994654440000\",\"user_id\":\"2985\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15153090695659930000\",\"goods_num\":\"2\",\"goods_name\":\"卡通抱枕被子两用 多功能暖手汽车空调被三合一\",\"goods_image\":\"http://img.lion-mall.com/goods/20180107/568058f3aaf01cd0297b26d75c1ff85a.png\",\"spec_desc\":\"\",\"spec1_name\":\"颜色\",\"spec1_value\":\"可爱猫\",\"spec2_name\":\"\",\"spec2_value\":\"\",\"proportion_return\":\"50\",\"goods_points\":0,\"is_have_point\":\"1\",\"model_id\":\"15153090695654650000\"}]},{\"store_name\":\"羽森家纺\",\"user_id\":\"267\",\"store_id\":\"14830180850588560000\",\"list\":[{\"goods_price\":380,\"cart_id\":\"15232475900203700000\",\"user_id\":\"267\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15155019232807690000\",\"goods_num\":\"1\",\"goods_name\":\"羽森高档双层纱贡缎阳绒四件套\",\"goods_image\":\"http://img.lion-mall.com/goods/20180109/7de0db542473faf6659ed457dda87275.jpg\",\"spec_desc\":\"\",\"spec1_name\":\"颜色\",\"spec1_value\":\"蒙特城堡（香槟灰）\",\"spec2_name\":\"规格\",\"spec2_value\":\"200*230\",\"proportion_return\":\"50\",\"goods_points\":0,\"is_have_point\":\"1\",\"model_id\":\"15155019232792440000\"}]},{\"store_name\":\"戈勒世家\",\"user_id\":\"1098\",\"store_id\":\"14879242960201500000\",\"list\":[{\"goods_price\":67,\"cart_id\":\"15232475545649120000\",\"user_id\":\"1098\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15168503821784490000\",\"goods_num\":\"2\",\"goods_name\":\"男士特色独眼怪兽胸包单肩包斜挎包时尚户外休闲包潮流男包\",\"goods_image\":\"http://img.lion-mall.com/goods/20180125/a355d78946c721565d2e44687f15f934.jpg\",\"spec_desc\":\"\",\"spec1_name\":\"颜色\",\"spec1_value\":\"黑色(积分兑)\",\"spec2_name\":\"\",\"spec2_value\":\"\",\"proportion_return\":\"50\",\"goods_points\":12,\"is_have_point\":\"1\",\"model_id\":\"15168503821773910000\"},{\"goods_price\":82,\"cart_id\":\"15232475436635450000\",\"user_id\":\"1098\",\"member_id\":\"15222940696559300000\",\"goods_id\":\"15168478480459580000\",\"goods_num\":\"1\",\"goods_name\":\"男士手提包AD18单肩包斜挎皮包商务公文包手提包\",\"goods_image\":\"http://img.lion-mall.com/goods/20180125/31966da605420f672712bd07a36dcd4a.jpg\",\"spec_desc\":\"\",\"spec1_name\":\"颜色\",\"spec1_value\":\"黑色(积分兑)\",\"spec2_name\":\"\",\"spec2_value\":\"\",\"proportion_return\":\"50\",\"goods_points\":23,\"is_have_point\":\"1\",\"model_id\":\"15168478480445350000\"}]}]}";
        jsonData.toString();
        Gson gson = new Gson();
        shopCartBeans = gson.fromJson(jsonData,ShoppingBean.class);
        data = null;
        data = shopCartBeans.getData();
        if(mallShopCartAdapter != null){
            mallShopCartAdapter.setmDatas(data);
            //通知改变
            mallShopCartAdapter.notifyDataSetChanged();
        }else {
            mallShopCartAdapter = new ShoppingCartAdapter(this,data);
            //设置垂直流循环视图
            rlvShopCart.setLayoutManager(new LinearLayoutManager(CartActivity.this,LinearLayoutManager.VERTICAL,false));
            rlvShopCart.setAdapter(mallShopCartAdapter);
            mallShopCartAdapter.setOnItemClickListener(this);
            mallShopCartAdapter.setOndeleteidClickListener(this); //删除的点击
        }
    }

    /**
     *  初始化控件
     */
    private void initView() {
        tvShopCartSelect = (CheckBox) findViewById(R.id.tv_shopcart_addselect); //全选
        tvShopCartTotalPrice = (TextView) findViewById(R.id.tv_shopcart_totalprice); //总价
        mBock_return = (ImageView)findViewById(R.id.bock_return); //返回
        rlvShopCart = (RecyclerView) findViewById(R.id.rlv_shopcart);//RecycleView
        tvShopCartSubmit = (TextView) findViewById(R.id.tv_shopcart_submit); //去结算
        //注册事件
        EventBus.getDefault().register(this);
    }


    @Override
    public void onItemClick(View view, ShoppingBean.DataBean data) {

    }

    //这里用了eventBus来进行实时价格的UI更改。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(UpdataButton event){
        //刷新UI
        tvShopCartTotalPrice.setText("￥" + event.getDiscribe());
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
            case R.id.bock_return: //返回
                finish();
                break;
            case R.id.tv_shopcart_addselect: //全选
                if (isSelect) {
                    tvShopCartSelect.setChecked(false);
                    isSelect = false;
                    mallShopCartAdapter.setAllselect(false);
                } else {
                    tvShopCartSelect.setChecked(true);
                    isSelect = true;
                    mallShopCartAdapter.setAllselect(true);
                }
                break;

            case R.id.tv_shopcart_submit:
                Toast.makeText(CartActivity.this,"支付功能暂未开通",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     *  删除的点击事件
     * @param view
     * @param id
     */
    @Override
    public void onIdClick(View view, String id) {
        //圆形的警告框
        new CommomDialog(CartActivity.this, R.style.dialog, "", new CommomDialog.OnCloseListener() {
            @Override
            public void onClick(Dialog dialog, boolean confirm) {
                if (confirm) {
                    Toast.makeText(CartActivity.this,"商品被删除了,调用删除接口删除掉该商品",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

            }
        }).setTitle("你确定要删除吗？").show();
    }
}