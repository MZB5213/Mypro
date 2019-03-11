package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.comments.CommentsList;
import com.dyth.mzb.infomation.contract.CommentsListContract;
import com.dyth.mzb.infomation.module.CommentsListModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class CommentsListPresenterImpl implements CommentsListContract.ICommentsListPresenter {

    CommentsListContract.ICommentsListView iCommentsListView;
    CommentsListContract.ICommentsListModule iCommentsListModule;

    public CommentsListPresenterImpl(CommentsListContract.ICommentsListView iCommentsListView) {
        this.iCommentsListView = iCommentsListView;
        iCommentsListModule = new CommentsListModuleImpl();
    }

    @Override
    public void getCommentsListData(String objectId) {
        iCommentsListModule.getCommentsListData(objectId, new NetworkCallBack<CommentsList>() {
            @Override
            public void getSucces(CommentsList commentsList) {
                Log.e("-=-==-=-=-=-=-=",commentsList.getMessage());
                iCommentsListView.getCommentsListData(commentsList);
            }

            @Override
            public void getError() {

            }
        });
    }
}
