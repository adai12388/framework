package com.ibotn.yison.module_share.presenter;

import com.ibotn.yison.module_share.contract.ILoginContract;
import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.ibotn.yison.module_share.model.LoginModel;

/**
 * Description :
 *
 * @author yison
 * @date 2018/11/24  14:17
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginPresenter extends BasePresenter<ILoginContract.View, ILoginContract.Model> implements ILoginContract.Presenter {

    @Override
    protected ILoginContract.Model createModel() {
        return new LoginModel();
    }
}

