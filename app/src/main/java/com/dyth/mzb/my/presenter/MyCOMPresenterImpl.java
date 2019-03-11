package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.MyCOM.MyCOM;
import com.dyth.mzb.my.contact.MyCOMContract;
import com.dyth.mzb.my.module.MyCOMModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class MyCOMPresenterImpl implements MyCOMContract.IMyCOMPresenter {
    private MyCOMContract.IMyCOMView iMyCOMView;
    private MyCOMContract.IMyCOMModule iMyCOMModule;

    public MyCOMPresenterImpl(MyCOMContract.IMyCOMView iMyCOMView) {
        this.iMyCOMView = iMyCOMView;
        iMyCOMModule = new MyCOMModuleImpl();
    }

    @Override
    public void getCOM() {
        iMyCOMModule.getCOM(new NetworkCallBack<MyCOM>() {
            @Override
            public void getSucces(MyCOM myCOM) {
                Log.e("AAAAAAAAAA",myCOM.toString());
                iMyCOMView.getData(myCOM);
            }

            @Override
            public void getError() {

            }
        });
    }
}
