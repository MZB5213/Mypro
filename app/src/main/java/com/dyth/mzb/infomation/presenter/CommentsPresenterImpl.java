package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.comments.CommentsResponse;
import com.dyth.mzb.infomation.contract.CommentsContract;
import com.dyth.mzb.infomation.module.CommentsModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class CommentsPresenterImpl implements CommentsContract.ICommentsPresenter {
    
    CommentsContract.ICommentsView iCommentsView;
    CommentsContract.ICommentsModule iCommentsModule;

    public CommentsPresenterImpl(CommentsContract.ICommentsView iCommentsView) {
        this.iCommentsView = iCommentsView;
        iCommentsModule = new CommentsModuleImpl();
    }

    @Override
    public <T> void getComentData(String objectId, String content) {
        iCommentsModule.getComentData(objectId, content, new NetworkCallBack<CommentsResponse>() {
            @Override
            public void getSucces(CommentsResponse commentsResponse) {
                Log.e("535353",commentsResponse.toString());
                iCommentsView.getCommentData(commentsResponse);
            }

            @Override
            public void getError() {

            }
        });
    }
}
