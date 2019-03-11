package com.dyth.mzb.my.view;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.ConmmentAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.contract.CommentsListContract;
import com.dyth.mzb.infomation.presenter.CommentsListPresenterImpl;
import com.dyth.mzb.my.base.MyCOM.MyCOM;
import com.dyth.mzb.my.contact.MyCOMContract;
import com.dyth.mzb.my.presenter.MyCOMPresenterImpl;
import com.dyth.mzb.topic.bean.MyTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class MyCONTopicFragment extends BaseFragment implements MyCOMContract.IMyCOMView {

    private RecyclerView my_rlv;
    private MyCOMPresenterImpl myCOMPresenter;
    private List<MyCOM.DataBean.UserCommentListBean> userCommentListBeans = new ArrayList<>();
    private ConmmentAdapter conmmentAdapter;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        myCOMPresenter = new MyCOMPresenterImpl(this);
        myCOMPresenter.getCOM();


    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.my_switchfragment, null, false);
        my_rlv = inflate.findViewById(R.id.my_rlv);
        my_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        my_rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        conmmentAdapter = new ConmmentAdapter(userCommentListBeans, getActivity());
        my_rlv.setAdapter(conmmentAdapter);
        return inflate;
    }


    @Override
    public void getData(Object o) {
        MyCOM myCOM = (MyCOM) o;
        if(myCOM.getMessage().equals("成功")){
                userCommentListBeans.addAll(myCOM.getData().getUserCommentList());
                conmmentAdapter.notifyDataSetChanged();
        }

    }
}
