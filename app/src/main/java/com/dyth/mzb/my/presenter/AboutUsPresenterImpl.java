package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.aboutus.AboutUs;
import com.dyth.mzb.my.contact.AboutUSContract;
import com.dyth.mzb.my.module.AboutUsModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;
import com.umeng.commonsdk.statistics.noise.ABTest;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class AboutUsPresenterImpl implements AboutUSContract.IAboutUsPresenter {
    
    private AboutUSContract.IAboutUsView iAboutUsView;
    private AboutUSContract.IAboutUsModule iAboutUsModule;

    public AboutUsPresenterImpl(AboutUSContract.IAboutUsView iAboutUsView) {
        this.iAboutUsView = iAboutUsView;
        iAboutUsModule = new AboutUsModuleImpl();
    }

    @Override
    public void getAboutUs() {
        iAboutUsModule.getAboutUs(new NetworkCallBack<AboutUs>() {
            @Override
            public void getSucces(AboutUs aboutUs) {
                Log.e("-----ABOUT----", aboutUs.toString());
                iAboutUsView.getAboutData(aboutUs);
            }

            @Override
            public void getError() {

            }
        });
    }
}
