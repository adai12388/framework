package com.ibotntest.moduletest.fragment;


import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.framework.yison.component_base.base.mvp.BaseVpFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.contract.HomeFragmentContract;
import com.ibotntest.moduletest.presenter.HomeFragmentPresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseVpFragment<HomeFragmentContract.View, HomeFragmentContract.Presenter> implements HomeFragmentContract.View {


    @BindView(R.id.test_slideTabLayout_head_first)
    SlidingTabLayout testSlideTabLayoutHeadFirst;
    @BindView(R.id.test_vp)
    ViewPager testVp;
    @BindView(R.id.test_float_btn)
    FloatingActionButton testFloatBtn;
    private ArrayList<Fragment> fragments;

    @Override
    protected int getLayout() {
        return R.layout.test_fragment_home_coor;
    }

    @Override
    protected void initTitle() {

    }


    private String[] tabTitles = {"音乐", "视频"};

    @Override
    protected void initView() {

        fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new AttentionFragment());

        testSlideTabLayoutHeadFirst.setViewPager(testVp, tabTitles, getActivity(), fragments);

    }

    @Override
    public HomeFragmentContract.Presenter createPresenter() {
        return new HomeFragmentPresenter();
    }

    @Override
    public HomeFragmentContract.View createView() {
        return this;
    }

}
