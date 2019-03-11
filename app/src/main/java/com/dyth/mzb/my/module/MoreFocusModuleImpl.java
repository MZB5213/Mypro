package com.dyth.mzb.my.module;

import com.dyth.mzb.my.contact.MoreFocusContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class MoreFocusModuleImpl implements MoreFocusContract.IMoreFocusModule {
    @Override
    public <T> void getMoreFocus(String userId, String tagId, NetworkCallBack<T> networkCallBack) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("tagId",tagId);
        map.put("cursor",0);
        RetrofitUtils.getInstance().post(URLManger.DYTH_MYFOCUS,map,networkCallBack);
    }
}
