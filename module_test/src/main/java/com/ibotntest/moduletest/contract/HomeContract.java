package com.ibotntest.moduletest.contract;

import com.framework.yison.component_base.base.mvp.inter.IModel;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;

public class HomeContract {

    public interface View extends IView
    {

    }

    public interface Presenter extends IPresenter<View>
    {

    }

    public interface Model extends IModel
    {

    }
}
