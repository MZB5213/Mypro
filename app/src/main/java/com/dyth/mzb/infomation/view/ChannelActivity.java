package com.dyth.mzb.infomation.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.infomation.beans.content.MessageTabs;
import com.dyth.mzb.infomation.beans.morechannel.MoreChannel;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.module.AddChannelContract;
import com.dyth.mzb.infomation.presenter.AddChannelPresenterImpl;
import com.dyth.mzb.infomation.presenter.InfoPresenterImpl;
import com.dyth.mzb.utils.channelmanger.DataBean;
import com.dyth.mzb.utils.channelmanger.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class ChannelActivity extends BaseActivity implements View.OnClickListener, InfomationContract.INewsView, AddChannelContract.IAddChannelView {
    private ImageView mChannerBj;
    private RecyclerView mDrag1;
    private RecyclerView mDrag2;
    private List<DataBean> list;
    private RecyclerView gridViewAdapter;
    private MyAdapter myAdapter;
    private ArrayList<DataBean> list2;
    private MyAdapter myAdapter2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_channel;
    }

    @Override
    protected void initView() {

        mChannerBj = (ImageView) findViewById(R.id.channer_bj);
        mChannerBj.setOnClickListener(this);
        mDrag1 = (RecyclerView) findViewById(R.id.drag1);
        mDrag2 = (RecyclerView) findViewById(R.id.drag2);
        mDrag1.setLayoutManager(new GridLayoutManager(this,4));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mDrag1.setAdapter(myAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new MyItemTouchCallBack(myAdapter));
        itemTouchHelper.attachToRecyclerView(mDrag1);

        mDrag2.setLayoutManager(new GridLayoutManager(this,4));
        list2 = new ArrayList<>();
        myAdapter2 = new MyAdapter(this, list2);
        mDrag2.setAdapter(myAdapter2);
        ItemTouchHelper itemTouchHelper1 = new ItemTouchHelper(new MyItemTouchCallBack(myAdapter2));
        itemTouchHelper1.attachToRecyclerView(mDrag2);


    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        InfoPresenterImpl infoPresenter = new InfoPresenterImpl(this);
        infoPresenter.getTabs();
        AddChannelPresenterImpl addChannelPresenter = new AddChannelPresenterImpl(this);
        addChannelPresenter.getChannel();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.channer_bj:
                Log.e("------bj------","AAAAAAAAAAAAAA");
                break;
        }
    }

    @Override
    public void getData(Object o) {
        MessageTabs messageTabs = (MessageTabs) o;
        for (int i = 0; i < messageTabs.getData().getNewsChannelList().size(); i++) {
            list.add(new DataBean(messageTabs.getData().getNewsChannelList().get(i).getChannelName(),0,""));
            myAdapter.notifyDataSetChanged();
        }


    }

    @Override
    public void getAddData(Object o) {
        MoreChannel moreChannel = (MoreChannel) o;
        for (int i = 0; i < moreChannel.getData().getProfessionList().size(); i++) {
            list2.add(new DataBean(moreChannel.getData().getProfessionList().get(i).getProfessionName(),0,""));
            myAdapter2.notifyDataSetChanged();
        }
    }
}
