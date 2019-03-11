package com.dyth.mzb.my.view;

import android.annotation.SuppressLint;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.MyTopicCollectionAdapter;
import com.dyth.mzb.alladapter.MyTopicSearchAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.my.base.topiccollection.TopicCollection;
import com.dyth.mzb.my.contact.MyTopicContract;
import com.dyth.mzb.my.presenter.MyTopicPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/4.
 */

@SuppressLint("ValidFragment")
public class MyTopicFragment extends BaseFragment implements MyTopicContract.IMyTopicView {

    private final boolean topicflag;
    private RecyclerView my_rlv;
    private MyTopicPresenterImpl myTopicPresenter;
    private List<TopicCollection.DataBean.FavouritTopicListBean> favouritTopicListBeans;
    private MyTopicCollectionAdapter myTopicCollectionAdapter;

    public MyTopicFragment(boolean flag) {
        this.topicflag = flag;
    }

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
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.my_switchfragment2, null, false);
        my_rlv = inflate.findViewById(R.id.my_rlv);
        my_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        my_rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        favouritTopicListBeans = new ArrayList<>();
        myTopicCollectionAdapter = new MyTopicCollectionAdapter(favouritTopicListBeans, getActivity());
        my_rlv.setAdapter(myTopicCollectionAdapter);
        myTopicCollectionAdapter.setData(topicflag);
        myTopicCollectionAdapter.setOnItemClickListener(new MyTopicCollectionAdapter.OnItemCick() {
            @Override
            public void OnClick(View v, int position) {

            }
        });
        return inflate;
    }

    @Override
    public void getMyTopicData(Object o) {
        TopicCollection topicCollection = (TopicCollection) o;
        if (topicCollection.getMessage().equals("成功")){
            List<TopicCollection.DataBean.FavouritTopicListBean> favouritTopicList = topicCollection.getData().getFavouritTopicList();
            favouritTopicListBeans.addAll(favouritTopicList);
            myTopicCollectionAdapter.notifyDataSetChanged();
        }

    }
}
