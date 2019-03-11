package com.dyth.mzb.my.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.infomation.beans.content.MessageTabs;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.presenter.InfoPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class MoreFocusActivity extends BaseActivity implements InfomationContract.INewsView {

    private InfoPresenterImpl infoPresenter;
    private MessageTabs messageTabs;
    private Toolbar mMoreToolbar;
    /**
     * 搜索
     */
    private TextView mMoreFocus;
    private ViewPager mMoreVp;
    private VerticalTabLayout mMoreTab;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_morefocus;
    }

    @Override
    protected void initView() {
        mMoreToolbar = (Toolbar) findViewById(R.id.more_toolbar);
        mMoreFocus = (TextView) findViewById(R.id.more_focus);
        mMoreTab = (VerticalTabLayout) findViewById(R.id.more_tab);
        mMoreVp = (ViewPager) findViewById(R.id.more_vp);

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        infoPresenter = new InfoPresenterImpl(this);
        infoPresenter.getTabs();
    }

    @Override
    public void getData(Object o) {
        messageTabs = (MessageTabs) o;
        List<MessageTabs.DataBean.NewsChannelListBean> newsChannelList = messageTabs.getData().getNewsChannelList();
        List<String> list = new ArrayList<>();
        list.add("推荐");
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < newsChannelList.size(); i++) {
            list.add(newsChannelList.get(i).getChannelName());
            fragmentList.add(new MoreFocusFragment(newsChannelList.get(i).getChannelId()));
        }

        mMoreVp.setAdapter(new InfoFragmentAdapter(getSupportFragmentManager(), fragmentList, list));
        mMoreTab.setupWithViewPager(mMoreVp);

    }


}
