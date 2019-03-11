package com.dyth.mzb.topic.view;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.TopicAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.topic.bean.MyTopic;
import com.dyth.mzb.topic.contract.MyTopicContract;
import com.dyth.mzb.topic.module.MySelectModuleImpl;
import com.dyth.mzb.topic.presenter.MySelectPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/9.
 */

public class BSelectFragment extends BaseFragment implements MyTopicContract.IMyTopicView {

    private RecyclerView rlv;
    private MySelectPresenterImpl mySelectPresenter;
    private List<MyTopic.DataBean.TopicListBean> topicListBeans = new ArrayList<>();
    private TopicAdapter topicAdapter;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        mySelectPresenter = new MySelectPresenterImpl(this);
        mySelectPresenter.getMyTopic();

    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_fragment, null, false);
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        topicAdapter = new TopicAdapter(topicListBeans, getActivity());
        rlv.setAdapter(topicAdapter);
        return view;
    }

    @Override
    public void getMyTopicDta(Object o) {
        MyTopic myTopic = (MyTopic) o;
        if(myTopic.getMessage().equals("成功")){
            topicListBeans.addAll(myTopic.getData().getTopicList());
            topicAdapter.notifyDataSetChanged();
        }

    }
}
