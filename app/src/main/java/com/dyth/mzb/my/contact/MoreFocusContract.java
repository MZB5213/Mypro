package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/8.
 */

public interface MoreFocusContract {

    interface IMoreFocusView<T>{
        void getData(T t);
    }

    interface IMoreFocusModule{
        <T> void getMoreFocus(String userId, String tagId, NetworkCallBack<T> networkCallBack);
    }

    interface IMoreFocusPresenter{
        void getMoreFocus(String usetId,String tagId);
    }


}
