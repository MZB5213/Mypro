package com.dyth.mzb.alladapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class InfoFragmentAdapter extends FragmentPagerAdapter {

    private  List<Fragment> fragments;
    private  List<String> tabs;

    public InfoFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabs) {
        super(fm);
        this.fragments = fragmentList;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
