package com.glut.shop.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.glut.shop.widget.ChildAutoHeightViewPager;

public class ViewBundle implements Parcelable {

    ChildAutoHeightViewPager viewPager;

    public ViewBundle() {
        super();
    }

    public ViewBundle(ChildAutoHeightViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public ChildAutoHeightViewPager getViewPager() {
        return viewPager;
    }

    public void setViewPager(ChildAutoHeightViewPager viewPager) {
        this.viewPager = viewPager;
    }

    protected ViewBundle(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ViewBundle> CREATOR = new Creator<ViewBundle>() {
        @Override
        public ViewBundle createFromParcel(Parcel in) {
            return new ViewBundle(in);
        }

        @Override
        public ViewBundle[] newArray(int size) {
            return new ViewBundle[size];
        }
    };
}
