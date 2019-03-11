package com.dyth.mzb.my.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.MyFocusAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.my.base.canclefocus.CancleFocus;
import com.dyth.mzb.my.base.focus.MyFocus;
import com.dyth.mzb.my.contact.CancleFocusContract;
import com.dyth.mzb.my.contact.MyFocusContract;
import com.dyth.mzb.my.presenter.CancleFocusPresenterImpl;
import com.dyth.mzb.my.presenter.MyFocusPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class FocusActivity extends BaseActivity implements View.OnClickListener, MyFocusContract.IMyFocusView, CancleFocusContract.ICancleFocusView {
    /**
     * 编辑
     */
    private TextView mFocusEditor;
    private ImageView mFocusBack;
    /**
     * +关注更多通航号
     */
    private TextView mFoucsInsert;
    private RecyclerView mFoucsList;
    private MyFocusPresenterImpl myFocusPresenter;
    private List<MyFocus.DataBean.FollowListBean> followListBeans = new ArrayList<>();
    private MyFocusAdapter myFocusAdapter;
    private AlertDialog alertDialog;
    private CancleFocusPresenterImpl cancleFocusPresenter;
    private MyFocus myFocus;
    private int position1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_focus;
    }

    @Override
    protected void initView() {
        mFocusEditor = (TextView) findViewById(R.id.focus_editor);
        mFocusBack = (ImageView) findViewById(R.id.focus_back);
        mFoucsInsert = (TextView) findViewById(R.id.foucs_insert);
        mFoucsList = (RecyclerView) findViewById(R.id.foucs_list);
        mFocusBack.setOnClickListener(this);
        mFoucsInsert.setOnClickListener(this);
        mFocusEditor.setOnClickListener(this);

        mFoucsList.setLayoutManager(new LinearLayoutManager(this));
        mFoucsList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        myFocusAdapter = new MyFocusAdapter(followListBeans, this);
        mFoucsList.setAdapter(myFocusAdapter);

        alertDialog = new AlertDialog.Builder(this)
                .setTitle("确定取消关注吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        List<String> strings = new ArrayList<>();
                        List<MyFocus.DataBean.FollowListBean> followList = myFocus.getData().getFollowList();
                        String followId = followList.get(position1).getFollowId();
                        Log.e("-=-=-=-=-=-=-=-=",followId);
                        strings.add(followId);
                        cancleFocusPresenter.getData(strings);
                        myFocusAdapter.notifyDataSetChanged();
                        strings.clear();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        myFocusAdapter.setOnItemClickListener(new MyFocusAdapter.ItemClick() {



            @Override
            public void ItemClick(View v, int position) {
                position1 = position;
                alertDialog.show();
            }
        });

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        myFocusPresenter = new MyFocusPresenterImpl(this);
        myFocusPresenter.getMyFocus();
        cancleFocusPresenter = new CancleFocusPresenterImpl(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.focus_back:
                finish();
                break;
            case R.id.focus_editor:

                break;
            case R.id.foucs_insert:
                startActivity(new Intent(this,MoreFocusActivity.class));
                break;
        }
    }

    @Override
    public void getMyFocusData(Object o) {
        myFocus = (MyFocus) o;
        if(myFocus.getMessage().equals("成功")){
            List<MyFocus.DataBean.FollowListBean> followList = myFocus.getData().getFollowList();
            followListBeans.addAll(followList);
            myFocusAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getCancleData(Object o) {
        CancleFocus cancleFocus = (CancleFocus) o;
        Log.e("-----CANCLEFOCUS-----",cancleFocus.getMessage());
    }
}
