package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/4.
 */

public interface MyTopicContract {

    interface IMyTopicView<T>{
        void getMyTopicData(T t);
    }

    interface IMyTopicModule{
        <T> void getMyTopic(NetworkCallBack<T> networkCallBack);
    }

    interface IMyTopicPresenter{
        void getMyTopic();
    }

}
