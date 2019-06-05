package com.glut.shop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.glut.shop.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

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

    private static class ViewHolder {
        private TextView tv_name;
    }

}
