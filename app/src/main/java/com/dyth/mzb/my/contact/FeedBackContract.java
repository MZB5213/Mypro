package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/14.
 */

public interface FeedBackContract {

    interface FeedBackView<T>{
        void getFeedBackData(T t);
    }

    interface FeedBackModule{
        <T> void getFeedBack(NetworkCallBack<T> networkCallBack);
    }

    interface FeedBackPresenter{
        void getFeedBack();
    }

}
