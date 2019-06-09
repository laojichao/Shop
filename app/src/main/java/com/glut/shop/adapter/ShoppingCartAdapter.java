package com.glut.shop.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.glut.shop.BuildConfig;
import com.glut.shop.R;
import com.glut.shop.bean.ShoppingBean;
import com.glut.shop.bean.ShoppingBean.DataBean;
import com.glut.shop.bean.ShoppingBean.DataBean.ListBean;
import com.glut.shop.bean.UpdataButton;
import com.glut.shop.database.CartDBHelper;
import com.glut.shop.util.Arith;

import org.greenrobot.eventbus.EventBus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCartAdapter
 *
 * @author lao
 * @date 2019/5/31
 *
 * 购物车店铺适配器
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> implements OnClickListener {
    private static final String TAG ="ShoppingCartAdapter";
    private Context mContext;       //上下文对象
    private List<DataBean> data;        //商店列表数据
    private ShoppingItemCartAdapter mShopCartAdapter;        //商品项卡片适配器
    private OnRecyclerViewItemClickListener  onItemClickListener;       //循环视图点击监听器
    private  OndeleteidClickListener ondeleteidClickListener;       //删除监听器
    private List<String> mList;         //商品要删除id列表
    private CartDBHelper mHelper;

    public ShoppingCartAdapter(Context mContext, List<ShoppingBean.DataBean> data, CartDBHelper mHelper) {
        this.mContext = mContext;
        this.data = data;
        this.mHelper = mHelper;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据布局构建视图
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_shopcart, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        //每个子项的点击监听
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final DataBean cartBean = data.get(position);       //购物车每个店铺
        String Store_name = data.get(position).getStore_name();
        //设置店铺名字
        if (!TextUtils.isEmpty(Store_name)) {
            holder.tv_shopcart_shopname.setText(Store_name);     //商店名称
        }

        //删除
        holder.tv_shopcart_delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String deleteID = getDeleteID(cartBean);
                if (ondeleteidClickListener != null){
                    if (mList.size()==0){
                        Toast.makeText(mContext,"请选择需要删除的商品",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ondeleteidClickListener.onIdClick(v, mList);
                }
            }
        });

        holder.ck_item_shopcart_shopselect.setOnCheckedChangeListener(null);
        //读取实体内存储的选中状态
        holder.ck_item_shopcart_shopselect.setChecked(cartBean.isSelect());
        holder.ck_item_shopcart_shopselect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //更改item选中状态同时进行实体内的选中状态改变
                cartBean.setSelect(isChecked);
                //外层选中状态改变后，要遍历改变子recyclerView内item的选中状态
                for (ShoppingBean.DataBean.ListBean cartItemResultDtoList : cartBean.getList()) {
                    cartItemResultDtoList.setSelect(isChecked);
                }
                notifyDataSetChanged();
                UpdataButton update = new UpdataButton();
                update.setDiscribe(getAllPrice());
                update.setCount(getAllCount());
                EventBus.getDefault().post(update);
            }
        });
        holder.itemView.setTag(cartBean);//传object回去
        //单个商家的商品列表不需要滑动，所以在这里禁止掉商品item的滑动事件
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        List<ShoppingBean.DataBean.ListBean> listBeanList = data.get(position).getList();
        //这里是初始化商品item的recyclerView,将外层实例传入子层以便刷新
        mShopCartAdapter = new ShoppingItemCartAdapter(mContext, cartBean.getList(), cartBean, this, mHelper);
        holder.rv_char_view.setLayoutManager(linearLayoutManager);

        holder.rv_char_view.setAdapter(mShopCartAdapter);
        //下面两句是防止刷新商品的recyclerView导致商家recyclerView也发生滑动
        holder.rv_char_view.setFocusableInTouchMode(false);
        holder.rv_char_view.requestFocus();
    }


    @Override
    public int getItemCount() {
        return  (data == null ? 0 : data.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            onItemClickListener.onItemClick(v,(ShoppingBean.DataBean) v.getTag());
        }
    }


    //设置全选/全不选,更改数据库状态
    public void setAllselect(boolean b){
        for(int i = 0;i < data.size(); i++){
            data.get(i).setSelect(b);
            for (ListBean cartItemResultDtoList : data.get(i).getList()){
                cartItemResultDtoList.setSelect(b);
                mHelper.updateBySelect(b ? 1 : 0, cartItemResultDtoList.getGoods_id());
            }
        }
        notifyDataSetChanged();
        //发送 消息
        UpdataButton update = new UpdataButton();
        update.setDiscribe(getAllPrice());
        update.setCount(getAllCount());
        EventBus.getDefault().post(update);
    }

    /**
     *  需要删除的内容
     * @return
     */
    public String getSelectTitle(){
        StringBuffer stringBuffer = new StringBuffer();
        if(data != null){
            for (int i = 0;i < data.size(); i++){
                List<ListBean> mdata = data.get(i).getList();
                for (int y = 0;y < mdata.size(); y++){
                    if(mdata.get(y).isSelect()){
                        stringBuffer.append(mdata.get(y).getGoods_name());
                        if(y<mdata.size() - 1){
                            stringBuffer.append(",");
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     *  获取 最新集合数据
     * @param mDatas
     */
    public void setDatas( List<DataBean> mDatas){
        this.data = mDatas;
    }
    public List<DataBean> getData(){
        return data;
    }

    //获取需要商品总价格
    public String getAllPrice(){
        BigDecimal allprice = new  BigDecimal("0");
        if(data != null){
            for (int i = 0;i < data.size(); i++){
                List<ListBean> mdata = data.get(i).getList();
                for (int j = 0;j < mdata.size(); j++){
                    if(mdata.get(j).isSelect()){
//                        Log.i("单价", "getAllPrice: ----->" + mdata.get(j).getGoods_price()); //价格
                        BigDecimal interestRate = new BigDecimal(mdata.get(j).getGoods_num()); //数量
                        double interest = Arith.mul(mdata.get(j).getGoods_price(), interestRate);
                        allprice = allprice.add(BigDecimal.valueOf(interest));
//                        Log.i("总价", allprice + "allprice" + interest + "interestRate" + interestRate); //价格
                    }
                }
            }
        }
        return  allprice.toString();
    }

    //获取 商品数量
    public String getAllCount(){
        int count = 0;
        if(data != null){
            for (int i = 0;i < data.size(); i++){
                List<ListBean> mdata = data.get(i).getList();
                for (int j = 0;j < mdata.size(); j++){
                    if(mdata.get(j).isSelect()){
                        count += mdata.get(j).getGoods_num();
                    }
                }
            }
        }
        return  String.valueOf(count);
    }

    //获取需要删除的商品id多个商品
    public String getDeleteID(DataBean cartBean ){
        StringBuffer stringBuffer = new StringBuffer();
        mList = new ArrayList<>();
        if (cartBean != null){
            int size = cartBean.getList().size();
//            Log.d(TAG, "getDeleteID: size=" + size);
            mList.clear();
            for (int i = 0; i < size; i++) {
                if (cartBean.getList().get(i).isSelect()){
                    stringBuffer.append(cartBean.getList().get(i).getGoods_id());
                    mList.add(cartBean.getList().get(i).getGoods_id());
                    if(i < size - 1){
                        stringBuffer.append(",");
                    }
                }
            }

        }
//        Log.d(TAG, "getDeleteID: stringBuffer=" + stringBuffer);
        return stringBuffer.toString();
    }

    //循环视图点击监听器接口
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, DataBean data);
    }

    /**
     *  条目的点击事件
     * @param listener
     */
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    //删除监听器接口
    public  interface  OndeleteidClickListener{
        void  onIdClick(View view, List<String> id);
    }

    /**
     *  删除条目
     */
    public  void  setOndeleteidClickListener(OndeleteidClickListener listener){
        this.ondeleteidClickListener = listener;
    }

    //构建视图
    class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox ck_item_shopcart_shopselect;
        private TextView tv_shopcart_shopname;
        private LinearLayout ll_shopcart_header;
        private RecyclerView rv_char_view;
        private TextView tv_shopcart_delete;

        public MyViewHolder(View view) {
            super(view);
            ll_shopcart_header = view.findViewById(R.id.ll_shopcart_header); //商店头部
            ck_item_shopcart_shopselect = view.findViewById(R.id.ck_item_shopcart_shopselect); //商店是否选中
            tv_shopcart_shopname = view.findViewById(R.id.tv_shopcart_shopname); //商店名称
            tv_shopcart_delete = view.findViewById(R.id.tv_delete);//商店删除
            rv_char_view = view.findViewById(R.id.recy_view);

        }
    }

}