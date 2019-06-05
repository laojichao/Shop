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

import com.glut.shop.R;
import com.glut.shop.bean.ShoppingBean;
import com.glut.shop.bean.UpdataButton;
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
 * 购物车适配器
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> implements View.OnClickListener {
    private Context context;
    private List<ShoppingBean.DataBean> data;
    public ShoppingcaCartAdapter mShopCartAdapter;
    private OnRecyclerViewItemClickListener  onItemClickListener;
    private  OndeleteidClickListener ondeleteidClickListener;
    private List<String> mList;

    public ShoppingCartAdapter(Context context, List<ShoppingBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ShoppingCartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_shopcart, parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ShoppingCartAdapter.MyViewHolder holder, final int position) {
        final ShoppingBean.DataBean cartBean = data.get(position);
        String Store_name = data.get(position).getStore_name();
        if (!TextUtils.isEmpty(Store_name)) {
            holder.tvShopCartShopName.setText(Store_name);     //商店名称
        }

        //删除
        holder.tvShopCartdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteID = getDeleteID(cartBean);
                if (ondeleteidClickListener!=null){
                    if (mList.size()==0){

                        Toast.makeText(context,"请选择需要删除的商品",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ondeleteidClickListener.onIdClick(v,deleteID);
                }
            }
        });

        holder.ivShopCartShopSel.setOnCheckedChangeListener(null);
        //读取实体内存储的选中状态
        holder.ivShopCartShopSel.setChecked(cartBean.isSelect());
        holder.ivShopCartShopSel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //更改item选中状态同时进行实体内的选中状态改变
                cartBean.setSelect(isChecked);
                //外层选中状态改变后，要遍历改变子recyclerView内item的选中状态
                for (ShoppingBean.DataBean.ListBean cartItemResultDtoList : cartBean.getList()) {
                    cartItemResultDtoList.setSelect(isChecked);
                }
                notifyDataSetChanged();
                EventBus.getDefault().post(new UpdataButton(getAllPrice()));
            }
        });
        holder.itemView.setTag(cartBean);//传object回去
        //单个商家的商品列表不需要滑动，所以在这里禁止掉商品item的滑动事件
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        List<ShoppingBean.DataBean.ListBean> listBeanList = data.get(position).getList();
        //这里是初始化商品item的recyclerView,将外层实例传入子层以便刷新
        mShopCartAdapter = new ShoppingcaCartAdapter(context, cartBean.getList(), cartBean, this);
        holder.recyChariView.setLayoutManager(linearLayoutManager);

        holder.recyChariView.setAdapter(mShopCartAdapter);
        //下面两句是防止刷新商品的recyclerView导致商家recyclerView也发生滑动
        holder.recyChariView.setFocusableInTouchMode(false);
        holder.recyChariView.requestFocus();

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


    //设置全选/全不选
    public void setAllselect(boolean b){
        for(int i=0;i<data.size();i++){
            data.get(i).setSelect(b);
            for (ShoppingBean.DataBean.ListBean cartItemResultDtoList : data.get(i).getList()){
                cartItemResultDtoList.setSelect(b);
            }
        }
        notifyDataSetChanged();
        //发送 消息
        EventBus.getDefault().post(new UpdataButton(getAllPrice()));
    }

    /**
     *  需要删除的内容
     * @return
     */
    public String getSelectTitle(){
        StringBuffer stringBuffer=new StringBuffer();
        if(data!=null){
            for (int i=0;i<data.size();i++){
                List<ShoppingBean.DataBean.ListBean> mdata=data.get(i).getList();
                for (int y=0;y<mdata.size();y++){
                    if(mdata.get(y).isSelect()){
                        stringBuffer.append(mdata.get(y).getGoods_name());
                        if(y<mdata.size()-1){
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
    public void setmDatas( List<ShoppingBean.DataBean> mDatas){
        this.data=mDatas;
    }
    public List<ShoppingBean.DataBean> getData(){

        return data;

    }

    //获取需要商品总价格
    public String getAllPrice(){
        BigDecimal allprice =new  BigDecimal("0");
        if(data!=null){
            for (int i=0;i<data.size();i++){
                List<ShoppingBean.DataBean.ListBean> mdata=data.get(i).getList();
                for (int y=0;y<mdata.size();y++){
                    if(mdata.get(y).isSelect()){
                        Log.i("单价", "getAllPrice: ----->"+mdata.get(y).getGoods_price()); //价格
                        BigDecimal interestRate = new BigDecimal(mdata.get(y).getGoods_num()); //数量
                        double interest = Arith.mul(mdata.get(y).getGoods_price(), interestRate);
                        allprice=allprice.add(BigDecimal.valueOf(interest));
                        Log.i("总价", allprice+"allprice"+interest+"interestRate"+interestRate); //价格
                    }
                }
            }
        }
        return  allprice.toString();
    }

    //获取需要删除的商品id
    public String getDeleteProductID(){
        StringBuffer stringBuffer=new StringBuffer();
        if(data!=null){
            for (int i=0;i<data.size();i++){
                List<ShoppingBean.DataBean.ListBean> mdata=data.get(i).getList();
                for (int y=0;y<mdata.size();y++){
                    if(mdata.get(y).isSelect()){
                        stringBuffer.append(mdata.get(y).getGoods_id());
                        if(y<mdata.size()-1){
                            stringBuffer.append(",");
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    //获取需要删除的商品id
    public String getDeleteID(ShoppingBean.DataBean cartBean ){
        StringBuffer stringBuffer= new StringBuffer();
        mList = new ArrayList<>();
        if (cartBean!=null){
            int size = cartBean.getList().size();
            mList.clear();
            for (int i = 0; i <size ; i++) {
                if (cartBean.getList().get(i).isSelect()){
                    stringBuffer.append(cartBean.getList().get(i).getGoods_id());
                    mList.add(cartBean.getList().get(i).getGoods_id());
                    if(i<size-1){
                        stringBuffer.append(",");
                    }
                }
            }

        }

        return stringBuffer.toString();

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox ivShopCartShopSel;
        private TextView tvShopCartShopName;
        private LinearLayout llShopCartHeader;
        private RecyclerView recyChariView;
        private TextView tvShopCartdefault;

        public MyViewHolder(View view) {
            super(view);
            llShopCartHeader = (LinearLayout) view.findViewById(R.id.ll_shopcart_header); //商店头部
            ivShopCartShopSel = (CheckBox) view.findViewById(R.id.iv_item_shopcart_shopselect); //商店是否选中
            tvShopCartShopName = (TextView) view.findViewById(R.id.tv_item_shopcart_shopname); //商店名称
            tvShopCartdefault = (TextView) view.findViewById(R.id.tv_default);//商店删除
            recyChariView = (RecyclerView) view.findViewById(R.id.recy_view);

        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, ShoppingBean.DataBean data);
    }

    /**
     *  条目的点击事件
     * @param listener
     */
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public  interface  OndeleteidClickListener{
        void  onIdClick(View view, String id);

    }

    /**
     *  删除条目
     */
    public  void  setOndeleteidClickListener(OndeleteidClickListener listener){
        this.ondeleteidClickListener =listener;
    }
}