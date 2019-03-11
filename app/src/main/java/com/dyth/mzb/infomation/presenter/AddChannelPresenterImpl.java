package com.dyth.mzb.infomation.presenter;

import com.dyth.mzb.infomation.beans.morechannel.MoreChannel;
import com.dyth.mzb.infomation.module.AddChannelContract;
import com.dyth.mzb.infomation.module.AddChannelModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class AddChannelPresenterImpl implements AddChannelContract.IAddChanelPresenter {
    
    private AddChannelContract.IAddChannelView iAddChannelView;
    private AddChannelContract.IAddChannelModule iAddChannelModule;

    public AddChannelPresenterImpl(AddChannelContract.IAddChannelView iAddChannelView) {
        this.iAddChannelView = iAddChannelView;
        iAddChannelModule = new AddChannelModuleImpl();
    }

    @Override
    public void getChannel() {
        iAddChannelModule.getChannel(new NetworkCallBack<MoreChannel>() {
            @Override
            public void getSucces(MoreChannel moreChannel) {
                iAddChannelView.getAddData(moreChannel);
            }

            @Override
            public void getError() {

            }
        });
    }
}
