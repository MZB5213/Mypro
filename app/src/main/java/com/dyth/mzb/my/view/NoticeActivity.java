package com.dyth.mzb.my.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.BaseFragmentAdapter;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class NoticeActivity extends BaseActivity {
    private ImageView mNoticeBack;
    private TabLayout mNoticeTab;
    private ViewPager mNoticeVp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    protected void initView() {
        mNoticeBack = (ImageView) findViewById(R.id.notice_back);
        mNoticeTab = (TabLayout) findViewById(R.id.notice_tab);
        mNoticeVp = (ViewPager) findViewById(R.id.notice_vp);
        mNoticeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        List<String> stringList = new ArrayList<>();
        stringList.add("通知");
        stringList.add("评论我");
        stringList.add("关注我");
        stringList.add("点赞我");


        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new NoticFragment());
        fragmentList.add(new CommentsFragment());
        fragmentList.add(new FocusFragment());
        fragmentList.add(new GiveLikeFragment());


        mNoticeVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mNoticeTab));

        mNoticeVp.setAdapter(new InfoFragmentAdapter(getSupportFragmentManager(),fragmentList,stringList));

        mNoticeTab.setupWithViewPager(mNoticeVp);

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }


}
