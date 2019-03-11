package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/4.
 */

public interface UpdataContract {

    interface IUpdataView<T>{
         void getUpdataData(T t);
    }

    interface IUpdataModule{
        <T> void getUpdata(String birthday, String nickname, String personalProfile, String professionId, String sex, NetworkCallBack<T> networkCallBack);
    }

    interface IUpdataPresenter{
        void getUpdata(String birthday, String nickname, String personalProfile, String professionId, String sex);
    }

}
