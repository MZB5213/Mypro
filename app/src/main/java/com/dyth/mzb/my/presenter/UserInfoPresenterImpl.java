package com.dyth.mzb.my.presenter;

import android.util.Log;

import com.dyth.mzb.my.base.userinfomation.UserInfomaton;
import com.dyth.mzb.my.contact.UserInfoContract;
import com.dyth.mzb.my.module.UserInfoModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2019/1/3.
 */

public class UserInfoPresenterImpl implements UserInfoContract.IUserInfoPresenter {

    UserInfoContract.IUserInfoView iUserInfoView;
    UserInfoContract.IUserInfoModule iUserInfoModule;

    public UserInfoPresenterImpl(UserInfoContract.IUserInfoView iUserInfoView) {
        this.iUserInfoView = iUserInfoView;
        iUserInfoModule = new UserInfoModuleImpl();
    }

    @Override
    public void getUserInfo() {
        iUserInfoModule.getUserInfo(new NetworkCallBack<UserInfomaton>() {
            @Override
            public void getSucces(UserInfomaton userInfomaton) {
                Log.e("qieqieqie",userInfomaton.toString());
                iUserInfoView.getUserInfoData(userInfomaton);
            }

            @Override
            public void getError() {

            }
        });
    }
}
