package com.dyth.mzb;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.commonsdk.UMConfigure;

/**
 * Created by Lenovo on 2018/12/27.
 */

public class MyAppliction extends Application {



    @Override
    public void onCreate() {
        super.onCreate();

        /*
注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调用初始化接口
（如需要使用AndroidManifest.xml中配置好的appkey和channel值，UMConfigure.init调用中appkey和channel参数请置为null）。
    Context context, String appkey, String channel, int deviceType, String pushSecret
*/
       // UMConfigure.init(this,"5c35acacb465f5202e0014d1","Statistical");
        UMConfigure.init(this, "5c35acacb465f5202e0014d1", "Statistical", UMConfigure.DEVICE_TYPE_PHONE, null);

    }


}
