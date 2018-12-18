package com.ibotntest.moduletest.contract;


import com.framework.yison.component_base.base.mvp.inter.IModel;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.bean.BannerData;

import java.util.List;

import io.reactivex.Observable;


public interface MainContract {
    interface View extends IView {
        void showBannerData(List<BannerData> bannerDataList);

        void showRecycleData(BaseObj<List<BannerData>> listBaseObj);
    }

    interface Presenter extends IPresenter<View> {
        /**
         * 加载轮播图
         */
        void BannerData();

        /**
         * 轮播图自动播放
         */
        void startBannerPlay();

        /**
         * 轮播图停止播放
         */
        void stopBannerPlay();
    }

    interface Model extends IModel {
        /**
         * 获取轮播图数据
         */
        Observable<BaseObj<List<BannerData>>> getBannerData();
    }
}
