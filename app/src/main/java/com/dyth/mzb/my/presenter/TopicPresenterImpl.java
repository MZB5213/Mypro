package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.topiccollection.Topic;
import com.dyth.mzb.my.contact.TopicContract;
import com.dyth.mzb.my.module.TopicModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class TopicPresenterImpl implements TopicContract.ITopicPresenter {

    private TopicContract.ITopicView iTopicView;
    private TopicContract.ITopicModule iTopicModule;

    public TopicPresenterImpl(TopicContract.ITopicView iTopicView) {
        this.iTopicView = iTopicView;
        iTopicModule = new TopicModuleImpl();
    }

    @Override
    public <T> void getTopicData() {
        iTopicModule.getTopicData(new NetworkCallBack<Topic>() {
            @Override
            public void getSucces(Topic topic) {
                Log.e("---BBBBBB---",topic.toString());
                iTopicView.getData(topic);
            }

            @Override
            public void getError() {

            }
        });
    }
}
