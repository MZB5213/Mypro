package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.MySearchAdapter;
import com.dyth.mzb.alladapter.ThelabelAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.newssearch.Newssearch;
import com.dyth.mzb.infomation.contract.TheLabelContract;
import com.dyth.mzb.infomation.presenter.TheLabelPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/2.
 */

@SuppressLint("ValidFragment")
public class SnewsFragment extends BaseFragment implements TheLabelContract.ITheLabelView {

    private final String test;
    private RecyclerView rlv;
    private TheLabelPresenterImpl theLabelPresenter;
    private List<Newssearch.DataBean.NewListBean> newListBeans = new ArrayList<>();
    private MySearchAdapter mySearchAdapter;

    public SnewsFragment(String test) {
        this.test = test;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        theLabelPresenter = new TheLabelPresenterImpl(this);
        theLabelPresenter.getThelabel(test);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.snews_fragment, null, false);
        rlv = inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mySearchAdapter = new MySearchAdapter(newListBeans, getActivity());
        rlv.setAdapter(mySearchAdapter);
        return inflate;
    }

    @Override
    public void getTheLabelData(Object o) {
        Newssearch newssearch = (Newssearch) o;
        if(newssearch.getMessage().equals("成功")){
            newListBeans.addAll(newssearch.getData().getNewList());
            mySearchAdapter.notifyDataSetChanged();
        }
    }
}
