package com.glut.shop.provider;

import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.glut.shop.R;
import com.glut.shop.activity.ProductInfoActivity;
import com.glut.shop.adapter.HistoryAdapter;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.bean.CategoryBean;

/**
 * Created by Administrator on 2018/7/4.
 * Describe:三列图文
 */

public class ThreeColumnItemProvider extends BaseItemProvider<CategoryBean.DataBean.DataListBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return HistoryAdapter.TYPE_THREE_COLUMN;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_three_column;
    }

    @Override
    public void onClick(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        super.onClick(helper, data, position);
        Intent intent = new Intent(mContext, ProductInfoActivity.class);
        intent.putExtra("goods_id", data.getId());
        mContext.startActivity(intent);
    }

    @Override
    public void convert(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        helper.setText(R.id.item_tv, data.getDesc().substring(0,7) + "...");
        Glide.with(mContext)
                .load(data.getImgURL())
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img));
    }
}
