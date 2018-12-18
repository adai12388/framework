package com.framework.yison.module_shop_mall.model;

import com.framework.yison.component_base.base.mvp.DisposablePool;
import com.framework.yison.module_shop_mall.contract.NavigationContract;
import com.framework.yison.module_shop_mall.presenter.NavigationPresenter;

/**
 * @author by TOME .
 * @data on      2018/6/29 14:24
 * @describe ${TODO}
 */

public class NavigationModel  extends DisposablePool implements NavigationContract.Model{

    private NavigationPresenter mPresenter;
    public NavigationModel(NavigationPresenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void getNavigationData() {
       // addDisposable();
    }
}
