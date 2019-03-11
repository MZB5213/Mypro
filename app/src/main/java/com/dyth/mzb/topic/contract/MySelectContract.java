package com.dyth.mzb.topic.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public interface MySelectContract {

    interface IMyTopicView<T>{
         void getMySelectData(T t);
    }
    interface IMyTopicModule{
        <T> void getMySelect(NetworkCallBack<T> networkCallBack);
    }

    interface IMyTopicPresenter{
        void getMySelect();
    }


}
