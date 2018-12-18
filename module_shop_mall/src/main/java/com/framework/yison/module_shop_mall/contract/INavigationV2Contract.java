package com.framework.yison.module_shop_mall.contract;

import com.framework.yison.component_base.base.mvp.inter.IModel;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.framework.yison.component_data.bean.BaseObj;
import com.framework.yison.module_shop_mall.bean.NavigationBean;
import io.reactivex.Observable;
import java.util.List;

/**
 * Description :
 *
 * @author Tome
 * @date 2018/7/18  15:02
 * - generate by MvpAutoCodePlus plugin.
 */

public interface INavigationV2Contract {
    interface View extends IView {
        void showNavigation(List<NavigationBean> result);
    }

    interface Presenter extends IPresenter<View> {
        void getNavigationData();
    }

    interface Model extends IModel {
        Observable<BaseObj<List<NavigationBean>>> getNavigationData();
    }
}
