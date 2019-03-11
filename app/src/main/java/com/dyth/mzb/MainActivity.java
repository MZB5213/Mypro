package com.dyth.mzb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dyth.mzb.alladapter.BaseFragmentAdapter;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.infomation.view.InfoFragment;
import com.dyth.mzb.my.view.MyFragment;
import com.dyth.mzb.topic.view.TopicFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioGroup navigation;
    private ViewPager view_pager;

    @Override
    protected int getLayoutId() {
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        navigation = findViewById(R.id.navigation);
        view_pager = findViewById(R.id.view_pager);
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        navigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        view_pager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        view_pager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        view_pager.setCurrentItem(2);
                        break;
                }
            }
        });

        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigation.check(R.id.rb1);
                        break;
                    case 1:
                        navigation.check(R.id.rb2);
                        break;
                    case 2:
                        navigation.check(R.id.rb3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        InfoFragment infoFragment = new InfoFragment();
        TopicFragment topicFragment = new TopicFragment();
        MyFragment myFragment = new MyFragment();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(infoFragment);
        fragmentList.add(topicFragment);
        fragmentList.add(myFragment);

        BaseFragmentAdapter baseFragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragmentList);
        view_pager.setAdapter(baseFragmentAdapter);




    }

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }



}
