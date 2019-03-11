package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.AboutUSContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class AboutUsModuleImpl implements AboutUSContract.IAboutUsModule {
    @Override
    public <T> void getAboutUs(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().post(URLManger.DYTH_ABOUT,networkCallBack);
    }
}
