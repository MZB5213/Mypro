package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.MyTopicSearchAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.topicsearch.TopicSearch;
import com.dyth.mzb.infomation.contract.TopicSearchContract;
import com.dyth.mzb.infomation.presenter.TopicSearchPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/2.
 */

@SuppressLint("ValidFragment")
public class StopicFragment extends BaseFragment implements TopicSearchContract.ITopicSearchView {

    private final String test;
    private RecyclerView rlv;
    private List<TopicSearch.DataBean.TopicListBean> topicListBeans = new ArrayList<>();
    private MyTopicSearchAdapter myTopicSearchAdapter;

    public StopicFragment(String test) {
        this.test = test;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        TopicSearchPresenterImpl topicSearchPresenter = new TopicSearchPresenterImpl(this);
        topicSearchPresenter.getTopicSearchData(test);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.stopic_fragment, null, false);
        rlv = inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myTopicSearchAdapter = new MyTopicSearchAdapter(topicListBeans, getActivity());
        rlv.setAdapter(myTopicSearchAdapter);
        return inflate;
    }

    @Override
    public void getData(Object o) {
        TopicSearch topicSearch = (TopicSearch) o;
        if(topicSearch.getMessage().equals("成功")){
            topicListBeans.addAll(topicSearch.getData().getTopicList());
            myTopicSearchAdapter.notifyDataSetChanged();
        }
    }
}
