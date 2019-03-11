package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

import java.io.File;

/**
 * Created by Lenovo on 2019/1/3.
 */

public interface UpLoadHeaderContract {

    interface IUpLoadHeaderView<T>{
        void getUpLoadHeaderData(T t);
    }

    interface IUpLoadHeaderModule{
        <T> void getUpLoadHeader(File file, NetworkCallBack<T> networkCallBack);
    }

    interface IUpLoadHeaderPresenter{
        void getUpLoadHeader(File file);
    }

}
