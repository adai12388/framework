package com.ibotn.yison.module_share.presenter;

import com.framework.yison.component_base.base.BaseObserver;
import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.framework.yison.component_base.util.L;
import com.ibotn.yison.module_share.bean.ShareFileBean;
import com.ibotn.yison.module_share.contract.IFileFragmentContract;
import com.ibotn.yison.module_share.model.FileFragmentModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FileFragmentPresenter extends BasePresenter<IFileFragmentContract.View, IFileFragmentContract.Model> implements IFileFragmentContract.Presenter {

    private static final String TAG = FileFragmentPresenter.class.getSimpleName();

    @Override
    protected IFileFragmentContract.Model createModel() {
        return new FileFragmentModel(getContext());
    }

    @Override
    public void loadFile(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int type) {
            addDisposable(mModel.loadFile(isRefresh, page, type)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new BaseObserver<List<ShareFileBean>>(mView,rlRefreshLayout) {
                        @Override
                        public void onNext(List<ShareFileBean> shareFileBeans) {
                            L.e(TAG, "yison loadFile " + shareFileBeans);
                            mView.showArticleList(shareFileBeans);
                        }

                        @Override
                        public void onComplete() {
                            super.onComplete();
                        }
                    }));
    }


}
