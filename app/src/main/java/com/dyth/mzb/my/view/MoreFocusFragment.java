package com.dyth.mzb.my.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.presenter.InfoPresenterImpl;
import com.dyth.mzb.my.base.morefocus.MoreFocus;
import com.dyth.mzb.my.contact.MoreFocusContract;
import com.dyth.mzb.my.presenter.MoreFocusPresenterImpl;

/**
 * Created by Lenovo on 2019/1/8.
 */

@SuppressLint("ValidFragment")
public class MoreFocusFragment extends BaseFragment implements MoreFocusContract.IMoreFocusView {
    private final String tabString;
    private RecyclerView mMoreFocusRlv;
    private View inflate;
    private MoreFocusPresenterImpl moreFocusPresenter;

    public MoreFocusFragment(String channelId) {
        this.tabString = channelId;

    }

    @Override
    protected void getData() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getpresenter();
        }
    }

    @Override
    protected void getpresenter() {
        moreFocusPresenter = new MoreFocusPresenterImpl(this);
        moreFocusPresenter.getMoreFocus("049de01db14a4c8184faa0aca7facf8a",tabString);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.more_focus_fragment, null, false);
        mMoreFocusRlv = (RecyclerView) inflate.findViewById(R.id.more_focus_rlv);
        return inflate;
    }


    @Override
    public void getData(Object o) {

    }
}
