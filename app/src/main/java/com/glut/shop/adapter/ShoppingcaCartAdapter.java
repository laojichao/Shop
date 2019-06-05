package com.glut.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.glut.shop.R;
import com.glut.shop.bean.ShoppingBean;
import com.glut.shop.bean.UpdataButton;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * CartPagerAdapter
 *
 * @author lao
 * @date 2019/5/30
 */
public class ShoppingcaCartAdapter extends RecyclerView.Adapter<ShoppingcaCartAdapter.MyShoppViewHolder> {
    private Context mContext;
    private View headerView;
    private List<ShoppingBean.DataBean.ListBean> mDatas;
    private OnEditClickListener mOnEditClickListener;
    private OnDeleteClickListener mOnDeleteClickListener;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener onItemClickListener;
    ShoppingBean.DataBean bean;
    ShoppingCartAdapter shoppingCartAdapter;

    public ShoppingcaCartAdapter(Context context, List<ShoppingBean.DataBean.ListBean> jsonArray, ShoppingBean.DataBean bean, ShoppingCartAdapter mallShopCartAdapter2) {
        this.mContext = context;
        this.mDatas = jsonArray;
        this.bean = bean;
        this.shoppingCartAdapter = mallShopCartAdapter2;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ShoppingcaCartAdapter.MyShoppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_shopcartview, parent, false);
        return new ShoppingcaCartAdapter.MyShoppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShoppingcaCartAdapter.MyShoppViewHolder holder, final int position) {
        String goods_name = mDatas.get(position).getGoods_name(); //商品名称
        String goods_image = mDatas.get(position).getGoods_image();  //图片
        int goods_num = mDatas.get(position).getGoods_num(); //数量
        double goods_price = mDatas.get(position).getGoods_price();  //商品价格
        String goods_points = mDatas.get(position).getGoods_points();//积分


        if (!TextUtils.isEmpty(goods_name)) {
            holder.tvShopCartClothName.setText(goods_name);
        }

        if (!TextUtils.isEmpty(goods_image)) {
            Glide.with(mContext).load(goods_image).error(R.mipmap.log_img) .into(holder.ivShopCartClothPic);
        }

        if (!TextUtils.isEmpty(goods_num + "")) {
            holder.etShopCartClothNum.setText(goods_num + "");
        }

        holder.tvShopCartClothPrice.setText(goods_price + "");
        if (!TextUtils.isEmpty(goods_points)) {
            holder.GoodsPoints.setText(goods_points + "积分");
        }


        /**
         *  点击减号
         */
        holder.ivShopCartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDatas.get(position).getGoods_num() > 1) {
                    int count = mDatas.get(position).getGoods_num() - 1;
                    if (mOnEditClickListener != null) {
                        mOnEditClickListener.onEditClick(position, mDatas.get(position).getUser_id(), count);
                    }
                    mDatas.get(position).setGoods_num(count);
                    EventBus.getDefault().post(new UpdataButton(shoppingCartAdapter.getAllPrice()));
                    notifyDataSetChanged();
                }
            }
        });

        /**
         * 加号的点击
         */
        holder.ivShopCartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = mDatas.get(position).getGoods_num() + 1;
                if (mOnEditClickListener != null) {
                    mOnEditClickListener.onEditClick(position, mDatas.get(position).getUser_id(), count);
                }
                mDatas.get(position).setGoods_num(count);
                EventBus.getDefault().post(new UpdataButton(shoppingCartAdapter.getAllPrice()));
                notifyDataSetChanged();
            }
        });
        /**
         * 商品删除
         */
        holder.ivShopCartClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(v, position);
            }
        });

        holder.ivShopCartClothSel.setOnCheckedChangeListener(null);

        final ShoppingBean.DataBean.ListBean cartBean = mDatas.get(position);
        //读取实体内存储的选中状态
        holder.ivShopCartClothSel.setChecked(cartBean.isSelect());

        holder.ivShopCartClothSel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //更改item选中状态同时进行实体内的选中状态改变
                cartBean.setSelect(isChecked);
                boolean noSelect = false;
                //内层item选中状态改变后要遍历判断是否全选，以改变外层item的选中状态
                for (ShoppingBean.DataBean.ListBean cartItemResultDtoList : mDatas) {
                    if (!cartItemResultDtoList.isSelect()) {
                        noSelect = true;
                    }
                }
                if (!noSelect) {
                    bean.setSelect(!noSelect);
                    shoppingCartAdapter.notifyDataSetChanged();
                } else {
                    bean.setSelect(!noSelect);
                    shoppingCartAdapter.notifyDataSetChanged();
                }
                EventBus.getDefault().post(new UpdataButton(shoppingCartAdapter.getAllPrice()));
            }
        });

        holder.itemView.setTag(mDatas.get(position));//传object回去

        holder.parenttView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void showDialog(final View view, final int position) {
        //调用删除某个规格商品的接口
        if (mOnDeleteClickListener != null) {
            mOnDeleteClickListener.onDeleteClick(view, position, mDatas.get(position).getGoods_id());
        }
        mDatas.remove(position);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (mDatas == null ? 0 : mDatas.size());
    }

    class MyShoppViewHolder extends RecyclerView.ViewHolder {
        
        private TextView tvShopCartClothName;
        private TextView tvShopCartClothPrice;
        private TextView etShopCartClothNum;
        private CheckBox ivShopCartClothSel;
        private TextView ivShopCartClothMinus;
        private TextView ivShopCartClothAdd;
        private ImageView ivShopCartClothDelete;
        private ImageView ivShopCartClothPic;
        private TextView GoodsPoints;
        private LinearLayout parenttView;

        public MyShoppViewHolder(View view) {
            super(view);
            tvShopCartClothName = (TextView) view.findViewById(R.id.tv_item_shopcart_clothname); //商品名称
            tvShopCartClothPrice = (TextView) view.findViewById(R.id.tv_shopping_rmb); //价格
            etShopCartClothNum = (TextView) view.findViewById(R.id.et_item_shopcart_cloth_num); //商品数量
            ivShopCartClothSel = (CheckBox) view.findViewById(R.id.tv_item_shopcart_clothselect); //商品是否选中
            ivShopCartClothMinus = (TextView) view.findViewById(R.id.iv_item_shopcart_cloth_minus); //减号
            ivShopCartClothAdd = (TextView) view.findViewById(R.id.iv_item_shopcart_cloth_add); //加号
            ivShopCartClothPic = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_pic); //图片
            ivShopCartClothDelete = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_delete);//商品删除
            GoodsPoints = (TextView) view.findViewById(R.id.tv_goods_points);
            parenttView = (LinearLayout) view.findViewById(R.id.ll_parenttView);
        }
    }

    /**
     * 减的监听
     */
    public interface OnEditClickListener {
        void onEditClick(int position, String cartid, int count);
    }


    /**
     * 删除按键
     */
    public interface OnDeleteClickListener {
        void onDeleteClick(View view, int position, String cartid);
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, ShoppingBean.DataBean.ListBean data);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setAllselect(boolean b) {
        for (int i = 0; i < mDatas.size(); i++) {
            mDatas.get(i).setSelect(b);
        }
    }
}