package com.ibotn.yison.module_share.view;

import com.ibotn.yison.module_share.contract.IWefwareContract;
import com.framework.yison.component_base.base.mvp.BaseVpActivity;
import com.ibotn.yison.module_share.presenter.WefwarePresenter;

/**
 * Description :
 *
 * @author yison
 * @date 2018/11/24  14:20
 * - generate by MvpAutoCodePlus plugin.
 */

public class WefwareActivity extends BaseVpActivity<IWefwareContract.View, IWefwareContract.Presenter> implements IWefwareContract.View {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public IWefwareContract.Presenter createPresenter() {
        return new WefwarePresenter();
    }

    @Override
    public IWefwareContract.View createView() {
        return this;
    }
}

