package com.glut.shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.glut.shop.R;
import com.glut.shop.bean.CategoryBean;
import com.glut.shop.util.ToastUtils;

import java.util.List;

public class ProductSummaryAdapter extends BaseAdapter {

    private Context context;
    private List<CategoryBean.DataBean.DataListBean> datas;

    public ProductSummaryAdapter(Context context, List<CategoryBean.DataBean.DataListBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        if (datas != null) {
            return datas.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return datas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        CategoryBean.DataBean.DataListBean subcategory = datas.get(position);
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            view = View.inflate(context, R.layout.product_summary, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_name = (TextView)view.findViewById(R.id.tv_summary_name);
            viewHolder.iv_icon = (SimpleDraweeView)view.findViewById(R.id.sdview_product_summary);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.tv_name.setText(subcategory.getTitle());
        Uri uri = Uri.parse(subcategory.getImgURL());
        viewHolder.iv_icon.setImageURI(uri);
        return view;
    }

    private static class ViewHolder {
        private TextView tv_name;
        private SimpleDraweeView iv_icon;
    }



}
