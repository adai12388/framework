package com.framework.yison.module_shop_mall.model;

import com.framework.yison.component_base.base.mvp.DisposablePool;
import com.framework.yison.component_data.bean.BaseObj;
import com.framework.yison.module_shop_mall.api.ApiService;
import com.framework.yison.module_shop_mall.api.ModelVpService;
import com.framework.yison.module_shop_mall.bean.NavigationBean;
import com.framework.yison.module_shop_mall.contract.INavigationV2Contract;
import io.reactivex.Observable;
import java.util.List;

/**
 * Description :
 *
 * @author Tome
 * @date 2018/7/18  15:02
 * - generate by MvpAutoCodePlus plugin.
 */

public class NavigationV2Model extends DisposablePool implements INavigationV2Contract.Model {

    @Override
    public Observable<BaseObj<List<NavigationBean>>> getNavigationData() {

        return ModelVpService.getRemoteDataVp(new ModelVpService.MethodSelect<List<NavigationBean>>() {
            @Override
            public Observable<BaseObj<List<NavigationBean>>> selectM(ApiService service) {
                return service.getNavigationListData();
            }
        });
    }
}

