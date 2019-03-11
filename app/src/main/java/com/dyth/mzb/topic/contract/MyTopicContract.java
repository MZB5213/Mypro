package com.dyth.mzb.topic.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public interface MyTopicContract {

    interface IMyTopicView<T>{
         void getMyTopicDta(T t);
    }
    interface IMyTopicModule{
        <T> void getMyTopic(NetworkCallBack<T> networkCallBack);
    }

    interface IMyTopicPresenter{
        void getMyTopic();
    }


}
