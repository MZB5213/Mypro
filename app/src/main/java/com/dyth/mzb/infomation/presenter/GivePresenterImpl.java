package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.givelike.GiveLike;
import com.dyth.mzb.infomation.contract.GiveLikeContract;
import com.dyth.mzb.infomation.module.GiveLikeModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class GivePresenterImpl implements GiveLikeContract.GiveLikePresenter {

    GiveLikeContract.GiveLikeView giveLikeView;
    GiveLikeContract.GiveLikeModule giveLikeModule;

    public GivePresenterImpl(GiveLikeContract.GiveLikeView giveLikeView) {
        this.giveLikeView = giveLikeView;
        giveLikeModule = new GiveLikeModuleImpl();
    }

    @Override
    public void getGiveLike(String objectId, String type) {
        giveLikeModule.getGiveLike(objectId, type, new NetworkCallBack<GiveLike>() {
            @Override
            public void getSucces(GiveLike giveLike) {
                Log.e("ououououu",giveLike.toString());
                giveLikeView.getGiveLikeData(giveLike);
            }

            @Override
            public void getError() {

            }
        });
    }
}
