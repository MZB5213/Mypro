package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.details.Details;
import com.dyth.mzb.infomation.beans.content.Message;
import com.dyth.mzb.infomation.beans.content.MessageTabs;
import com.dyth.mzb.infomation.contract.InfomationContract;
import com.dyth.mzb.infomation.module.InfoModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/25.
 */

public class InfoPresenterImpl implements InfomationContract.INewsPresenter {

    InfomationContract.INewsView iNewsView;
    InfomationContract.INewsModule iNewsModule;

    public InfoPresenterImpl(InfomationContract.INewsView iNewsView) {
        this.iNewsView = iNewsView;
        iNewsModule = new InfoModuleImpl();
    }

    @Override
    public void getTabs() {
        iNewsModule.getTabs(new NetworkCallBack<MessageTabs>() {
            @Override
            public void getSucces(MessageTabs messageTabs) {
                Log.e("Tabs",messageTabs.toString());
                iNewsView.getData(messageTabs);
            }

            @Override
            public void getError() {

            }
        });
    }

    @Override
    public void getList(String newsId) {
        iNewsModule.getList(newsId, new NetworkCallBack<Message>() {
            @Override
            public void getSucces(Message message) {
               // Log.e("11111111111",message.getData().getNewList().get(5).getTitle());
                iNewsView.getData(message);
            }

            @Override
            public void getError() {

            }
        });

    }

    @Override
    public void getDetails(String newsId) {
        iNewsModule.getDetails(newsId, new NetworkCallBack<Details>() {
            @Override
            public void getSucces(Details details) {
               // Log.e("details",details.toString());
                iNewsView.getData(details);
            }

            @Override
            public void getError() {

            }
        });
    }

}
