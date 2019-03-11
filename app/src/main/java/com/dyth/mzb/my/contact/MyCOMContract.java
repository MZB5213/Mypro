package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/11.
 */

public interface MyCOMContract {

    interface IMyCOMView<T>{
        void getData(T t);
    }

    interface IMyCOMModule{
        <T> void getCOM(NetworkCallBack<T> networkCallBack);
    }

    interface IMyCOMPresenter{
        void getCOM();
    }

}
