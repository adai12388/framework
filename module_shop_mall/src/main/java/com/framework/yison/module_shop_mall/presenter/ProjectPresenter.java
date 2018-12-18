package com.framework.yison.module_shop_mall.presenter;

import com.framework.yison.component_base.base.BaseObserver;
import com.framework.yison.component_base.base.mvp.BasePresenter;
import com.framework.yison.component_data.bean.BaseObj;
import com.framework.yison.module_shop_mall.bean.ProjectClassifyBean;
import com.framework.yison.module_shop_mall.contract.IProjectContract;
import com.framework.yison.module_shop_mall.model.ProjectModel;
import java.util.List;

/**
 * Description :
 *
 * @author Tome
 * @date 2018/7/18  18:20
 * - generate by MvpAutoCodePlus plugin.
 */

public class ProjectPresenter extends BasePresenter<IProjectContract.View,IProjectContract.Model> implements IProjectContract.Presenter {

    @Override
    protected IProjectContract.Model createModel() {
        return new ProjectModel();
    }

    @Override
    public void getProjectClassifyData() {
        addDisposable(mModel.getProjectClassifyData()
                            .subscribeWith(new BaseObserver<BaseObj<List<ProjectClassifyBean>>>(){
                                @Override
                                public void onNext(BaseObj<List<ProjectClassifyBean>> listBaseObj) {
                                    List<ProjectClassifyBean> data = listBaseObj.getData();
                                    mView.showProjectClassifyData(data);
                                }
                            }));

    }

}

