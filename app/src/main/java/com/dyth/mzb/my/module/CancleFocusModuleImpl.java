package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.CancleFocusContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class CancleFocusModuleImpl implements CancleFocusContract.ICancleFocusModule{
    @Override
    public <T> void getData(List<String> strings, NetworkCallBack<T> networkCallBack) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","049de01db14a4c8184faa0aca7facf8a");
        map.put("followIdList",strings);
        RetrofitUtils.getInstance().post(URLManger.DYTH_CANCLEFOCUS,map,networkCallBack);
    }
}
