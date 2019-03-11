package com.dyth.mzb.my.view;

import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseFragment;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class CommentsFragment extends BaseFragment {
    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.topic_fragment,null,false);
    }
}
