package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public interface UserInfoContract {

    interface IUserInfoView<T>{
        void getUserInfoData(T t);
    }

    interface IUserInfoModule{
        <T> void getUserInfo(NetworkCallBack<T> networkCallBack);
    }

    interface IUserInfoPresenter{
        void getUserInfo();
    }


}
