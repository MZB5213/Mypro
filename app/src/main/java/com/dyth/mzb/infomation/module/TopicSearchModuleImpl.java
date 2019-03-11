package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.TopicSearchContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/2.
 */

public class TopicSearchModuleImpl implements TopicSearchContract.ITopicSearchModule {
    @Override
    public <T> void getTopicSearchData(String keyword, NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().postTheLabel(URLManger.DYTH_TOPICSS,keyword,networkCallBack);
    }
}
