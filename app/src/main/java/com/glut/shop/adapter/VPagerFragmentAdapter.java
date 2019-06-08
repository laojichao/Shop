package com.glut.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public VPagerFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragments = list;
    }

    @Override
    public Fragment getItem(int args0) {
        return fragments.get(args0);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public void addFragment(Fragment fragment) {
        this.fragments.add(fragment);
    }

    //刷新数据
    public void reflashData(List<Fragment> list) {
        this.fragments = list;
        this.notifyDataSetChanged();
    }

}
