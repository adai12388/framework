package com.ibotn.yison.module_share.contract;

import com.framework.yison.component_base.base.mvp.inter.IModel;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.ibotn.yison.module_share.bean.ShareFileBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import io.reactivex.Observable;

public interface IFileFragmentContract {

    public interface View extends IView
    {
         void showArticleList(List<ShareFileBean> shareFileBean);

    }

    public interface Presenter extends IPresenter<IFileFragmentContract.View>
    {

        void loadFile(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int type);
    }

    public interface Model extends IModel
    {

        Observable<List<ShareFileBean>> loadFile(boolean isRefresh, int page, int type);
    }
}
