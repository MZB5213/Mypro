package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.MyTopicContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/4.
 */

public class MyTopicModuleImpl implements MyTopicContract.IMyTopicModule{
    @Override
    public <T> void getMyTopic(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().postCollection(URLManger.DYTH_LOADING,networkCallBack);
    }
}
