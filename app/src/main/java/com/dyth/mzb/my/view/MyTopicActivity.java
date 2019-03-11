package com.dyth.mzb.my.view;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.MyTopicAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.my.base.topiccollection.Topic;
import com.dyth.mzb.my.contact.TopicContract;
import com.dyth.mzb.my.presenter.MyTopicPresenterImpl;
import com.dyth.mzb.my.presenter.TopicPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class MyTopicActivity extends BaseActivity implements TopicContract.ITopicView {
    private Toolbar mTopicToolbar;
    private ImageView mBack;
    private EditText mTopicEditor;
    private RecyclerView mTopicRlv;
    private TopicPresenterImpl topicPresenter;
    private List<Topic.DataBean.FavouritTopicListBean> favouritTopicListBeans = new ArrayList<>();
    private MyTopicAdapter myTopicAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.my_topic;
    }

    @Override
    protected void initView() {
        mTopicToolbar = (Toolbar) findViewById(R.id.topic_toolbar);
        mBack = (ImageView) findViewById(R.id.back);
        mTopicEditor = (EditText) findViewById(R.id.topic_editor);
        mTopicRlv = (RecyclerView) findViewById(R.id.topic_rlv);
        mTopicRlv.setLayoutManager(new LinearLayoutManager(this));
        mTopicRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        myTopicAdapter = new MyTopicAdapter(favouritTopicListBeans, this);
        mTopicRlv.setAdapter(myTopicAdapter);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void getData() {



        myTopicAdapter.setOnItemClickListener(new MyTopicAdapter.OnClick() {
            @Override
            public void ItemClick(View v, int position) {

            }
        });

    }

    @Override
    protected void getpresenter() {
        topicPresenter = new TopicPresenterImpl(this);
        topicPresenter.getTopicData();
    }

    @Override
    public void getData(Object o) {
        Topic topic = (Topic) o;
        if(topic.getMessage().equals("成功")){
            favouritTopicListBeans.addAll(topic.getData().getFavouritTopicList());
            myTopicAdapter.notifyDataSetChanged();
        }

    }
}
