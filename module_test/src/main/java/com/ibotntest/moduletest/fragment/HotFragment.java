package com.ibotntest.moduletest.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.framework.yison.component_base.base.mvp.BaseVpFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.R2;
import com.ibotntest.moduletest.contract.HotFragmentContract;
import com.ibotntest.moduletest.presenter.HotFragmentPresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HotFragment extends BaseVpFragment<HotFragmentContract.View, HotFragmentContract.Presenter> implements HotFragmentContract.View {

    @BindView(R2.id.test_slidingTabLayout)
    SlidingTabLayout testSlidingTabLayout;
    @BindView(R2.id.test_viewPager)
    ViewPager testViewPager;
    private ArrayList<Fragment> fragments;


    private String[] titles = {"专辑", "明星"};

    @Override
    protected int getLayout() {
        return R.layout.test_fragment_hot;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        initFragment();
        initSliding();
    }

    private void initSliding() {
        testSlidingTabLayout.setViewPager(testViewPager, titles, getActivity(), fragments);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new FamousFragment());
        fragments.add(new MoviesFragment());
    }

    @Override
    public HotFragmentContract.Presenter createPresenter() {
        return new HotFragmentPresenter();
    }

    @Override
    public HotFragmentContract.View createView() {
        return this;
    }

}
