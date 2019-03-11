package com.dyth.mzb.my.view;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.FeedBackAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.my.base.feedback.MyFeedBack;
import com.dyth.mzb.my.contact.FeedBackContract;
import com.dyth.mzb.my.presenter.FeedBackPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class FeedBacktwoFragment extends BaseFragment implements FeedBackContract.FeedBackView {

    private RecyclerView rlv;
    private FeedBackPresenterImpl feedBackPresenter;
    private List<MyFeedBack.DataBean> dataBeans = new ArrayList<>();
    private FeedBackAdapter feedBackAdapter;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        feedBackPresenter = new FeedBackPresenterImpl(this);
        feedBackPresenter.getFeedBack();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.snews_fragment, null, false);
        rlv = inflate.findViewById(R.id.rlv);
        feedBackAdapter = new FeedBackAdapter(dataBeans, getContext());
        rlv.setAdapter(feedBackAdapter);
        rlv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        rlv.setLayoutManager(gridLayoutManager);
        return inflate;
    }

    @Override
    public void getFeedBackData(Object o) {
        MyFeedBack myFeedBack = (MyFeedBack) o;
        if(myFeedBack.getMessage().equals("成功")){
            dataBeans.addAll(myFeedBack.getData());
            feedBackAdapter.notifyDataSetChanged();
        }

    }
}
