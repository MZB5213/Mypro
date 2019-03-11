package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.upload.UpLoadHeader;
import com.dyth.mzb.my.contact.UpLoadHeaderContract;
import com.dyth.mzb.my.module.UpLoadHeaderModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.io.File;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class UpLoadHeaderPresenterImpl implements UpLoadHeaderContract.IUpLoadHeaderPresenter {

    UpLoadHeaderContract.IUpLoadHeaderView iUpLoadHeaderView;
    UpLoadHeaderContract.IUpLoadHeaderModule iUpLoadHeaderModule;

    public UpLoadHeaderPresenterImpl(UpLoadHeaderContract.IUpLoadHeaderView iUpLoadHeaderView) {
        this.iUpLoadHeaderView = iUpLoadHeaderView;
        iUpLoadHeaderModule = new UpLoadHeaderModuleImpl();
    }

    @Override
    public void getUpLoadHeader(File file) {
        iUpLoadHeaderModule.getUpLoadHeader(file, new NetworkCallBack<UpLoadHeader>() {
            @Override
            public void getSucces(UpLoadHeader upLoadHeader) {
                Log.e("sssssssss",upLoadHeader.toString());
                iUpLoadHeaderView.getUpLoadHeaderData(upLoadHeader);
            }

            @Override
            public void getError() {

            }
        });
    }
}
