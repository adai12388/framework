package com.ibotntest.moduletest.presenter;

import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.ibotntest.moduletest.contract.HomeContract;
import com.ibotntest.moduletest.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeContract.View,HomeContract.Model> implements HomeContract.Presenter
{

    @Override
    protected HomeContract.Model createModel() {
        return new HomeModel();
    }
}
