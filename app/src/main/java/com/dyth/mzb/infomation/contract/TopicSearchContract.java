package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/2.
 */

public interface TopicSearchContract {

    interface ITopicSearchView<T>{
        <T> void getData(T t);
    }

    interface ITopicSearchModule{
        <T> void getTopicSearchData(String keyword, NetworkCallBack<T> networkCallBack);
    }

    interface ITopicSearchPresenter{
        <T> void getTopicSearchData(String keyword);
    }

}
