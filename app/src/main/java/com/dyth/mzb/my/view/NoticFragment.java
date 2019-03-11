package com.dyth.mzb.my.view;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dyth.mzb.R;
import com.dyth.mzb.alladapter.NotifationoneAdapter;
import com.dyth.mzb.base.BaseFragment;
import com.dyth.mzb.my.base.notification.Notifation;
import com.dyth.mzb.my.contact.MyCOMContract;
import com.dyth.mzb.my.contact.MyNotifationContract;
import com.dyth.mzb.my.presenter.NotifationPresenterImpl;
import com.umeng.commonsdk.debug.D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class NoticFragment extends BaseFragment implements MyCOMContract.IMyCOMView, MyNotifationContract.IMyNotifationView {

    private NotifationPresenterImpl notifationPresenter;
    private RecyclerView no_rlv;
    private List<Notifation.DataBean> dataBeanList;
    private NotifationoneAdapter notifationoneAdapter;

    @Override
    protected void getData() {

    }

    @Override
    protected void getpresenter() {
        notifationPresenter = new NotifationPresenterImpl(this);
        notifationPresenter.getNotifationData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getonCreateView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.snews_fragment, null, false);
        no_rlv = inflate.findViewById(R.id.rlv);
        no_rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        no_rlv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        dataBeanList = new ArrayList<>();
        notifationoneAdapter = new NotifationoneAdapter(dataBeanList, getContext());
        no_rlv.setAdapter(notifationoneAdapter);
        return inflate;
    }

    @Override
    public void getData(Object o) {
        Notifation notifation = (Notifation) o;
        if(notifation.getMessage().equals("成功")){
            for (int i = 0; i < notifation.getData().size(); i++) {
                String notifyType = notifation.getData().get(i).getNotifyType();
                if(notifyType.equals("1")){
                    dataBeanList.addAll(notifation.getData());
                    notifationoneAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
