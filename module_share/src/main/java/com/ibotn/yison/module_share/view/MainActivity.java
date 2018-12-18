package com.ibotn.yison.module_share.view;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.framework.yison.component_base.base.mvp.BaseVpActivity;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.ibotn.yison.module_share.R;
import com.ibotn.yison.module_share.contract.IMainActivityContract;
import com.ibotn.yison.module_share.presenter.MainActivityPresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseVpActivity<IMainActivityContract.View, IMainActivityContract.Presenter> implements IMainActivityContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.share_slidingTabLayout)
    SlidingTabLayout shareSlidingTabLayout;
    @BindView(R.id.share_viewPager)
    ViewPager shareViewPager;
    private String[] titles = null;
    private ArrayList<Fragment> fragments = null;

    @Override
    protected int getLayoutId() {
        return R.layout.share_activity_main;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initImmersionBar() {
//        super.initImmersionBar();
        ImmersionBar.with(this)
                .navigationBarEnable(true)
                .navigationBarWithKitkatEnable(true)
                .statusBarView(R.id.top_view)
                .statusBarColor(R.color.grey_bar)
                .statusBarDarkFont(true)
//                .navigationBarColor(R.color.share_colorPrimary)
                .navigationBarColor(R.color.grey_bar)
                .navigationBarDarkIcon(true)
                .init();
    }

    @Override
    protected void initView() {
        titles = new String[]{getString(R.string.share_str_video), getString(R.string.share_str_audio), getString(R.string.share_str_picture), getString(R.string.share_str_ducment), getString(R.string.share_str_other)};
        fragments = new ArrayList<>();
        fragments.add(FileFragment.newInstance(FileFragment.TYPE_VIDEO));
        fragments.add(FileFragment.newInstance(FileFragment.TYPE_AUDIO));
        fragments.add(FileFragment.newInstance(FileFragment.TYPE_PICTURE));
        fragments.add(FileFragment.newInstance(FileFragment.TYPE_DUCMENT));
        fragments.add(FileFragment.newInstance(FileFragment.TYPE_OTHER));
        shareViewPager.setOffscreenPageLimit(3);
        shareSlidingTabLayout.setViewPager(shareViewPager, titles, this, fragments);
    }

    @Override
    public IMainActivityContract.Presenter createPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public IMainActivityContract.View createView() {
        return this;
    }


}
