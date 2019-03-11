package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.morefocus.MoreFocusResponse;
import com.dyth.mzb.my.contact.MoreFocusContract;
import com.dyth.mzb.my.module.MoreFocusModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/8.
 */

public class MoreFocusPresenterImpl implements MoreFocusContract.IMoreFocusPresenter {

    private MoreFocusContract.IMoreFocusView iMoreFocusView;
    private MoreFocusContract.IMoreFocusModule iMoreFocusModule;

    public MoreFocusPresenterImpl(MoreFocusContract.IMoreFocusView iMoreFocusView) {
        this.iMoreFocusView = iMoreFocusView;
        iMoreFocusModule = new MoreFocusModuleImpl();
    }

    @Override
    public void getMoreFocus(String usetId, String tagId) {
        iMoreFocusModule.getMoreFocus(usetId, tagId, new NetworkCallBack<MoreFocusResponse>() {
            @Override
            public void getSucces(MoreFocusResponse moreFocusResponse) {
                Log.e("---MoreFocusResponse---",moreFocusResponse.toString());
                iMoreFocusView.getData(moreFocusResponse);
            }

            @Override
            public void getError() {

            }
        });
    }
}
