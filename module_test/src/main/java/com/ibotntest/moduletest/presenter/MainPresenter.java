package com.ibotntest.moduletest.presenter;

import com.framework.yison.component_base.base.BaseObserver;
import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.framework.yison.component_base.util.L;
import com.framework.yison.component_base.util.LogUtil;
import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.bean.BannerData;
import com.ibotntest.moduletest.contract.MainContract;
import com.ibotntest.moduletest.model.MainModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter {
    @Override
    protected MainContract.Model createModel() {
        return new MainModel(this);
    }
    private SmartRefreshLayout mSmartRefreshLayout;

    public MainPresenter(SmartRefreshLayout smartRefreshLayout)
    {
        this.mSmartRefreshLayout = smartRefreshLayout;
    }

    @Override
    public void BannerData() {
        mModel.getBannerData()
                .doOnSubscribe(disable -> {
                    L.d("yison doOnSubscribe");
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    L.d("yison doFinally");
                })
                .subscribeWith(new BaseObserver<BaseObj<List<BannerData>>>(mView,mSmartRefreshLayout) {
                    @Override
                    public void onNext(BaseObj<List<BannerData>> listBaseObj) {
                        L.d("yison onNext");
                        mView.showRecycleData(listBaseObj);
                        mView.showBannerData(listBaseObj.getData());
                    }
                });


    }

    @Override
    public void startBannerPlay() {
        LogUtil.d("yison startBannerPlay");
    }

    @Override
    public void stopBannerPlay() {
        L.d("yison stopBannerPlay");
    }
}
