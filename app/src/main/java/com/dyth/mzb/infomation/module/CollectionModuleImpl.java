package com.dyth.mzb.infomation.module;

import com.dyth.mzb.R;
import com.dyth.mzb.infomation.contract.CollectionContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/12/26.
 */

public class CollectionModuleImpl  implements CollectionContract.IUserModule{

    @Override
    public <T> void getUserCollection( String objectId,String type, NetworkCallBack<T> networCallBack) {

        RetrofitUtils.getInstance().postUserCollection(URLManger.BYTH_JOINCOLLECTION,objectId,type,networCallBack);
    }
}
