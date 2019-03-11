package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/13.
 */

public interface MyNotifationContract {

    interface IMyNotifationView<T>{
        void getData(T t);
    }

    interface IMyNotifationModule{
        <T> void getNotifationData(NetworkCallBack<T> networkCallBack);
    }

    interface IMyNotifationPresenter{
        <T> void getNotifationData();
    }



}
