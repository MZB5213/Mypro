package com.dyth.mzb.topic.presenter;

import android.util.Log;

import com.dyth.mzb.topic.bean.MyTopic;
import com.dyth.mzb.topic.contract.MyTopicContract;
import com.dyth.mzb.topic.module.MyTopicModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class MyTopicPresenterImpl implements MyTopicContract.IMyTopicPresenter {

    MyTopicContract.IMyTopicView iMyTopicView;
    MyTopicContract.IMyTopicModule iMyTopicModule;

    public MyTopicPresenterImpl(MyTopicContract.IMyTopicView iMyTopicView) {
        this.iMyTopicView = iMyTopicView;
        iMyTopicModule = new MyTopicModuleImpl();
    }

    @Override
    public void getMyTopic() {
        iMyTopicModule.getMyTopic(new NetworkCallBack<MyTopic>() {
            @Override
            public void getSucces(MyTopic myTopic) {
                Log.e("66666666666",myTopic.toString());
                iMyTopicView.getMyTopicDta(myTopic);
            }

            @Override
            public void getError() {

            }
        });
    }
}
