package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.updata.UpdataMain;
import com.dyth.mzb.my.contact.UpdataContract;
import com.dyth.mzb.my.module.UpDataModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/4.
 */

public class UpDataPresenterImpl implements UpdataContract.IUpdataPresenter {

    UpdataContract.IUpdataView iUpdataView;
    UpdataContract.IUpdataModule iUpdataModule;

    public UpDataPresenterImpl(UpdataContract.IUpdataView iUpdataView) {
        this.iUpdataView = iUpdataView;
        iUpdataModule = new UpDataModuleImpl();
    }

    @Override
    public void getUpdata(String birthday, String nickname, String personalProfile, String professionId, String sex) {
        iUpdataModule.getUpdata(birthday, nickname, personalProfile, professionId, sex, new NetworkCallBack<UpdataMain>() {
            @Override
            public void getSucces(UpdataMain updataMain) {
                Log.e("UPDATA----------",updataMain.getMessage());
                iUpdataView.getUpdataData(updataMain);
            }

            @Override
            public void getError() {

            }
        });
    }
}
