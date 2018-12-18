package com.framework.welfare.module_welfare.arouter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.framework.yison.component_data.d_arouter.IntentKV;
import com.framework.yison.component_data.d_arouter.RouterURLS;
import com.framework.welfare.module_welfare.bean.PreviewBean;

import java.util.ArrayList;

/**
 * @Created by TOME .
 * @时间 2018/4/26 10:19
 * @描述 ${路由中心}
 */
//ARouter 提供了大量的参数类型 跳转携带 https://blog.csdn.net/zhaoyanjun6/article/details/76165252
public class RouterCenter {
    /**
     * 跳转到图片预览图
     */
    public static void toPreview(ArrayList<PreviewBean> previewBeans, int position) {
        ARouter.getInstance().build(RouterURLS.WELFARE_PREVIEW)
                .withParcelableArrayList(IntentKV.K_WELFARE_PHOTO, previewBeans)
                .withInt(IntentKV.K_WELFARE_POSITION, position)
                .navigation();
    }



}
