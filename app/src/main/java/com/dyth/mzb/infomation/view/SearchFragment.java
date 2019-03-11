package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.MyListAdapter;
import com.dyth.mzb.alladapter.MySearchAdapter;
import com.dyth.mzb.alladapter.MydbListAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.beans.newssearch.HotNewssearch;
import com.dyth.mzb.infomation.beans.newssearch.Newssearch;
import com.dyth.mzb.infomation.contract.HotTheLabelContract;
import com.dyth.mzb.infomation.presenter.HotTheLablePresenterImpl;
import com.dyth.mzb.mydb.MySQL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/2.
 */

@SuppressLint("ValidFragment")
public class SearchFragment extends BaseFragment implements HotTheLabelContract.IHotTheLabelView, View.OnClickListener {
    private final String test;
    private RecyclerView pop2_rlv;
    private MySearchAdapter mySearchAdapter;
    private List<Newssearch.DataBean.NewListBean> newListBeanList = new ArrayList<>();
    private List<HotNewssearch.DataBean.SearchListBean> searchListBeans = new ArrayList<>();
    private TextView history_clear;
    private TextView history_searh;
    private RecyclerView list_rlv;
    private RecyclerView rlv;
    private MyListAdapter myListAdapter;
    private List<String> stringList  = new ArrayList<>();;
    private MydbListAdapter mydbListAdapter;
    private MySQL mySQL;
    private SQLiteDatabase readableDatabase;
    private List<String> list;

    public SearchFragment(String string) {
        this.test = string;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        HotTheLablePresenterImpl hotTheLablePresenter = new HotTheLablePresenterImpl(this);
        hotTheLablePresenter.getHotTheLable();

    }

    @Override
    protected void initView() {


        mySQL = new MySQL(getActivity(), "my.db", null, 1);
        readableDatabase = mySQL.getReadableDatabase();
        Cursor demo = readableDatabase.query("demo", null, null, null, null, null, null);
        list = new ArrayList<>();
        while (demo.moveToNext()){
            String string = demo.getString(1);
            Log.e("-=-==-=-=--=-=---=-=",string);
            list.add(string);
            stringList.addAll(list);
        }
//        String s = stringList.get(0);
  //      Log.e("string",s);
        // mydbListAdapter.notifyDataSetChanged();

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.search_fragment, null, false);
        history_clear = inflate.findViewById(R.id.history_clear);
        history_searh = inflate.findViewById(R.id.history_search);
        list_rlv = inflate.findViewById(R.id.list_rlv);
        rlv = inflate.findViewById(R.id.rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        list_rlv.setLayoutManager(linearLayoutManager);
        mydbListAdapter = new MydbListAdapter(stringList, getActivity());
        list_rlv.setAdapter(mydbListAdapter);

        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myListAdapter = new MyListAdapter(searchListBeans, getActivity());
        rlv.setAdapter(myListAdapter);
        history_searh.setOnClickListener(this);
        history_clear.setOnClickListener(this);

        return inflate;
    }

    @Override
    public void getHotTheLabelData(Object o) {
        HotNewssearch hotNewssearch = (HotNewssearch) o;
        searchListBeans.addAll(hotNewssearch.getData().getSearchList());
        myListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.history_search:
                Log.e("11111111111111","-=-=-=-===-=-=");
                stringList.addAll(list);
                mydbListAdapter.notifyDataSetChanged();
                break;
            case R.id.history_clear:
                Log.e("2222222222","-=-=-=-===-=-=");
                readableDatabase.delete("demo",null,null);
                stringList.clear();
                mydbListAdapter.notifyDataSetChanged();
               // mySQL.close();
                break;
        }
    }
}
