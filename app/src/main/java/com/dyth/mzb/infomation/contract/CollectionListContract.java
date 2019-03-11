package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public interface CollectionListContract {

    interface INewsView<T>{
        void getDataCollection(T t);
    }
    interface INewsModule{
        <T>void getCollection(NetworkCallBack<T> networkCallBack);
    }
    interface INewsPresenter{
        void getCollection();
    }

}
