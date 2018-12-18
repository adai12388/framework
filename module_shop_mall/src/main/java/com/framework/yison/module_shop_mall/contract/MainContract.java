package com.framework.yison.module_shop_mall.contract;

import com.framework.yison.component_base.base.mvp.inter.IModel;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.framework.yison.component_base.net.params.RequestMapParams;
import com.framework.yison.component_data.bean.BaseObj;
import com.framework.yison.module_shop_mall.bean.FeedArticleListData;
import io.reactivex.Observable;


/**
 * @Created by TOME .
 * @时间 2018/5/4 11:15
 * @描述 ${TODO}
 */

public interface MainContract {

    interface View extends IView {

        void showTestData(FeedArticleListData feedArticleListData);

    }

    interface Presenter extends IPresenter<View> {

       void initFeedArticleList();
    }

    interface Model extends IModel {

        Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page, RequestMapParams params);
    }
}
