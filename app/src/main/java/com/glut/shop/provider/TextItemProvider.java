package com.glut.shop.provider;

import android.util.Log;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.glut.shop.R;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.bean.CategoryBean;

/**
 * Created by Administrator on 2018/6/30.
 * Describe:文本样式
 */

public class TextItemProvider extends BaseItemProvider<CategoryBean.DataBean.DataListBean, BaseViewHolder> {
    private static final String TAG = "TextItemProvider";
    
    @Override
    public int viewType() {
        return HomeAdapter.TYPE_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_text;
    }

    @Override
    public void convert(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        helper.setText(R.id.item_tv_main_title, data.getTitle()+"")
                .setText(R.id.item_tv_subtitle, data.getDesc()+"");
    }

    @Override
    public void onClick(BaseViewHolder helper, CategoryBean.DataBean.DataListBean data, int position) {
        super.onClick(helper, data, position);
        Log.d(TAG, "onClick: ");
    }
}
