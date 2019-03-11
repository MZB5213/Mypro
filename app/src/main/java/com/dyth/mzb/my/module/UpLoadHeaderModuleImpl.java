package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.UpLoadHeaderContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.io.File;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class UpLoadHeaderModuleImpl implements UpLoadHeaderContract.IUpLoadHeaderModule {
    @Override
    public <T> void getUpLoadHeader(File file, NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().Post(URLManger.DYTH_SCTX,file,networkCallBack);
    }
}
