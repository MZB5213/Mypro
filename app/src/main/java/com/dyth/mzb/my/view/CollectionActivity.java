package com.dyth.mzb.my.view;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.CollectionListAdapter;
import com.dyth.mzb.alladapter.MyTopicCollectionAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.infomation.beans.Collection.Collection;
import com.dyth.mzb.infomation.contract.CollectionListContract;
import com.dyth.mzb.infomation.presenter.CollectionListPresenterImpl;
import com.dyth.mzb.my.base.topiccollection.TopicCollection;
import com.dyth.mzb.my.contact.MyTopicContract;
import com.dyth.mzb.my.presenter.MyTopicPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/4.
 */

public class CollectionActivity extends BaseActivity implements View.OnClickListener, CollectionListContract.INewsView, MyTopicContract.IMyTopicView {
    private ImageView mMySwitch;
    private ImageView mMySwitch2;
    private Toolbar mMToolbar;
    private ImageView mMyBack;
    /**
     * 取消
     */
    private TextView mMyCancel;
    /**
     * 删除(0)
     */
    private CollectionListPresenterImpl collectionListPresenter;
    private List<Collection.DataBean.FavouritNewsListBean> favouritNewsListBeans = new ArrayList<>();

    private CollectionListAdapter collectionListAdapter;
    private boolean flag = true;
    /**
     * 删除(0)
     */
    private TextView mMyDelete;
    private TextView mXian;
    private RecyclerView mMyRlv;
    private MyTopicPresenterImpl myTopicPresenter;
    private ArrayList<TopicCollection.DataBean.FavouritTopicListBean> favouritTopicLists = new ArrayList<>();
    private MyTopicCollectionAdapter myTopicCollectionAdapter;
    private List<Collection.DataBean.FavouritNewsListBean> newfavouritNewsList;
    private List<Collection.DataBean.FavouritNewsListBean> favouritNewsList;
    private AlertDialog alertDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mycollection;
    }

    @Override
    protected void initView() {
        mMySwitch = (ImageView) findViewById(R.id.my_switch);
        mMySwitch2 = (ImageView) findViewById(R.id.my_switch2);
        mMToolbar = (Toolbar) findViewById(R.id.mToolbar);
        mMyBack = (ImageView) findViewById(R.id.my_back);
        mMyCancel = (TextView) findViewById(R.id.my_cancel);
        mMyDelete = (TextView) findViewById(R.id.my_delete);
        mXian = (TextView) findViewById(R.id.xian);

        mMyBack.setOnClickListener(this);
        mMyCancel.setOnClickListener(this);
        mMySwitch.setOnClickListener(this);
        mMySwitch2.setOnClickListener(this);
        mMyDelete.setOnClickListener(this);
        mMyRlv = (RecyclerView) findViewById(R.id.my_rlv);
        mXian.setOnClickListener(this);

        mMyRlv.setLayoutManager(new LinearLayoutManager(this));
        mMyRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        collectionListAdapter = new CollectionListAdapter(favouritNewsListBeans,this);
        myTopicCollectionAdapter = new MyTopicCollectionAdapter(favouritTopicLists, this);
        mMyRlv.setAdapter(collectionListAdapter);

        newfavouritNewsList = collectionListAdapter.newfavouritNewsList;

        alertDialog = new AlertDialog.Builder(this)
                .setTitle("确定要删除吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < newfavouritNewsList.size(); i++) {
                            String title = newfavouritNewsList.get(i).getTitle().toString();
                            Log.e("-=-=--=--",title);
                        }
                        favouritNewsListBeans.removeAll(newfavouritNewsList);
                        collectionListAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                }).create();

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        collectionListPresenter = new CollectionListPresenterImpl(this);
        collectionListPresenter.getCollection();
        myTopicPresenter = new MyTopicPresenterImpl(this);
        myTopicPresenter.getMyTopic();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.my_back:
                finish();
                break;
            case R.id.my_cancel:
                if (flag) {
                    mMyCancel.setText("取消");
                    for (int i = 0; i < favouritNewsListBeans.size(); i++) {
                        favouritNewsListBeans.get(i).setIschead(false);
                        collectionListAdapter.notifyDataSetChanged();
                    }
                    collectionListAdapter.setOnItemClickListener(new CollectionListAdapter.OnItemClick() {
                        @Override
                        public void OnClick(View v, int position) {

                        }
                    });
                    mXian.setVisibility(View.VISIBLE);
                    mMyDelete.setVisibility(View.VISIBLE);
                    flag = false;
                } else {
                    mMyCancel.setText("编辑");
                    for (int i = 0; i < favouritNewsListBeans.size(); i++) {
                        favouritNewsListBeans.get(i).setIschead(true);
                        collectionListAdapter.notifyDataSetChanged();
                    }
                    mXian.setVisibility(View.GONE);
                    mMyDelete.setVisibility(View.GONE);
                    flag = true;
                }
                break;
            case R.id.my_switch:
                mMySwitch.setVisibility(View.GONE);
                mMySwitch2.setVisibility(View.VISIBLE);
                mMyRlv.setAdapter(myTopicCollectionAdapter);
                break;
            case R.id.my_switch2:
                mMySwitch2.setVisibility(View.GONE);
                mMySwitch.setVisibility(View.VISIBLE);
                mMyRlv.setAdapter(collectionListAdapter);
                break;
            case R.id.my_delete:
                mMyDelete.setText("删除（"+newfavouritNewsList.size()+"）");
                alertDialog.show();
                break;
        }
    }


    @Override
    public void getDataCollection(Object o) {
        final Collection collection = (Collection) o;
        favouritNewsList = collection.getData().getFavouritNewsList();
        if(collection.getMessage().equals("成功")){
            favouritNewsListBeans.addAll(favouritNewsList);
            collectionListAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getMyTopicData(Object o) {
        TopicCollection topicCollection = (TopicCollection) o;
        if (topicCollection.getMessage().equals("成功")){
            List<TopicCollection.DataBean.FavouritTopicListBean> favouritTopicList = topicCollection.getData().getFavouritTopicList();
            favouritTopicLists.addAll(favouritTopicList);
            myTopicCollectionAdapter.notifyDataSetChanged();
        }
    }
}
