package com.ibotn.yison.module_share.view;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.annotation.NonNull;

import com.framework.yison.component_base.base.mvp.BaseVpActivity;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.ibotn.yison.module_share.contract.ILoginContract;
import com.ibotn.yison.module_share.presenter.LoginPresenter;

/**
 * Description :
 *
 * @author yison
 * @date 2018/11/24  14:17
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginActivity extends BaseVpActivity<ILoginContract.View,ILoginContract.Presenter> implements ILoginContract.View {


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
    public ILoginContract.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public ILoginContract.View createView() {
        return this;
    }
}

