package com.glut.shop.provider;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.glut.shop.R;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.bean.CategoryBean;

/**
 *
 * Describe:通栏窄图片
 */

public class NarrowImgItemProvider extends BaseItemProvider<CategoryBean.DataBean.DataListBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return HomeAdapter.TYPE_NARROW_IMG;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_narrow_img;
    }

    @Override
    public void convert(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        Glide.with(mContext)
                .load(data.getImgURL())
                .into((AppCompatImageView) helper.getView(R.id.item_narrow_img));
    }
}
