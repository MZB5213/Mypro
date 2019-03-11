package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoRlvAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.content.Message;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.presenter.InfoPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/12/26.
 */

@SuppressLint("ValidFragment")
public class ListFragment extends BaseFragment implements InfomationContract.INewsView {

    private  String newsId;
    private RecyclerView rlv;
    private InfoPresenterImpl infoPresenter;
    private InfoRlvAdapter infoRlvAdapter;
    private List<Message.DataBean.NewListBean> newListBeans = new ArrayList<>();

    public ListFragment(String channelId) {
        this.newsId = channelId;
    }

    @Override
    protected void getData() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            infoPresenter = new InfoPresenterImpl(this);
            infoPresenter.getList(newsId);
        }
    }

    @Override
    protected void getpresenter() {



    }

    @Override
    protected void initView() {



    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.list_fragment, null, false);
        rlv = inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        infoRlvAdapter = new InfoRlvAdapter(newListBeans, getActivity());
        return inflate;
    }

    @Override
    public void getData(Object o) {
        Message message = (Message) o;
        final List<Message.DataBean.NewListBean> newList = message.getData().getNewList();
        newListBeans.addAll(newList);
        rlv.setAdapter(infoRlvAdapter);
        infoRlvAdapter.notifyDataSetChanged();
        infoRlvAdapter.setOnItemCLick(new InfoRlvAdapter.OnClick() {
            @Override
            public void OnItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("newsId",newList.get(position).getNewsId());
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(View v, int position) {

            }
        });
    }
}
