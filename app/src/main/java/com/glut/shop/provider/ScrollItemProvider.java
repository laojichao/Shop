package com.glut.shop.provider;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.glut.shop.R;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.adapter.HomeItemAdapter;
import com.glut.shop.bean.CategoryBean;

/**
 * C
 * Describe:通栏横向滑动
 */

public class ScrollItemProvider extends BaseItemProvider<CategoryBean.DataBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return HomeAdapter.TYPE_HORIZONTAL_SCROLL;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_scroll;
    }

    @Override
    public void convert(BaseViewHolder helper, CategoryBean.DataBean data, int position) {
        RecyclerView mRecyclerView = helper.getView(R.id.item_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        HomeItemAdapter adapter = new HomeItemAdapter();
        adapter.setNewData(data.getDataList());
        mRecyclerView.setAdapter(adapter);
    }
}
