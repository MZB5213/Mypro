package com.dyth.mzb.my.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class CommentActivity extends BaseActivity {
    private TabLayout mCOMTab;
    private ViewPager mCOMPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_conmment;
    }

    @Override
    protected void initView() {
        mCOMTab = (TabLayout) findViewById(R.id.COM_Tab);
        mCOMPager = (ViewPager) findViewById(R.id.COM_pager);

        List<String> list = new ArrayList<>();
        list.add("资讯");
        list.add("话题");

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MyinfoFragment());
        fragmentList.add(new MyCONTopicFragment());

        mCOMPager.setAdapter(new InfoFragmentAdapter(getSupportFragmentManager(),fragmentList,list));
        mCOMTab.setupWithViewPager(mCOMPager);

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }

}
