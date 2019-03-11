package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.MyFocusContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class MyFocusModuleImpl implements MyFocusContract.IMyFocusModule {
    @Override
    public <T> void getMyFocus(NetworkCallBack<T> networkCallBack) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","049de01db14a4c8184faa0aca7facf8a");
        RetrofitUtils.getInstance().post(URLManger.DYTH_MYFOCUS,map,networkCallBack);
    }
}
