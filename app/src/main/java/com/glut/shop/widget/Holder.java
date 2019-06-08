package com.glut.shop.widget;

import android.content.Context;
import android.view.View;

public interface Holder<T> {
    //创建视图View
    View createView(Context context);
    //更新UI
    void UpdateUI(Context context, int position, T data);
}
