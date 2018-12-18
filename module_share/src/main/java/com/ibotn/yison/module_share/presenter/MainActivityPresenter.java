package com.ibotn.yison.module_share.presenter;

import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.ibotn.yison.module_share.contract.IMainActivityContract;
import com.ibotn.yison.module_share.model.MainActivityModel;

public class MainActivityPresenter extends BasePresenter<IMainActivityContract.View,IMainActivityContract.Model> implements IMainActivityContract.Presenter {
    @Override
    protected IMainActivityContract.Model createModel() {
        return new MainActivityModel();
    }
}
