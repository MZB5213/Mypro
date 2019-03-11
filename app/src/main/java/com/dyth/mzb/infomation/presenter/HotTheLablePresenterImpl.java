package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.newssearch.HotNewssearch;
import com.dyth.mzb.infomation.beans.thelabel.HotThelable;
import com.dyth.mzb.infomation.contract.HotTheLabelContract;
import com.dyth.mzb.infomation.module.HotTheLabelModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class HotTheLablePresenterImpl implements HotTheLabelContract.IHotTheLabelPresenter {

    HotTheLabelContract.IHotTheLabelModule iTheLabelModule;
    HotTheLabelContract.IHotTheLabelView iTheLabelView;

    public HotTheLablePresenterImpl(HotTheLabelContract.IHotTheLabelView iTheLabelView) {
        this.iTheLabelView = iTheLabelView;
        iTheLabelModule = new HotTheLabelModuleImpl();
    }

    @Override
    public void getHotTheLable() {
        iTheLabelModule.getHotTheLable(new NetworkCallBack<HotNewssearch>() {
            @Override
            public void getSucces(HotNewssearch hotNewssearch) {
                Log.e("31313113",hotNewssearch.toString());
                iTheLabelView.getHotTheLabelData(hotNewssearch);
            }

            @Override
            public void getError() {

            }
        });

    }
}
