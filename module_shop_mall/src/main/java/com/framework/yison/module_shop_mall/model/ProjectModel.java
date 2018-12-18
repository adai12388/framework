package com.framework.yison.module_shop_mall.model;

import com.framework.yison.component_base.base.mvp.DisposablePool;
import com.framework.yison.component_data.bean.BaseObj;
import com.framework.yison.module_shop_mall.api.ApiService;
import com.framework.yison.module_shop_mall.api.ModelVpService;
import com.framework.yison.module_shop_mall.bean.ProjectClassifyBean;
import com.framework.yison.module_shop_mall.contract.IProjectContract;
import io.reactivex.Observable;
import java.util.List;

/**
 * Description :
 *
 * @author Tome
 * @date 2018/7/18  18:20
 * - generate by MvpAutoCodePlus plugin.
 */

public class ProjectModel extends DisposablePool implements IProjectContract.Model {

    @Override
    public Observable<BaseObj<List<ProjectClassifyBean>>> getProjectClassifyData() {
        return ModelVpService.getRemoteDataVp(new ModelVpService.MethodSelect<List<ProjectClassifyBean>>() {
            @Override
            public Observable<BaseObj<List<ProjectClassifyBean>>> selectM(ApiService service) {
                return service.getProjectClassifyData();
            }
        });
    }

}

