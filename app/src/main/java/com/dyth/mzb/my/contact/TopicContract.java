package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/11.
 */

public interface TopicContract {

    interface ITopicView<T>{
        void getData(T t);
    }

    interface ITopicModule{
        <T> void getTopicData(NetworkCallBack<T> networkCallBack);
    }

    interface ITopicPresenter{
        <T> void getTopicData();
    }


}
