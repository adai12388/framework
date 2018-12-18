package com.ibotntest.moduletest.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.framework.yison.component_base.base.mvp.BaseVpListActivity;
import com.framework.yison.component_base.util.L;
import com.framework.yison.component_base.util.ToastUtils;
import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.R2;
import com.ibotntest.moduletest.adapter.MainListAdapter;
import com.ibotntest.moduletest.bean.BannerData;
import com.ibotntest.moduletest.bean.FeedArticleData;
import com.ibotntest.moduletest.bean.FeedArticleListData;
import com.ibotntest.moduletest.contract.MainContract;
import com.ibotntest.moduletest.presenter.MainPresenter;
import com.ibotntest.moduletest.utils.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseVpListActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {


    @BindView(R2.id.srl_layout)
    SmartRefreshLayout srlLayout;
    @BindView(R2.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.test_activity_main;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        L.d("yison "+displayMetrics);
        super.rlRefreshLayout = srlLayout;
        super.initView();
    }

    @Override
    public void loadListData(SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        mPresenter.BannerData();
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(srlLayout);
    }

    @Override
    public MainContract.View createView() {
        return this;
    }

    @Override
    public void showBannerData(List<BannerData> bannerDataList) {
        L.d("yison showBannerData " + bannerDataList);
        ToastUtils.show(this, "123", Toast.LENGTH_LONG);
        initBannerData(bannerDataList);
    }

    @Override
    public void showRecycleData(BaseObj<List<BannerData>> listBaseObj) {
        initRecyclerView(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.startBannerPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.stopBannerPlay();
    }

    private Banner mBanner;
    private List<String> mBannerImageList;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;

    private void initBannerData(List<BannerData> bannerDataList) {
        if (bannerDataList == null || bannerDataList.size() == 0) {
            return;
        }
        mBannerTitleList = new ArrayList<>();
        mBannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        L.d("showBannerData" + bannerDataList.size());

        for (BannerData bannerData : bannerDataList) {
            mBannerTitleList.add(bannerData.getTitle());
            mBannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(mBannerImageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(10 * 200);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置点击事件
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                L.d("点击了轮播图" + (position + 1));
            }

        });

        //更新图片集和标题
        // mBanner.update(mBannerImageList, mBannerTitleList);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private MainListAdapter mAdapter;
    private List<FeedArticleData> mFeedArticleDataList;

    private void initRecyclerView(FeedArticleListData feedArticleListData) {
        mFeedArticleDataList = new ArrayList<FeedArticleData>();
        mAdapter = new MainListAdapter(mFeedArticleDataList);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                L.d("点击了条目");
             /*   Intent intent = new Intent(mActivity, ArticleDetailActivity.class);
                intent.putExtra(IntentKV.K_ARTICLE_ID, mFeedArticleDataList.get(position).getId());
                intent.putExtra(IntentKV.K_ARTICLE_TITLE, mFeedArticleDataList.get(position).getTitle());
                intent.putExtra(IntentKV.K_ARTICLE_LINK, mFeedArticleDataList.get(position).getLink());
                intent.putExtra(IntentKV.K_IS_COLLECT, mFeedArticleDataList.get(position).isCollect());
                intent.putExtra(IntentKV.K_IS_COLLECT_PAGE, false);
                intent.putExtra(IntentKV.K_IS_COMMON_SITE, false);
                // L.d("HomeFragment", "mTitle:"+mFeedArticleDataList.get(position).getTitle() + ",articleLink:"+mFeedArticleDataList.get(position).getLink());
                mActivity.startActivity(intent);*/
            }
        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                L.d("点击了子条目");
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        //添加头部banner
        LinearLayout mHeader = ((LinearLayout) LayoutInflater.from(mActivity).inflate(R.layout.test_main_banner, null));
        mBanner = ((Banner) mHeader.findViewById(R2.id.head_banner));
        mHeader.removeView(mBanner);
        mAdapter.addHeaderView(mBanner);
        mRecyclerView.setAdapter(mAdapter);
    }

}
