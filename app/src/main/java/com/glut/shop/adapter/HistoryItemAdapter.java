package com.glut.shop.adapter;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.glut.shop.bean.CategoryBean.DataBean.DataListBean;
import com.glut.shop.R;


/**
 * Created by Administrator on 2018/7/4.
 * Describe:
 */

public class HistoryItemAdapter extends BaseQuickAdapter<DataListBean, BaseViewHolder> {
    public HistoryItemAdapter() {
        super(R.layout.app_item_home_scroll_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataListBean item) {
        Glide.with(mContext)
                .load(item.getImgURL())
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img_item));
    }
}
