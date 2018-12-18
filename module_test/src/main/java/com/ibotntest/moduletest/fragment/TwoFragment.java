package com.ibotntest.moduletest.fragment;

import com.framework.yison.component_base.base.mvp.BaseVpFragment;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.contract.TwoFragmentContract;
import com.ibotntest.moduletest.presenter.TwoFragmentPresenter;

public class TwoFragment extends BaseVpFragment<TwoFragmentContract.View,TwoFragmentContract.Presenter> implements TwoFragmentContract.View {
    @Override
    protected int getLayout() {
        return R.layout.test_fragment_two;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }


    @Override
    public TwoFragmentContract.Presenter createPresenter() {
        return new TwoFragmentPresenter();
    }

    @Override
    public TwoFragmentContract.View createView() {
        return this;
    }
}
