package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.GiveLikeContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class GiveLikeModuleImpl implements GiveLikeContract.GiveLikeModule {
    @Override
    public <T> void getGiveLike(String objectId, String type, NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().postLike(URLManger.BYTH_GIVELIKE,objectId,type,networkCallBack);
    }
}
