package com.glut.shop.provider;

import android.support.v7.widget.AppCompatImageView;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.glut.shop.R;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.bean.CategoryBean;

/**
 *
 * Describe:图片Item，通栏商品大图片
 */

public class ImgItemProvider extends BaseItemProvider<CategoryBean.DataBean.DataListBean, BaseViewHolder> {
    private static final String TAG = "ImgItemProvider";

    @Override
    public int viewType() {
        return HomeAdapter.TYPE_IMG;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_img;
    }

    @Override
    public void convert(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        Glide.with(mContext)
                .load(data.getImgURL())
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img));
    }

    /*
    * 处理点击事件
    * */
    @Override
    public void onClick(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        super.onClick(helper, data, position);
        Log.d(TAG, "onClick: ========================================点击了");
    }

}
