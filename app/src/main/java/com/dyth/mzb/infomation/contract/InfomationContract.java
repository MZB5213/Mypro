package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/25.
 */

public interface InfomationContract {

    interface INewsView<T>{
        void getData(T t);
    }

    interface INewsModule{
        <T>void getTabs(NetworkCallBack<T> networkCallBack);
        <T>void getList(String ChannelId,NetworkCallBack<T> networkCallBack);
        <T>void getDetails(String newsId,NetworkCallBack<T> networkCallBack);
    }
    interface INewsPresenter{
        void getTabs();
        void getList(String ChannelId);
        void getDetails(String newsId);
    }




}
