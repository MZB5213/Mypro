package com.dyth.mzb.my.presenter;

import com.dyth.mzb.my.base.topiccollection.TopicCollection;
import com.dyth.mzb.my.contact.MyTopicContract;
import com.dyth.mzb.my.module.MyTopicModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/4.
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
        iMyTopicModule.getMyTopic(new NetworkCallBack<TopicCollection>() {
            @Override
            public void getSucces(TopicCollection topicCollection) {
                iMyTopicView.getMyTopicData(topicCollection);
            }

            @Override
            public void getError() {

            }
        });
    }
}
