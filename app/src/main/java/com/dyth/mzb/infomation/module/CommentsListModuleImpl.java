package com.dyth.mzb.infomation.module;

import com.dyth.mzb.infomation.contract.CommentsListContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class CommentsListModuleImpl implements CommentsListContract.ICommentsListModule {
    @Override
    public <T> void getCommentsListData(String objectId, NetworkCallBack<T> networkCallBack) {
        RetrofitUtils.getInstance().postCommentsList(URLManger.DYTH_COMMENTSLIST,objectId,networkCallBack);
    }
}
