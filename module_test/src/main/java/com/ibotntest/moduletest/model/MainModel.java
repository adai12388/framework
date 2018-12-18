package com.ibotntest.moduletest.model;

import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.api.ApiService;
import com.ibotntest.moduletest.api.ModelVpService;
import com.ibotntest.moduletest.bean.BannerData;
import com.ibotntest.moduletest.contract.MainContract;
import com.ibotntest.moduletest.presenter.MainPresenter;

import java.util.List;

import io.reactivex.Observable;

public class MainModel implements MainContract.Model {
    private MainPresenter mPresenter;

    public MainModel(MainPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public Observable<BaseObj<List<BannerData>>> getBannerData() {
        Observable<BaseObj<List<BannerData>>> observable = ModelVpService.getRemoteDataVp(new ModelVpService.MethodSelect<List<BannerData>>() {
            @Override
            public Observable<BaseObj<List<BannerData>>> selectM(ApiService service) {
                return service.getBannerData();
            }
        });
        return observable;
    }
}
