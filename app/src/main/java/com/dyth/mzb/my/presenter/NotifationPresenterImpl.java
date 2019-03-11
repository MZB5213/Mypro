package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.notification.Notifation;
import com.dyth.mzb.my.contact.MyCOMContract;
import com.dyth.mzb.my.contact.MyNotifationContract;
import com.dyth.mzb.my.module.MyCOMModuleImpl;
import com.dyth.mzb.my.module.NotifationModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/13.
 */

public class NotifationPresenterImpl implements MyNotifationContract.IMyNotifationPresenter{

    private MyNotifationContract.IMyNotifationView iMyNotifationView;
    private MyNotifationContract.IMyNotifationModule iMyNotifationModule;

    public NotifationPresenterImpl(MyNotifationContract.IMyNotifationView iMyNotifationView) {
        this.iMyNotifationView = iMyNotifationView;
        iMyNotifationModule = new NotifationModuleImpl();
    }

    @Override
    public <T> void getNotifationData() {
        iMyNotifationModule.getNotifationData(new NetworkCallBack<Notifation>() {
            @Override
            public void getSucces(Notifation notifation) {
                Log.e("---Notifation---",notifation.toString());
                iMyNotifationView.getData(notifation);
            }

            @Override
            public void getError() {

            }
        });
    }
}
