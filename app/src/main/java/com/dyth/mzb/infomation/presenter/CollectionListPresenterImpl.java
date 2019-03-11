package com.dyth.mzb.infomation.presenter;

import android.util.Log;

import com.dyth.mzb.infomation.beans.Collection.Collection;
import com.dyth.mzb.infomation.contract.CollectionListContract;
import com.dyth.mzb.infomation.module.CollectionListModuleImpl;
import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class CollectionListPresenterImpl implements CollectionListContract.INewsPresenter {

    CollectionListContract.INewsView iNewsView;
    CollectionListContract.INewsModule iNewsModule;

    public CollectionListPresenterImpl(CollectionListContract.INewsView iNewsView) {
        this.iNewsView = iNewsView;
        iNewsModule = new CollectionListModuleImpl();
    }

    @Override
    public void getCollection() {
        iNewsModule.getCollection(new NetworkCallBack<Collection>() {
            @Override
            public void getSucces(Collection collection) {
                Log.e("58585858",collection.toString());
                iNewsView.getDataCollection(collection);
            }

            @Override
            public void getError() {

            }
        });
    }
}
