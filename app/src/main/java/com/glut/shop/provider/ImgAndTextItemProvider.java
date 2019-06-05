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
 * Describe:Item样式二：通栏图片+主副标题
 */

public class ImgAndTextItemProvider extends BaseItemProvider<CategoryBean.DataBean.DataListBean, BaseViewHolder> {
    private static final String TAG = "ImgAndTextItemProvider";
    
    @Override
    public int viewType() {
        return HomeAdapter.TYPE_TEXT_AND_IMG;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_img_and_text;
    }

    @Override
    public void convert(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        helper.setText(R.id.item_tv_main_title, data.getTitle() + "")
                .setText(R.id.item_tv_subtitle, data.getDesc() + "");

        Glide.with(mContext)
                .load(data.getImgURL())
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_double_img));
    }

    @Override
    public void onClick(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        super.onClick(helper, data, position);
        Log.d(TAG, "onClick: 处理点击事件");
    }

}
