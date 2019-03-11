package com.dyth.mzb.topic.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.TopicAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.topic.bean.MyTopic;
import com.dyth.mzb.topic.contract.MyTopicContract;
import com.dyth.mzb.topic.presenter.MyTopicPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/9.
 */

public class ATopicFragment extends BaseFragment implements MyTopicContract.IMyTopicView {

    private View view;
    private RecyclerView mRlv;
    private MyTopicPresenterImpl myTopicPresenter;
    private List<MyTopic.DataBean.TopicListBean> topicListBeans = new ArrayList<>();
    private TopicAdapter topicAdapter;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        myTopicPresenter = new MyTopicPresenterImpl(this);
        myTopicPresenter.getMyTopic();
    }

    @Override
    protected void initView() {


    }

    @Override
    protected View getonCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_fragment, null, false);
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        topicAdapter = new TopicAdapter(topicListBeans, getActivity());
        mRlv.setAdapter(topicAdapter);
        return view;
    }

    @Override
    public void getMyTopicDta(Object o) {
        MyTopic myTopic = (MyTopic) o;
        if(myTopic.getMessage().equals("成功")){
            List<MyTopic.DataBean.TopicListBean> topicList = myTopic.getData().getTopicList();
            topicListBeans.addAll(topicList);
            topicAdapter.notifyDataSetChanged();
        }

    }
}
