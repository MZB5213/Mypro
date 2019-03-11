package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.FeedBackContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class FeedBackModuleImpl implements FeedBackContract.FeedBackModule {
    @Override
    public <T> void getFeedBack(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().post(URLManger.DYTH_CJWT,networkCallBack);
    }
}
