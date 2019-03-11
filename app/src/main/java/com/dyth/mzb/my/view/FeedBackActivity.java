package com.dyth.mzb.my.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class FeedBackActivity extends BaseActivity {
    private Toolbar mFeedbackToolbar;
    private TabLayout mFeedbackTab;
    private ViewPager mFeedbackPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {
        mFeedbackToolbar = (Toolbar) findViewById(R.id.feedback_toolbar);
        mFeedbackTab = (TabLayout) findViewById(R.id.feedback_tab);
        mFeedbackPager = (ViewPager) findViewById(R.id.feedback_pager);
        mFeedbackToolbar.setLogo(R.mipmap.em_mm_title_back);

        List<String> list = new ArrayList<>();
        list.add("提交反馈");
        list.add("常见问题");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FeedBackoneFragment());
        fragmentList.add(new FeedBacktwoFragment());

        mFeedbackPager.setAdapter(new InfoFragmentAdapter(getSupportFragmentManager(),fragmentList,list));
        mFeedbackTab.setupWithViewPager(mFeedbackPager);

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_feedback);
        initView();
    }
}
