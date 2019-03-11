package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.feedback.MyFeedBack;
import com.dyth.mzb.my.contact.FeedBackContract;
import com.dyth.mzb.my.module.FeedBackModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class FeedBackPresenterImpl implements FeedBackContract.FeedBackPresenter {
    
    private FeedBackContract.FeedBackView feedBackView;
    private FeedBackContract.FeedBackModule feedBackModule;

    public FeedBackPresenterImpl(FeedBackContract.FeedBackView feedBackView) {
        this.feedBackView = feedBackView;
        feedBackModule = new FeedBackModuleImpl();
    }

    @Override
    public void getFeedBack() {
        feedBackModule.getFeedBack(new NetworkCallBack<MyFeedBack>() {
            @Override
            public void getSucces(MyFeedBack myFeedBack) {
                Log.e("-----MyFeedback-----",myFeedBack.toString());
                feedBackView.getFeedBackData(myFeedBack);
            }

            @Override
            public void getError() {

            }
        });
    }
}
