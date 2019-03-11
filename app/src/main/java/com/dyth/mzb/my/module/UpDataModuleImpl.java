package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.UpdataContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2019/1/4.
 */

public class UpDataModuleImpl implements UpdataContract.IUpdataModule {
    @Override
    public <T> void getUpdata(String birthday, String nickname, String personalProfile, String professionId, String sex, NetworkCallBack<T> networkCallBack) {

        RetrofitUtils.getInstance().PostUpdata(URLManger.DYTH_UPDATA,birthday,nickname,personalProfile,professionId,sex,networkCallBack);
    }
}
