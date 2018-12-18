package com.ibotntest.moduletest.contract;

import com.framework.yison.component_base.base.mvp.inter.IModel;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.bean.FeedArticleListData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import io.reactivex.Observable;

public class FamousFragmentContract {

    public interface View extends IView {

    }

    public interface Presenter extends IPresenter<View>
    {

        /**
         * 获取文章数据
         * @param isRefresh
         * @param rlRefreshLayout
         * @param page
         */
        void  FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page);

    }

    public interface Model extends IModel
    {
        /**
         * 获取条目数据
         * @param page
         */
        Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page);
    }

}
