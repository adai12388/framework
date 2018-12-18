package com.framework.yison.framedemomo2;

import com.framework.yison.component_base.constants.BaseApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * @Created by yison .
 * @时间 2018/5/14 17:40
 * @描述 ${应用的application}
 */

public class MyApplication extends BaseApplication {

    private static MyApplication myApplication;
//初始化
    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this ;

        ZXingLibrary.initDisplayOpinion(this);
    }
}
