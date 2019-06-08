package com.glut.shop.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * 是否可以手动滚动ViewPager
 */
public class GeneralViewPager extends ViewPager {

    private ViewGroup parent;
    private boolean isCanScroll = true;
    private float oldX = 0, oldY = 0;

    public GeneralViewPager(Context context) {
        super(context);
    }

    public GeneralViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //父控件赋值
    public void setViewPagerParent(ViewGroup parent) {
        this.parent = parent;
    }

    public boolean isCanScroll() {
        return isCanScroll;
    }

    public void setCanScroll(boolean canScroll) {
        isCanScroll = canScroll;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return isCanScroll && super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return isCanScroll && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (parent != null) {
            if (isCanScroll) {
                //请求不被拦截触摸事件
                parent.requestDisallowInterceptTouchEvent(true);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        oldX = event.getX();
                        oldY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float newX = event.getX();
                        float newY = event.getY();

                        float distanceX = newX - oldX;
                        float distanceY = newY - oldY;
                        if (Math.abs(distanceX) * 3 < Math.abs(distanceY)) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_OUTSIDE:
                        oldX = 0;
                        oldY = 0;
                        break;
                }
                return super.onTouchEvent(event);
            } else {
                return false;
            }
        } else {
            return super.onTouchEvent(event);
        }
    }

}
