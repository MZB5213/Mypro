package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.canclefocus.CancleFocus;
import com.dyth.mzb.my.contact.CancleFocusContract;
import com.dyth.mzb.my.module.CancleFocusModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.List;

/**
 * Created by Lenovo on 2019/1/15.
 */

public class CancleFocusPresenterImpl implements CancleFocusContract.ICancleFocusPresenter {

    private CancleFocusContract.ICancleFocusView iCancleFocusView;
    private CancleFocusContract.ICancleFocusModule iCancleFocusModule;

    public CancleFocusPresenterImpl(CancleFocusContract.ICancleFocusView iCancleFocusView) {
        this.iCancleFocusView = iCancleFocusView;
        iCancleFocusModule = new CancleFocusModuleImpl();
    }

    @Override
    public void getData(final List<String> strings) {
        iCancleFocusModule.getData(strings, new NetworkCallBack<CancleFocus>() {
            @Override
            public void getSucces(CancleFocus cancleFocus) {
                iCancleFocusView.getCancleData(cancleFocus);
            }

            @Override
            public void getError() {


            }
        });
    }
}
