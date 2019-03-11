package com.dyth.mzb.my.contact;

import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/1/15.
 */

public interface CancleFocusContract {

    interface ICancleFocusView<T>{
        void getCancleData(T t);
    }

    interface ICancleFocusModule{

        List<String> strings = new ArrayList<>();
        <T> void getData(List<String> strings, NetworkCallBack<T> networkCallBack);
    }

    interface ICancleFocusPresenter{
        void getData(List<String> strings);
    }


}
