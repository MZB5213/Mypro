package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.alladapter.MySearchAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.newssearch.Newssearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/2.
 */

@SuppressLint("ValidFragment")
public class NTFragment extends BaseFragment {

    private final String test;
    private RecyclerView pop2_rlv;
    private MySearchAdapter mySearchAdapter;
    private List<Newssearch.DataBean.NewListBean> newListBeanList = new ArrayList<>();
    private TabLayout mTab;
    private ViewPager mvp;

    public NTFragment(String string) {
        this.test = string;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }

    @Override
    protected void initView() {


    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.topic2_fragment, null, false);
        mTab = inflate.findViewById(R.id.mTab);
        mvp = inflate.findViewById(R.id.mvp);
        List<String> StringList = new ArrayList<>();
        StringList.add("新闻");
        StringList.add("话题");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new SnewsFragment(test));
        fragmentList.add(new StopicFragment(test));
        mvp.setAdapter(new InfoFragmentAdapter(getChildFragmentManager(),fragmentList,StringList));
        mTab.setupWithViewPager(mvp);
        return inflate;
    }
}
