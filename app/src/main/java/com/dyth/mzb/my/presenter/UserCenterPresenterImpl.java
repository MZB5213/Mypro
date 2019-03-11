package com.dyth.mzb.my.presenter;

import com.dyth.mzb.my.base.usercenter.UserCenter;
import com.dyth.mzb.my.contact.UserCenterContract;
import com.dyth.mzb.my.module.UserCenterModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class UserCenterPresenterImpl implements UserCenterContract.IUserCenterPresenter {

   UserCenterContract.IUserCenterView iUserCenterView;
   UserCenterContract.IUserCenterModule iUserCenterModule;

    public UserCenterPresenterImpl(UserCenterContract.IUserCenterView iUserCenterView) {
        this.iUserCenterView = iUserCenterView;
        iUserCenterModule = new UserCenterModuleImpl();
    }

    @Override
    public void getUserCenterData() {
        iUserCenterModule.getUserCenterData(new NetworkCallBack<UserCenter>() {
            @Override
            public void getSucces(UserCenter userCenter) {
                iUserCenterView.getData(userCenter);
            }

            @Override
            public void getError() {

            }
        });
    }
}
