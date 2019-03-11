package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/27.
 */

public interface CommentsListContract {

    interface ICommentsListView<T>{
        void getCommentsListData(T t);
    }

    interface ICommentsListModule{
       <T>void getCommentsListData(String objectId, NetworkCallBack<T> networkCallBack);
    }

    interface ICommentsListPresenter{
        void getCommentsListData(String objectId);
    }

}
