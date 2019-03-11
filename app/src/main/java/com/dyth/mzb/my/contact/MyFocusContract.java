package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/5.
 */

public interface MyFocusContract {

    interface IMyFocusView<T>{
        void getMyFocusData(T t);
    }

    interface IMyFocusModule{
        <T> void getMyFocus(NetworkCallBack<T> networkCallBack);
    }

    interface IMyFocusPresenter{
        void getMyFocus();
    }

}
