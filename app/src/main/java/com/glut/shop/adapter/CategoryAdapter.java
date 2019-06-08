package com.glut.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.glut.shop.R;
import com.glut.shop.activity.CartActivity;
import com.glut.shop.util.ToastUtils;

import java.util.List;

public class CategoryAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List<String> list;
    private int selectItem = 0;

    public CategoryAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.category, null);
            viewHolder.tv_name = (TextView)view.findViewById(R.id.tv_category_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }

        if (position == selectItem) {
            viewHolder.tv_name.setBackgroundColor(context.getResources().getColor(R.color.white));
            viewHolder.tv_name.setTextColor(context.getResources().getColor(R.color.orange));
        } else {
            viewHolder.tv_name.setBackgroundColor(context.getResources().getColor(R.color.white));
            viewHolder.tv_name.setTextColor(context.getResources().getColor(R.color.black));
        }
        viewHolder.tv_name.setText(list.get(position));
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtils.showToast(context, "点击位置" + position);
        Intent intent = new Intent(context, CartActivity.class);
        context.startActivity(intent);
    }

    private static class ViewHolder {
        private TextView tv_name;
    }

}
