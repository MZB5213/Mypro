package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/27.
 */

public interface CommentsContract {

    interface ICommentsView<T>{
        void getCommentData(T t);
    }

    interface ICommentsModule{
        <T> void getComentData(String objectId, String content, NetworkCallBack<T> networkCallBack);
    }

    interface ICommentsPresenter{
        <T> void getComentData(String objectId,String content);
    }

}
