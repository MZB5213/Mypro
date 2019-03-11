package com.dyth.mzb.my.view;

import android.annotation.SuppressLint;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.CollectionListAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.Collection.Collection;
import com.dyth.mzb.infomation.contract.CollectionListContract;
import com.dyth.mzb.infomation.presenter.CollectionListPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/4.
 */

@SuppressLint("ValidFragment")
public class MyNewsFragment extends BaseFragment implements CollectionListContract.INewsView {

    private final boolean newsflag;
    private RecyclerView my_rlv;
    private CollectionListAdapter collectionListAdapter;
    private List<Collection.DataBean.FavouritNewsListBean> favouritNewsListBeans;
    private CollectionListPresenterImpl collectionListPresenter;

    public MyNewsFragment(boolean flag) {
        this.newsflag = flag;
    }

    @Override
    protected void getData() {


    }

    @Override
    protected void getpresenter() {
        collectionListPresenter = new CollectionListPresenterImpl(this);
        collectionListPresenter.getCollection();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.my_switchfragment, null, false);
        my_rlv = inflate.findViewById(R.id.my_rlv);
        favouritNewsListBeans = new ArrayList<>();
        my_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        my_rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        collectionListAdapter = new CollectionListAdapter(favouritNewsListBeans, getActivity());
        collectionListAdapter.setData(newsflag);
        my_rlv.setAdapter(collectionListAdapter);
        collectionListAdapter.setOnItemClickListener(new CollectionListAdapter.OnItemClick() {
            @Override
            public void OnClick(View v, int position) {
                Log.e("-=-=-=-=-=-=---=-=","12-45-78-98");
            }
        });
        return inflate;
    }

    @Override
    public void getDataCollection(Object o) {
        final Collection collection = (Collection) o;
        final List<Collection.DataBean.FavouritNewsListBean> favouritNewsList = collection.getData().getFavouritNewsList();
        if(collection.getMessage().equals("成功")){
            favouritNewsListBeans.addAll(favouritNewsList);
            collectionListAdapter.notifyDataSetChanged();
        }
    }
}
