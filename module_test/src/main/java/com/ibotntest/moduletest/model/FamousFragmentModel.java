package com.ibotntest.moduletest.model;

import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.api.ApiService;
import com.ibotntest.moduletest.api.ModelVpService;
import com.ibotntest.moduletest.bean.FeedArticleListData;
import com.ibotntest.moduletest.contract.FamousFragmentContract;

import io.reactivex.Observable;

public class FamousFragmentModel implements FamousFragmentContract.Model {


    @Override
    public Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page) {
        return ModelVpService.getRemoteDataVp(new ModelVpService.MethodSelect<FeedArticleListData>() {
            @Override
            public Observable<BaseObj<FeedArticleListData>> selectM(ApiService service) {
                return service.getFeedArticleList(page);
            }
        });
    }
}
