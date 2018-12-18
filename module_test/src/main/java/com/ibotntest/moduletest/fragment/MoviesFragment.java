package com.ibotntest.moduletest.fragment;

import android.support.v7.widget.RecyclerView;

import com.framework.yison.component_base.base.mvp.BaseVpListFragment;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.contract.MoviesFragmentContract;
import com.ibotntest.moduletest.presenter.MoviesFragmentPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

public class MoviesFragment extends BaseVpListFragment<MoviesFragmentContract.View, MoviesFragmentContract.Presenter> implements MoviesFragmentContract.View {
    @BindView(R.id.test_recyclerView)
    RecyclerView testRecyclerView;
    @BindView(R.id.test_smartRefreshLayout)
    SmartRefreshLayout testSmartRefreshLayout;

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {

    }

    @Override
    protected int getLayout() {
        return R.layout.test_fragment_famous;
    }

    @Override
    protected void initView() {
        rlRefreshLayout = testSmartRefreshLayout;
        super.initView();
        regEvent = true;

    }

    @Override
    protected void initTitle() {

    }

    @Override
    public MoviesFragmentContract.Presenter createPresenter() {
        return new MoviesFragmentPresenter();
    }

    @Override
    public MoviesFragmentContract.View createView() {
        return this;
    }

}
