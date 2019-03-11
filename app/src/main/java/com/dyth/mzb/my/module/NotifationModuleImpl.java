package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.MyCOMContract;
import com.dyth.mzb.my.contact.MyNotifationContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2019/1/12.
 */

public class NotifationModuleImpl implements MyNotifationContract.IMyNotifationModule {
    @Override
    public <T> void getNotifationData(NetworkCallBack<T> networkCallBack) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","e7d9914be4214263ad8e2a3e88e72263");
        RetrofitUtils.getInstance().post(URLManger.DYTH_NOT,map,networkCallBack);
    }
}
