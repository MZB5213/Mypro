package com.dyth.mzb.infomation.module;

import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class AddChannelModuleImpl implements AddChannelContract.IAddChannelModule {
    @Override
    public <T> void getChannel(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().post(URLManger.DYTH_MORECHANNEL,networkCallBack);
    }
}
