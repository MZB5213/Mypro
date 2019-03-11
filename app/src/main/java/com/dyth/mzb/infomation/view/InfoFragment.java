package com.dyth.mzb.infomation.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.content.MessageTabs;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.presenter.InfoPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class InfoFragment extends BaseFragment implements InfomationContract.INewsView {


    private ViewPager view_pager;
    private InfoPresenterImpl infoPresenter;
    private TabLayout mtab;
    private ImageView search;
    private TextView info_channel;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        infoPresenter = new InfoPresenterImpl(this);
        infoPresenter.getTabs();
    }

    @Override
    protected void initView() {


    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.info_fragment, null, false);
        mtab = inflate.findViewById(R.id.mtab);
        info_channel = inflate.findViewById(R.id.info_channel);
        view_pager = inflate.findViewById(R.id.view_pager);
        search = inflate.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SearchActivity.class));
            }
        });

        info_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ChannelActivity.class));
            }
        });

        return inflate;
    }

    @Override
    public void getData(Object o) {
        MessageTabs messageTabs = (MessageTabs) o;
        List<MessageTabs.DataBean.NewsChannelListBean> newsChannelList = messageTabs.getData().getNewsChannelList();
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> tabs = new ArrayList<>();
        for (int i = 0; i < newsChannelList.size(); i++) {
            //mtab.addTab(mtab.newTab().setText(newsChannelList.get(i).getChannelName()));
            tabs.add(newsChannelList.get(i).getChannelName());
            fragmentList.add(new ListFragment(newsChannelList.get(i).getChannelId()));
        }

        view_pager.setAdapter(new InfoFragmentAdapter(getChildFragmentManager(),fragmentList,tabs));
        mtab.setupWithViewPager(view_pager);

    }
}
