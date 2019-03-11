package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/14.
 */

public interface AboutUSContract {

    interface IAboutUsView<T>{
        void getAboutData(T T);
    }

    interface IAboutUsModule{
        <T> void getAboutUs(NetworkCallBack<T> networkCallBack);
    }

    interface IAboutUsPresenter{
        void getAboutUs();
    }

}
