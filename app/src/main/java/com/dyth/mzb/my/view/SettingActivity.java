package com.dyth.mzb.my.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.utils.DataCleanManager;

import java.io.File;

/**
 * Created by Lenovo on 2019/1/10.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar mToolbar;
    private ImageView mGo1;
    private ImageView mGo2;
    private ImageView mGo3;
    private ImageView mGo4;
    private ImageView mGo5;
    private ImageView mSettingBack;
    private Switch mSettingClear;
    private TextView mCacheSize;
    private String totalCacheSize;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mGo1 = (ImageView) findViewById(R.id.Go_1);
        mGo2 = (ImageView) findViewById(R.id.Go_2);
        mGo3 = (ImageView) findViewById(R.id.Go_3);
        mGo4 = (ImageView) findViewById(R.id.Go_4);
        mGo5 = (ImageView) findViewById(R.id.Go_5);
        mSettingBack = (ImageView) findViewById(R.id.setting_back);
        mSettingClear = (Switch) findViewById(R.id.setting_clear);
        mCacheSize = findViewById(R.id.setting_cachesize);

        mGo1.setOnClickListener(this);
        mGo2.setOnClickListener(this);
        mGo3.setOnClickListener(this);
        mGo4.setOnClickListener(this);
        mGo5.setOnClickListener(this);
        mSettingBack.setOnClickListener(this);


        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(this);
            Log.e("----MainActivity----",DataCleanManager.getTotalCacheSize(this));
            mCacheSize.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.setting_back:
                finish();
                break;
            case R.id.Go_1:

                break;
            case R.id.Go_2:
                DataCleanManager.clearAllCache(SettingActivity.this);
                try {
                    mCacheSize.setText(DataCleanManager.getTotalCacheSize(SettingActivity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.Go_3:

                break;
            case R.id.Go_4:

                break;
            case R.id.Go_5:
                    startActivity(new Intent(SettingActivity.this,AboutUsFragment.class));
                break;
        }
    }
}
