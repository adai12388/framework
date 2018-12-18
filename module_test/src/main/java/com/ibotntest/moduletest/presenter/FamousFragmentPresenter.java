package com.ibotntest.moduletest.presenter;

import com.framework.yison.component_base.base.BaseObserver;
import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.framework.yison.component_base.util.L;
import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.bean.FeedArticleListData;
import com.ibotntest.moduletest.contract.FamousFragmentContract;
import com.ibotntest.moduletest.model.FamousFragmentModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class FamousFragmentPresenter extends BasePresenter<FamousFragmentContract.View, FamousFragmentContract.Model> implements FamousFragmentContract.Presenter {

    private static final String TAG = FamousFragmentPresenter.class.getSimpleName();

    @Override
    protected FamousFragmentContract.Model createModel() {
        return new FamousFragmentModel();
    }

    @Override
    public void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page) {
        addDisposable(mModel.getFeedArticleList(page)
                .subscribeWith(new BaseObserver<BaseObj<FeedArticleListData>>(mView,rlRefreshLayout) {
                    @Override
                    public void onNext(BaseObj<FeedArticleListData> feedArticleListDataBaseObj) {
                        L.d(TAG, "yison feedArticleListDataBaseObj code " + feedArticleListDataBaseObj.getCode() + " size "+feedArticleListDataBaseObj.getData().getDatas().size());


                    }
                })
        );
    }
}
