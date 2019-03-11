package com.dyth.mzb.topic.module;

import com.dyth.mzb.topic.bean.MyTopiccs;
import com.dyth.mzb.topic.contract.MyTopicContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class MyTopicModuleImpl implements MyTopicContract.IMyTopicModule {
    @Override
    public <T> void getMyTopic(NetworkCallBack<T> networkCallBack) {
        MyTopiccs myTopiccs = new MyTopiccs();
        myTopiccs.setCursor(0);
        myTopiccs.setTagId("");
        myTopiccs.setType("0");
        myTopiccs.setUserId("e7d9914be4214263ad8e2a3e88e72263");
        final Gson gson = new Gson();
        String s = gson.toJson(myTopiccs);
        RetrofitUtils.getInstance().Post(URLManger.DYTH_LOADING,s,networkCallBack);
    }
}
