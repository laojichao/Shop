package com.glut.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
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
import com.glut.shop.activity.ProductInfoActivity;
import com.glut.shop.bean.ShoppingBean.DataBean;
import com.glut.shop.bean.ShoppingBean.DataBean.ListBean;
import com.glut.shop.adapter.ShoppingItemCartAdapter.MyShoppViewHolder;
import com.glut.shop.bean.UpdataButton;
import com.glut.shop.database.CartDBHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * CartPagerAdapter
 *
 * @author lao
 * @date 2019/5/30
 *
 * 购物车商品项适配器
 */
public class ShoppingItemCartAdapter extends RecyclerView.Adapter<MyShoppViewHolder> {
    private static final String TAG = "ShoppingItemCartAdapter";
    private Context mContext;       //上下文对象
    private List<ListBean> mDatas;        //商品列表
    private OnEditClickListener mOnEditClickListener;       //编辑框监听器
    private OnDeleteClickListener mOnDeleteClickListener;    //删除监听器
    private OnRecyclerViewItemClickListener onItemClickListener;        //点击监听器
    private DataBean bean;          //商店
    private ShoppingCartAdapter rv_ShopCartAdapter;
    private CartDBHelper mHplper;

    public ShoppingItemCartAdapter(Context context, List<ListBean> listBeans, DataBean bean, ShoppingCartAdapter shopCartAdapter, CartDBHelper cartDBHelper) {
        this.mContext = context;
        this.mDatas = listBeans;
        this.bean = bean;
        this.rv_ShopCartAdapter = shopCartAdapter;
        this.mHplper = cartDBHelper;
    }

    @Override
    public ShoppingItemCartAdapter.MyShoppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //构建视图
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_shopcartview, parent, false);
        return new ShoppingItemCartAdapter.MyShoppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShoppingItemCartAdapter.MyShoppViewHolder holder, final int position) {
        //视图绑定
        String goods_name = mDatas.get(position).getGoods_name(); //商品名称
        String goods_image = mDatas.get(position).getGoods_image();  //图片
        int goods_num = mDatas.get(position).getGoods_num();        //数量
        double goods_price = mDatas.get(position).getGoods_price();  //商品价格
        if (!TextUtils.isEmpty(goods_name)) {
            holder.tv_item_shopcart_name.setText(goods_name);
        }

        Glide.with(mContext)
                .load(goods_image)
                .error(R.mipmap.log_img)
                .into(holder.iv_item_shopcart_pic);
        holder.et_item_shopcart_count.setText(goods_num + "");
        holder.tv_shopping_price.setText(goods_price + "");

        //减号监听器
        holder.iv_item_shopcart_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDatas.get(position).getGoods_num() > 1) {
                    int count = mDatas.get(position).getGoods_num() - 1;
                    String id = mDatas.get(position).getGoods_id();
                    mDatas.get(position).setGoods_num(count);
                    mHplper.update(count, id);
                    if (mOnEditClickListener != null) {
                        mOnEditClickListener.onEditClick(position, mDatas.get(position).getUser_id(), count);
                    }
                    UpdataButton updataButton = new UpdataButton();
                    updataButton.setDiscribe(rv_ShopCartAdapter.getAllPrice());
                    updataButton.setCount(rv_ShopCartAdapter.getAllCount());
                    EventBus.getDefault().post(updataButton);
                    notifyDataSetChanged();
                }
            }
        });

        //加号监听器
        holder.iv_item_shopcart_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = mDatas.get(position).getGoods_num() + 1;
                String id = mDatas.get(position).getGoods_id();
                mDatas.get(position).setGoods_num(count);
                mHplper.update(count, id);
                if (mOnEditClickListener != null) {
                    mOnEditClickListener.onEditClick(position, mDatas.get(position).getUser_id(), count);
                }
                UpdataButton updataButton = new UpdataButton();
                updataButton.setDiscribe(rv_ShopCartAdapter.getAllPrice());
                updataButton.setCount(rv_ShopCartAdapter.getAllCount());
                EventBus.getDefault().post(updataButton);
                notifyDataSetChanged();
            }
        });
        //删除监听器
        holder.iv_item_shopcart_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v, position);
            }
        });

        holder.tv_item_shopcart_select.setOnCheckedChangeListener(null);
        final ListBean cartBean = mDatas.get(position);
        holder.tv_item_shopcart_select.setChecked(cartBean.isSelect());//读取实体内存储的选中状态
        //选中监听器
        holder.tv_item_shopcart_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //更改item选中状态同时进行实体内的选中状态改变
                cartBean.setSelect(isChecked);
                boolean noSelect = false;
                //内层item选中状态改变后要遍历判断是否全选，以改变外层item的选中状态
                for (ListBean cartItemResultDtoList : mDatas) {
                    if (!cartItemResultDtoList.isSelect()) {
                        noSelect = true;
                    }
                }
                mHplper.updateBySelect(!noSelect ? 1 : 0, mDatas.get(position).getGoods_id());
                if (!noSelect) {
                    bean.setSelect(!noSelect);
                    rv_ShopCartAdapter.notifyDataSetChanged();
                } else {
                    bean.setSelect(!noSelect);
                    rv_ShopCartAdapter.notifyDataSetChanged();
                }
                UpdataButton updataButton = new UpdataButton();
                updataButton.setDiscribe(rv_ShopCartAdapter.getAllPrice());
                updataButton.setCount(rv_ShopCartAdapter.getAllCount());
                EventBus.getDefault().post(updataButton);
            }
        });

        holder.itemView.setTag(mDatas.get(position));//传object回去
        //视图点击监听器
        holder.ll_parent_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position > -1) {
                    Intent intent = new Intent(mContext, ProductInfoActivity.class);
                    intent.putExtra("goods_id", mDatas.get(position).getGoods_id());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    //小图片删除
    private void showDialog(final View view, final int position) {
        //调用删除某个规格商品的接口

        if (mOnDeleteClickListener != null) {
            //删除相应的商品项视图
//            Log.d(TAG, "showDialog: 删除");
            mOnDeleteClickListener.onDeleteClick(view, position, mDatas.get(position).getGoods_id());
        }
//        Log.d(TAG, "showDialog: 商品id=" + mDatas.get(position).getGoods_id());
        mHplper.delete(String.format("goods_id='%s'", mDatas.get(position).getGoods_id()));
        mDatas.remove(position);
        if (mDatas.size() == 0) {
//            Log.d(TAG, "showDialog: ");
            EventBus.getDefault().post(bean);//EventBus发送
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (mDatas == null ? 0 : mDatas.size());
    }

    public interface OnEditClickListener {
        void onEditClick(int position, String cartid, int count);
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(View view, int position, String cartid);
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, ListBean data);
    }
    public void setOnEditClickListener(OnEditClickListener listener) {
        this.mOnEditClickListener = listener;
    }

    public void setOnDeleteClickListener(OnDeleteClickListener listener) {
        this.mOnDeleteClickListener = listener;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setAllselect(boolean b) {
        for (int i = 0; i < mDatas.size(); i++) {
            mDatas.get(i).setSelect(b);
        }
    }

    class MyShoppViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout ll_parent_View;
        private CheckBox tv_item_shopcart_select;
        private ImageView iv_item_shopcart_pic;
        private TextView tv_item_shopcart_name;
        private TextView tv_shopping_price;
        private TextView et_item_shopcart_count;
        private TextView iv_item_shopcart_minus;
        private TextView iv_item_shopcart_add;
        private ImageView iv_item_shopcart_delete;

        public MyShoppViewHolder(View view) {
            super(view);
            ll_parent_View = view.findViewById(R.id.ll_parent_View);
            tv_item_shopcart_select = view.findViewById(R.id.tv_item_shopcart_select); //商品是否选中
            iv_item_shopcart_pic = view.findViewById(R.id.iv_item_shopcart_pic); //图片
            tv_item_shopcart_name = view.findViewById(R.id.tv_item_shopcart_name); //商品名称
            tv_shopping_price = view.findViewById(R.id.tv_shopping_price); //价格
            et_item_shopcart_count = view.findViewById(R.id.et_item_shopcart_count); //商品数量
            iv_item_shopcart_minus = view.findViewById(R.id.iv_item_shopcart_minus); //减号
            iv_item_shopcart_add = view.findViewById(R.id.iv_item_shopcart_add); //加号
            iv_item_shopcart_delete = view.findViewById(R.id.iv_item_shopcart_delete);//商品删除

        }
    }

}