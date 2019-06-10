package com.glut.shop.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.glut.shop.bean.CategoryBean;
import com.glut.shop.provider.ImgAndTextItemProvider;
import com.glut.shop.bean.CategoryBean.DataBean.DataListBean;
import com.glut.shop.provider.ImgItemProvider;
import com.glut.shop.provider.NarrowImgItemProvider;
import com.glut.shop.provider.ScrollItemProvider;
import com.glut.shop.provider.TextItemProvider;
import com.glut.shop.provider.ThreeColumnItemProvider;
import com.glut.shop.provider.TwoColumnItemProvider;


/**
 * Created by Administrator on 2018/6/30.
 * Describe:历史
 */

public class HistoryAdapter extends MultipleItemRvAdapter<CategoryBean.DataBean.DataListBean, BaseViewHolder> {
    //通栏商品大图片
    public static final int TYPE_IMG = 100;
    //通栏图文
    public static final int TYPE_TEXT_AND_IMG = 200;
    //通栏文本
    public static final int TYPE_TEXT = 300;
    //三列
    public static final int TYPE_THREE_COLUMN = 400;
    //通栏水平拖动
    public static final int TYPE_HORIZONTAL_SCROLL = 500;
    //通栏窄图片
    public static final int TYPE_NARROW_IMG = 600;
    //两列
    public static final int TYPE_TWO_COLUMN = 700;
    public HistoryAdapter() {
        super(null);
        finishInitialize();

    }

    @Override
    protected int getViewType(CategoryBean.DataBean.DataListBean testBean) {
  /*      int type = testBean.getType();
        if (type == 1) {
            return TYPE_IMG;
        } else if (type == 2) {
            return TYPE_TEXT_AND_IMG;
        } else if (type == 3) {
            return TYPE_TEXT;
        } else if (type == 4) {
            return TYPE_THREE_COLUMN;
        } else if (type == 5) {
            return TYPE_HORIZONTAL_SCROLL;
        } else if (type == 6) {
            return TYPE_NARROW_IMG;
        } else if (type == 7) {
            return TYPE_TWO_COLUMN;
        }
        return 0;*/
        return TYPE_THREE_COLUMN;
    }

    @Override
    public void registerItemProvider() {
        //通栏商品大图片
        mProviderDelegate.registerProvider(new ImgItemProvider());
        //通栏图文
        mProviderDelegate.registerProvider(new ImgAndTextItemProvider());
        //通栏文本
        mProviderDelegate.registerProvider(new TextItemProvider());
        //三列图文
        mProviderDelegate.registerProvider(new ThreeColumnItemProvider());
        //通栏横向滑动
        mProviderDelegate.registerProvider(new ScrollItemProvider());
        //通栏窄图片
        mProviderDelegate.registerProvider(new NarrowImgItemProvider());
        //两列图文
        mProviderDelegate.registerProvider(new TwoColumnItemProvider());
    }
}
