package com.dyth.mzb.infomation.view;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.InfoFragmentAdapter;
import com.dyth.mzb.alladapter.MyListAdapter;
import com.dyth.mzb.alladapter.MySearchAdapter;
import com.dyth.mzb.alladapter.MydbListAdapter;
import com.dyth.mzb.alladapter.ThelabelAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.infomation.beans.newssearch.HotNewssearch;
import com.dyth.mzb.infomation.beans.newssearch.Newssearch;
import com.dyth.mzb.infomation.beans.thelabel.HotThelable;
import com.dyth.mzb.infomation.beans.thelabel.TheLableResponse;
import com.dyth.mzb.infomation.contract.HotTheLabelContract;
import com.dyth.mzb.infomation.contract.TheLabelContract;
import com.dyth.mzb.infomation.presenter.HotTheLablePresenterImpl;
import com.dyth.mzb.infomation.presenter.TheLabelPresenterImpl;
import com.dyth.mzb.mydb.MySQL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class SearchActivity extends BaseActivity implements TheLabelContract.ITheLabelView {


    private EditText ed;
    private TextView quxiao;
    private TheLabelPresenterImpl theLabelPresenter;
    private LinearLayout lay;
    private RecyclerView pop_rlv;
    private List<Newssearch.DataBean.NewListBean> newListBeans = new ArrayList<>();
    private ThelabelAdapter thelabelAdapter;
    private PopupWindow popupWindow;
    private String string;
    private ImageView search;

    @Override
    protected int getLayoutId() {
        return R.layout.search_activity;
    }

    @Override
    protected void initView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        final FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        final SearchFragment searchFragment = new SearchFragment(string);
        beginTransaction.add(R.id.fragment,searchFragment);
        beginTransaction.commit();
        lay = findViewById(R.id.lay);
        quxiao = findViewById(R.id.mquxiao);
        search = findViewById(R.id.search);
        ed = findViewById(R.id.ed);
        final View inflate = LayoutInflater.from(this).inflate(R.layout.search_pop, null, false);
        pop_rlv = inflate.findViewById(R.id.pop_rlv);
        pop_rlv.setLayoutManager(new LinearLayoutManager(this));
        thelabelAdapter = new ThelabelAdapter(newListBeans, this);
        pop_rlv.setAdapter(thelabelAdapter);
        popupWindow = new PopupWindow(inflate);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        ed.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString()!=null){
                    string = s.toString();
                    theLabelPresenter.getThelabel(string);
                    popupWindow.showAsDropDown(lay,0,0);
                    quxiao.setText("搜索");
                }else{
                    quxiao.setText("取消");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
//                Intent intent = new Intent(SearchActivity.this, SearchFragment.class);
//                intent.putExtra("text",s.toString());
//                startActivity(intent);

            }
        });

        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FragmentManager = getSupportFragmentManager();
                FragmentTransaction beginTransaction1 = FragmentManager.beginTransaction();
                beginTransaction1.replace(R.id.fragment,new NTFragment(string));
                beginTransaction1.commit();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQL mySQL = new MySQL(SearchActivity.this, "my.db", null, 1);
                SQLiteDatabase writableDatabase = mySQL.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("title",string);
                writableDatabase.insert("demo",null,contentValues);
                mySQL.close();
            }
        });


    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        theLabelPresenter = new TheLabelPresenterImpl(this);
    }

    @Override
    public void getTheLabelData(Object o) {
        Newssearch newssearch = (Newssearch) o;
        if(newssearch.getMessage().equals("成功")){
            newListBeans.addAll(newssearch.getData().getNewList());
            thelabelAdapter.notifyDataSetChanged();
        }else{
            popupWindow.dismiss();
            newListBeans.clear();
            thelabelAdapter.notifyDataSetChanged();
        }


    }
}
