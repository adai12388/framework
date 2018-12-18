package com.ibotntest.moduletest.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.framework.yison.component_base.base.mvp.BaseVpActivity;
import com.framework.yison.component_base.base.mvp.inter.IPresenter;
import com.framework.yison.component_base.base.mvp.inter.IView;
import com.framework.yison.component_base.util.L;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.R2;
import com.ibotntest.moduletest.fragment.HomeFragment;
import com.ibotntest.moduletest.fragment.TwoFragment;
import com.ibotntest.moduletest.presenter.HomePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeActivity extends BaseVpActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    private static final Object TAG = HomeActivity.class.getSimpleName();
    @BindView(R2.id.fl_content)
    FrameLayout flContent;
    @BindView(R2.id.test_drawer_layout)
    DrawerLayout testDrawerLayout;
    @BindView(R.id.test_commonTabLayout)
    CommonTabLayout testCommonTabLayout;
    @BindView(R.id.navigation)
    NavigationView navigation;
    private TextView mNavName;

    private MenuItem mItemWelfare;
    private MenuItem mItemAboutUs;
    private MenuItem mItemLogout;
    private ArrayList<Fragment> fragments;
    private ArrayList<CustomTabEntity> tabEntities;

    @Override
    protected int getLayoutId() {
        return R.layout.test_activity_home;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        initNavigationView();

        initFragments();
        initBottomNavigationView();
    }

    private void initNavigationView() {
        mNavName = (TextView) navigation.getHeaderView(0).findViewById(R.id.nav_name);
        mItemWelfare = navigation.getMenu().findItem(R.id.test_menu_fuli);
        mItemAboutUs = navigation.getMenu().findItem(R.id.test_menu_about_us);
        mItemLogout = navigation.getMenu().findItem(R.id.test_menu_logout);

        initDrawerLayout();

        //设置图片为本身的颜色
        navigation.setItemIconTintList(null);
        navigation.setNavigationItemSelectedListener(this);
        mNavName.setOnClickListener(this);
    }

    private void initBottomNavigationView() {
        initTabEntitys();
        testCommonTabLayout.setTabData(tabEntities, this, R.id.fl_content, fragments);

//        addFragment(R.id.fl_content,fragments.get(0));
    }

    private String[] items = null;
    private int[] icons_select = {R.mipmap.ic_tab_knowledge_hierarchy_selected,
            R.mipmap.ic_tab_knowledge_hierarchy_selected, R.mipmap.ic_tab_knowledge_hierarchy_selected, R.mipmap.ic_tab_knowledge_hierarchy_selected};
    private int[] icons_unSelect = {R.mipmap.ic_tab_knowledge_hierarchy_not_selected,
            R.mipmap.ic_tab_knowledge_hierarchy_not_selected, R.mipmap.ic_tab_knowledge_hierarchy_not_selected, R.mipmap.ic_tab_knowledge_hierarchy_not_selected};

    private void initTabEntitys() {
        items = getResources().getStringArray(R.array.test_items);
        tabEntities = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            final int j = i;
            CustomTabEntity entity = new CustomTabEntity() {
                @Override
                public String getTabTitle() {
                    return items[j];
                }

                @Override
                public int getTabSelectedIcon() {
                    return icons_select[j];
                }

                @Override
                public int getTabUnselectedIcon() {
                    return icons_unSelect[j];
                }
            };
            tabEntities.add(entity);
        }

    }


    private Fragment mCurrentFragment;

    private void addFragment(int fl_content, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mCurrentFragment != null)

                    transaction.hide(mCurrentFragment).show(fragment);
                else
                    transaction.show(fragment);

            } else {
                if (mCurrentFragment != null)
                    transaction.hide(mCurrentFragment).add(fl_content, fragment);
                else
                    transaction.add(fl_content, fragment);
            }
            mCurrentFragment = fragment;
            transaction.commit();

        }


    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TwoFragment());
        fragments.add(new TwoFragment());
        fragments.add(new TwoFragment());

    }


    public void initDrawerLayout() {

        //通过actionbardrawertoggle将toolbar与drawablelayout关联起来
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, testDrawerLayout, R.string.test_drawer_open, R.string.test_drawer_close) /*{
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //可以重新侧滑方法,该方法实现侧滑动画,整个布局移动效果
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = testDrawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        }*/;

        toggle.syncState();
        testDrawerLayout.addDrawerListener(toggle);

    }


    @Override
    public IPresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public IView createView() {
        return this;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.test_menu_fuli:
                L.d(TAG, "yison test_menu_fuli");
                break;
            case R.id.test_menu_about_us:
                L.d(TAG, "yison test_menu_about_us");
                break;
            case R.id.test_menu_logout:
                L.d(TAG, "yison test_menu_logout");
                break;

        }
        return false;
    }

    @Override
    public void onClick(View v) {
        L.d(TAG, "点击名字了");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
