package com.dyth.mzb.infomation.presenter;

import com.dyth.mzb.infomation.beans.topicsearch.TopicSearch;
import com.dyth.mzb.infomation.contract.TopicSearchContract;
import com.dyth.mzb.infomation.module.TopicSearchModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/2.
 */

public class TopicSearchPresenterImpl implements TopicSearchContract.ITopicSearchPresenter {

    private TopicSearchContract.ITopicSearchModule iTopicSearchModule;
    private TopicSearchContract.ITopicSearchView iTopicSearchView;

    public TopicSearchPresenterImpl(TopicSearchContract.ITopicSearchView iTopicSearchView) {
        this.iTopicSearchView = iTopicSearchView;
        iTopicSearchModule = new TopicSearchModuleImpl();
    }

    @Override
    public <T> void getTopicSearchData(String keyword) {
        iTopicSearchModule.getTopicSearchData(keyword, new NetworkCallBack<TopicSearch>() {
            @Override
            public void getSucces(TopicSearch topicSearch) {
                iTopicSearchView.getData(topicSearch);
            }

            @Override
            public void getError() {

            }
        });
    }
}
