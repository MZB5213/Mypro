package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.usercollection.UserCollection;
import com.dyth.mzb.infomation.contract.CollectionContract;
import com.dyth.mzb.infomation.module.CollectionModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class CollectionPresenterImpl implements CollectionContract.IUserPresenter {

    CollectionContract.IUserView iUserView;
    CollectionContract.IUserModule iUserModule;

    public CollectionPresenterImpl(CollectionContract.IUserView iUserView) {
        this.iUserView = iUserView;
        iUserModule = new CollectionModuleImpl();
    }

    @Override
    public <T> void getUserCollection(String objectId,String type) {
        iUserModule.getUserCollection(objectId,type,new NetworkCallBack<UserCollection>() {
            @Override
            public void getSucces(UserCollection userCollection) {
                Log.e("sssssss",userCollection.toString());
                iUserView.getCollectionData(userCollection);
            }

            @Override
            public void getError() {

            }
        });
    }
}
