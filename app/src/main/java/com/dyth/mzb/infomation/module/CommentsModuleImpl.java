package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.CommentsContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class CommentsModuleImpl implements CommentsContract.ICommentsModule {
    @Override
    public <T> void getComentData(String objectId, String content, NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().postComments(URLManger.BYTH_COMMENTS,objectId,content,networkCallBack);
    }
}
