package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public interface GiveLikeContract{

    interface GiveLikeView<T>{
        void getGiveLikeData(T t);
    }

    interface GiveLikeModule{
        <T> void getGiveLike(String objectId, String type, NetworkCallBack<T> networkCallBack);
    }

    interface GiveLikePresenter{
        void getGiveLike(String objectId,String type);
    }

}
