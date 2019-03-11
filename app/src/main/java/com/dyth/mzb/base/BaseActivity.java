package com.dyth.mzb.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dyth.mzb.MyAppliction;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.analytics.MobclickAgent;

import static com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.mContext;

/**
 * Created by Lenovo on 2018/12/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        getLayoutId();
        initView();
        getpresenter();
        getData();
//        RefWatcher refWatcher = MyAppliction.getRefWatcher(this);
//        refWatcher.watch(this);
    }
    public void onResume() {
        super.onResume();
        Log.e("123456","456789");
        MobclickAgent.onPageStart("BaseActivity"); //手动统计页面("SplashScreen"为页面名称，可自定义)
        MobclickAgent.onResume(this); //统计时长
    }

    public void onPause() {
        super.onPause();
        Log.e("ABCDEF","GHIJKL");
        MobclickAgent.onPageEnd("BaseActivity"); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。
        MobclickAgent.onPause(this);
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void getData();
    protected abstract void getpresenter();

}
