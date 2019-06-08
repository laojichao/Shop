package com.glut.shop.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        // wrap_content
        int width = 0;
        int height = 0;

        // 记录每一行的宽度与高度
        int lineWidth = 0;
        int lineHeight = 0;

        // 得到内部元素的个数
        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);

            //测量子View的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //得到LayoutParams
            MarginLayoutParams layoutParams = (MarginLayoutParams)child.getLayoutParams();

            //子View占据的宽度
            int childWidth = child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            //子View占据的高度
            int childHeight = child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;

            //换行
            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()) {
                //对比得到最大的宽度
                width = Math.max(width, lineWidth);
                //重置lineWidth
                lineWidth = childWidth;
                //记录行高
                height += lineHeight;
                lineHeight = childHeight;
            } else {
                //未换行
                //叠加行宽
                lineWidth += childWidth;
                //得到当前行最大的高度
                lineHeight = Math.max(lineHeight, childHeight);
            }
            //最后一个控件
            if (i == cCount - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }

        setMeasuredDimension(
                modeWidth == MeasureSpec.EXACTLY ? sizeWidth : width + getPaddingLeft() + getPaddingRight(),
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight : height + getPaddingTop() + getPaddingBottom()
        );

    }

    /**
     * 存储所有的View
     */
    private List<List<View>> mAllViews = new ArrayList<>();
    /**
     * 每一行的高度
     */
    private List<Integer> mLineHeight = new ArrayList<>();

    @SuppressLint("DrawAllocation")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViews.clear();
        mLineHeight.clear();

        //当前ViewGroup的高度
        int width = getWidth();

        int lineWidth = 0;
        int lineHeight = 0;

        List<View> lineViews = new ArrayList<>();

        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams layoutParams = (MarginLayoutParams)child.getLayoutParams();

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            //如果需要换行
            if (childWidth + lineWidth + layoutParams.leftMargin + layoutParams.rightMargin >
                    width - getPaddingLeft() - getPaddingRight()) {
                //记录LineHeight
                mLineHeight.add(lineHeight);
                //记录当前行的Views
                mAllViews.add(lineViews);

                //重置行宽和行高
                lineWidth = 0;
                lineHeight = childHeight + layoutParams.topMargin + layoutParams.bottomMargin;
                //重置View集合
                lineViews = new ArrayList<>();
            }
            lineWidth += childWidth + layoutParams.leftMargin + layoutParams.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + layoutParams.topMargin + layoutParams.bottomMargin);
            lineViews.add(child);
        }
        //处理最后一行
        mLineHeight.add(lineHeight);
        mAllViews.add(lineViews);

        //设置子View的位置
        int left = getPaddingLeft();
        int top = getPaddingTop();

        //行数
        int lineNum = mAllViews.size();

        for (int i = 0; i < lineNum; i++) {
            //当前行的所有的View
            lineViews = mAllViews.get(i);
            lineHeight = mLineHeight.get(i);

            for (int j = 0; j < lineViews.size(); j++) {
                View child = lineViews.get(j);
                //判断child的状态
                if (child.getVisibility() == View.GONE) {
                    continue;
                }

                MarginLayoutParams layoutParams = (MarginLayoutParams)child.getLayoutParams();

                int lc = left + layoutParams.leftMargin;
                int tc = top + layoutParams.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                //为子View进行布局
                child.layout(lc, tc, rc, bc);

                left += child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            }
            left = getPaddingLeft();
            top += lineHeight;
        }
    }

    /**
     * 与当前ViewGroup对应的LayoutParams
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

}
