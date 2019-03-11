package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.newssearch.Newssearch;
import com.dyth.mzb.infomation.beans.thelabel.TheLableResponse;
import com.dyth.mzb.infomation.contract.TheLabelContract;
import com.dyth.mzb.infomation.module.TheLabelModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class TheLabelPresenterImpl implements TheLabelContract.ITheLabelPresenter {
    TheLabelContract.ITheLabelView iTheLabelView;
    TheLabelContract.ITheLabelModule iTheLabelModule;

    public TheLabelPresenterImpl(TheLabelContract.ITheLabelView iTheLabelView) {
        this.iTheLabelView = iTheLabelView;
        iTheLabelModule = new TheLabelModuleImpl();
    }

    @Override
    public void getThelabel(String keyword) {
            iTheLabelModule.getThelabel(keyword, new NetworkCallBack<Newssearch>() {
                @Override
                public void getSucces(Newssearch newssearch) {
                    Log.e("asfasgadf",newssearch.getMessage());
                    iTheLabelView.getTheLabelData(newssearch);
                }

                @Override
                public void getError() {

                }
            });

    }
}
