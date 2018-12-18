package com.framework.yison.component_base.base.mvp;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.framework.yison.component_base.R;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.framework.yison.component_base.base.mvp.inter.MvpCallback;
import com.framework.yison.component_base.constants.BaseApplication;
import com.framework.yison.component_base.helper.HUDFactory;
import com.framework.yison.component_base.util.StatuBarCompat;
import com.framework.yison.component_base.util.ToastUtils;
import com.framework.yison.component_data.constant.BaseEventbusBean;
import com.gyf.barlibrary.ImmersionBar;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Created by TOME .
 * @时间 2018/5/2 17:40
 * @描述 ${MVP模式的Base Activity}
 */

public abstract class BaseVpActivity<V extends IView, P extends IPresenter<V>> extends AppCompatActivity implements MvpCallback<V, P>, IView {

    protected P mPresenter;
    protected V mView;
    private Unbinder unBinder;
    protected boolean regEvent;
    public BaseVpActivity mActivity;
    public KProgressHUD kProgressHUD;
    protected boolean isDestory = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        //加入activity管理
        BaseApplication.getAppContext().getActivityControl().addActivity(this);
        //沉浸式状态栏
        initImmersionBar();
        //setImmeriveStatuBar();
        mActivity = this;
        onViewCreated();
        initTitle();
        initView();
        if (regEvent) {
            EventBus.getDefault().register(this);
        }
        initListener();
    }

    protected void initImmersionBar() {
        ImmersionBar.with(this).init();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).init();
        }
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    /**
     * 初始化presenter
     */
    public void onViewCreated() {
        mView = createView();
        if (getPresenter() == null) {
            mPresenter = createPresenter();
            getLifecycle().addObserver(mPresenter);
        }
        mPresenter = getPresenter();
        mPresenter.attachView(getMvpView());
    }

    @CallSuper
    protected void initListener() {
        mPresenter.attachView(getMvpView());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BaseEventbusBean event) {
        onEvent(event);
    }

    protected void onEvent(BaseEventbusBean event) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showHUD(String msg) {
        if (isDestory) {
            return;
        }
        if (kProgressHUD == null) {
            kProgressHUD = HUDFactory.getInstance().creatHUD(this);
        }
        kProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                // .setLabel(getString(R.string.loading))
                .setLabel(TextUtils.isEmpty(msg) ? getString(R.string.loading) : msg)
                // .setLabel(null)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.3f).show();
    }

    @Override
    public void dismissHUD() {
        if (null != kProgressHUD && kProgressHUD.isShowing()) {
            kProgressHUD.dismiss();
        }
    }

    /**
     * 提示网络请求错误信息
     *
     * @param msg
     * @param code
     */
    @Override
    public void showError(String msg, String code) {
        String mCode = "-1";
        if (mCode.equals(code)) {
            ToastUtils.showShort(mActivity, msg);
        }

    }

    /**
     * 空界面显示
     */
    @Override
    public void showNormal() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.i("当前运行的activity:" + getClass().getName());
    }

    public void back(View v) {
        finish();
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            getLifecycle().removeObserver(mPresenter);
        }
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        setPresenter(null);
        setMvpView(null);
        if (regEvent) {
            EventBus.getDefault().unregister(this);
        }

        //必须调用该方法，防止内存泄漏
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).destroy();
        }
        isDestory = true;
        dismissHUD();
        //移除类
        BaseApplication.getAppContext().getActivityControl().removeActivity(this);

    }

    /**
     * 沉浸式状态栏
     */
    protected void setImmeriveStatuBar() {
        StatuBarCompat.setImmersiveStatusBar(true, Color.WHITE, this);

    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setMvpView(V view) {
        this.mView = view;
    }

    @Override
    public V getMvpView() {
        return this.mView;
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化标题
     */
    protected abstract void initTitle();

    /**
     * 初始化数据
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected void loadData() {
    }


}
