package com.framework.yison.module_shop_mall.model;

import com.framework.yison.component_base.base.mvp.DisposablePool;
import com.framework.yison.component_base.net.params.RequestMapParams;
import com.framework.yison.component_data.bean.BaseObj;
import com.framework.yison.module_shop_mall.api.ApiService;
import com.framework.yison.module_shop_mall.api.ModelVpService;
import com.framework.yison.module_shop_mall.bean.FeedArticleListData;
import com.framework.yison.module_shop_mall.contract.MainContract;

import io.reactivex.Observable;

/**
 * @author by TOME .
 * @data on      2018/7/3 17:43
 * @describe ${TODO}
 */

public class mainMvpModel extends DisposablePool implements MainContract.Model {


    @Override
    public Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page, RequestMapParams params) {
        return ModelVpService.getRemoteDataVp(new ModelVpService.MethodSelect<FeedArticleListData>() {
            @Override
            public Observable<BaseObj<FeedArticleListData>> selectM(ApiService service) {
                return service.getFeedArticleList(page, params.build());
            }
        });
    }
}
