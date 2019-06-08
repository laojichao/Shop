package com.glut.shop.provider;

import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.glut.shop.activity.ProductInfoActivity;
import com.glut.shop.bean.CategoryBean.DataBean.DataListBean;
import com.glut.shop.R;
import com.glut.shop.adapter.HomeAdapter;
import com.glut.shop.util.ToastUtils;

/**
 *
 * Describe:两列图文
 */

public class TwoColumnItemProvider extends BaseItemProvider<DataListBean, BaseViewHolder> {
    private static final String TAG = "TwoColumnItemProvider";

    @Override
    public int viewType() {
        return HomeAdapter.TYPE_TWO_COLUMN;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_two_column;
    }

    @Override
    public void convert(BaseViewHolder helper, DataListBean data, int position) {
        //设置图片,价格，id,
            helper.setText(R.id.item_goods_price, "￥："+ data.getPrice())
                    .setText(R.id.item_goods_name, data.getDesc()+"");
            Glide.with(mContext)
                    .load(data.getImgURL())
                    .dontAnimate()
                    .into((AppCompatImageView) helper.getView(R.id.item_goods_img));
    }

    @Override
    public void onClick(BaseViewHolder helper, DataListBean data, int position) {
        Intent intent = new Intent(mContext, ProductInfoActivity.class);
        intent.putExtra("goods_id", data.getId());
        mContext.startActivity(intent);
//        ToastUtils.showToast(mContext, data.getDesc());
    }
}
