package com.dyth.mzb.my.module;

import com.dyth.mzb.my.base.MyCOM.Conmment;
import com.dyth.mzb.my.contact.MyCOMContract;
import com.dyth.mzb.utils.RetrofitUtils;
import com.dyth.mzb.utils.URLManger;
import com.dyth.mzb.utils.network.NetworkCallBack;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by Lenovo on 2019/1/11.
 */

public class MyCOMModuleImpl implements MyCOMContract.IMyCOMModule{
    @Override
    public <T> void getCOM(NetworkCallBack<T> networkCallBack) {
//        Conmment conmment = new Conmment();
//        conmment.setUserId("e7d9914be4214263ad8e2a3e88e72263");
//        Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId","e7d9914be4214263ad8e2a3e88e72263");
        RetrofitUtils.getInstance().post(URLManger.DYTH_COM,map,networkCallBack);
    }
}
