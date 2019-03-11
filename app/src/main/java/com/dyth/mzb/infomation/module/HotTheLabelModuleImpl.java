package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.HotTheLabelContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class HotTheLabelModuleImpl implements HotTheLabelContract.IHotTheLabelModule {


    @Override
    public <T> void getHotTheLable(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().post(URLManger.DYTH_HotTHELABL,networkCallBack);
    }
}
