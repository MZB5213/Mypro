package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public interface UserCenterContract {

    interface IUserCenterView<T>{
        void getData(T t);
    }

    interface IUserCenterModule{
        <T> void getUserCenterData(NetworkCallBack<T> networkCallBack);
    }

    interface IUserCenterPresenter{
        void getUserCenterData();
    }

}
