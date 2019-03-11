package com.dyth.mzb.utils.network;

/**
 * Created by Lenovo on 2018/12/25.
 */

public interface NetworkCallBack<T> {

    void getSucces(T t);
    void getError();

}
