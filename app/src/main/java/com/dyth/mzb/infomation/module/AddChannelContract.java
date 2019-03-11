package com.dyth.mzb.infomation.module;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/15.
 */

public interface AddChannelContract {

    interface IAddChannelView<T>{
        void getAddData(T t);
    }

    interface IAddChannelModule{
        <T> void getChannel(NetworkCallBack<T> networkCallBack);
    }

    interface IAddChanelPresenter{
        void getChannel();
    }

}
