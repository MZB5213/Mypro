package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.CollectionListContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class CollectionListModuleImpl implements CollectionListContract.INewsModule {
    @Override
    public <T> void getCollection(NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().postCollection(URLManger.DYTH_COLLECTION,networkCallBack);
    }
}
