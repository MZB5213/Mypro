package com.dyth.mzb.topic.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class TopicFragment extends BaseFragment {
    private View view;
    private TabLayout mTopicTab;
    private EditText mTopicEditor;
    private ViewPager mTopicVp;

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
        view = LayoutInflater.from(getActivity()).inflate(R.layout.topic_fragment, null, false);
        mTopicTab = (TabLayout) view.findViewById(R.id.topic_tab);
        mTopicEditor = (EditText) view.findViewById(R.id.topic_editor);
        mTopicVp = (ViewPager) view.findViewById(R.id.topic_vp);

        List<String> list = new ArrayList<>();
        list.add("话题");
        list.add("精选");
        list.add("分类");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ATopicFragment());
        fragmentList.add(new BSelectFragment());
        fragmentList.add(new CategoryFragment());

        mTopicVp.setAdapter(new InfoFragmentAdapter(getChildFragmentManager(),fragmentList,list));
        mTopicTab.setupWithViewPager(mTopicVp);

        return view;
    }


}
