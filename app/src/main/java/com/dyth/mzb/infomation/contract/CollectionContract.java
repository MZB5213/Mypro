package com.dyth.mzb.infomation.contract;

import com.dyth.mzb.utils.network.NetworkCallBack;

/**
 * Created by Lenovo on 2018/12/26.
 */

public interface CollectionContract {

  interface IUserView<T>{
      <T> void getCollectionData(T t);
  }

  interface IUserModule{
      <T> void getUserCollection(String objectId,String type, NetworkCallBack<T> networkCallBack);
  }

  interface IUserPresenter{
      <T>void getUserCollection(String objectId,String type);
  }


}
