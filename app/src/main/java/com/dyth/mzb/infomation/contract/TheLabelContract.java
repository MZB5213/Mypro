package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/28.
 */

public interface TheLabelContract {

    interface ITheLabelView<T>{

         void getTheLabelData(T t);
    }

    interface ITheLabelModule{
        <T> void getThelabel(String keyword, NetworkCallBack<T> networkCallBack);
    }

    interface ITheLabelPresenter{
        void getThelabel(String keyword);
    }

}
