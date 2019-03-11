package com.dyth.mzb.my.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseFragment;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class FeedBackoneFragment extends BaseFragment {

    private RecyclerView rlv;

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
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.snews_fragment, null, false);
        rlv = inflate.findViewById(R.id.rlv);
        return inflate;
    }
}
