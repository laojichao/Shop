package com.glut.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null) {
            onScrollListener.onScrollchanged(l, t, oldl, oldt);
        }
    }

    /**
     * 由垂直方向滚动条代表的所有垂直范围，缺省的范围是当前视图的画图高度。
     */
    @Override
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public interface OnScrollListener {
        /**
         * @param t 当前View滑动的距离
         */
        void onScrollchanged(int l, int t, int oldl, int oldt);

        void onTouchUp();

        void onTouchDown();
    }

    public OnScrollListener onScrollListener;

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

}
