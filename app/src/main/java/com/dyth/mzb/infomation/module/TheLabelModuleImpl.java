package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.TheLabelContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class TheLabelModuleImpl implements TheLabelContract.ITheLabelModule {
    @Override
    public <T> void getThelabel(String keyword, NetworkCallBack<T> networkCallBack) {
            RetrofitUtils.getInstance().postTheLabel(URLManger.DYTH_THELABEL, keyword, networkCallBack);

    }
}
