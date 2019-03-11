package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class InfoModuleImpl implements InfomationContract.INewsModule {
    @Override
    public <T> void getTabs(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().post(URLManger.DYTH_TABS,networkCallBack);
    }

    @Override
    public <T> void getList(String newsId, NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().post(URLManger.DYTH_LIST,newsId,networkCallBack);
    }

    @Override
    public <T> void getDetails(String newsId, NetworkCallBack<T> networkCallBack) {
        Map<String,Object> map = new HashMap<>();
        map.put("newsId",newsId);
        map.put("userId","e7d9914be4214263ad8e2a3e88e72263");
        RetrofitUtils.getInstance().post(URLManger.DYTH_INFO,map,networkCallBack);
    }


}
