package com.ibotntest.moduletest.fragment;

import com.framework.yison.component_base.base.mvp.BaseVpFragment;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.contract.AttentionFragmentContract;
import com.ibotntest.moduletest.presenter.AttentionFragmentPresenter;

public class AttentionFragment extends BaseVpFragment<AttentionFragmentContract.View, AttentionFragmentContract.Presenter> implements AttentionFragmentContract.View {
    @Override
    protected int getLayout() {
        return R.layout.test_fragment_attension;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public AttentionFragmentContract.Presenter createPresenter() {
        return new AttentionFragmentPresenter();
    }

    @Override
    public AttentionFragmentContract.View createView() {
        return this;
    }
}
