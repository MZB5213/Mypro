package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.focus.MyFocus;
import com.dyth.mzb.my.contact.MyFocusContract;
import com.dyth.mzb.my.module.MyFocusModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/5.
 */

public class MyFocusPresenterImpl implements MyFocusContract.IMyFocusPresenter {
    
    private MyFocusContract.IMyFocusView iMyFocusView;
    private MyFocusContract.IMyFocusModule iMyFocusModule;

    public MyFocusPresenterImpl(MyFocusContract.IMyFocusView iMyFocusView) {
        this.iMyFocusView = iMyFocusView;
        iMyFocusModule = new MyFocusModuleImpl();
    }

    @Override
    public void getMyFocus() {
        iMyFocusModule.getMyFocus(new NetworkCallBack<MyFocus>() {
            @Override
            public void getSucces(MyFocus myFocus) {
                Log.e("MyFocus",myFocus.toString());
                iMyFocusView.getMyFocusData(myFocus);
            }

            @Override
            public void getError() {

            }
        });
    }
}
