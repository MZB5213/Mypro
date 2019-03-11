package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/28.
 */

public interface HotTheLabelContract {

    interface IHotTheLabelView<T>{
        <T> void getHotTheLabelData(T t);
    }

    interface IHotTheLabelModule{
        <T> void getHotTheLable(NetworkCallBack<T> networkCallBack);
    }

    interface IHotTheLabelPresenter{
        void getHotTheLable( );
    }



}
