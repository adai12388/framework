package com.ibotntest.moduletest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.framework.yison.component_base.base.mvp.BaseVpListFragment;
import com.framework.yison.component_base.util.L;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.adapter.FamousFragmentAdapter;
import com.ibotntest.moduletest.contract.FamousFragmentContract;
import com.ibotntest.moduletest.presenter.FamousFragmentPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class FamousFragment extends BaseVpListFragment<FamousFragmentContract.View, FamousFragmentContract.Presenter> implements FamousFragmentContract.View {
    @BindView(R.id.test_recyclerView)
    RecyclerView testRecyclerView;
    @BindView(R.id.test_smartRefreshLayout)
    SmartRefreshLayout testSmartRefreshLayout;

    private BaseQuickAdapter adapter;


    private static final String TAG = FamousFragment.class.getSimpleName();

    @Override
    protected int getLayout() {
        return R.layout.test_fragment_famous;
    }

    @Override
    protected void initTitle() {

    }
    private ArrayList data;
    @Override
    protected void initView() {
        rlRefreshLayout = testSmartRefreshLayout;
        super.initView();
        regEvent = true;


        data = new ArrayList();
        for (int i = 0; i < 20; i++) {
            data.add("123");
            data.add("yison");
        }
        adapter = new FamousFragmentAdapter(R.layout.test_item_yison,data);
        testRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        testRecyclerView.setAdapter(adapter);

     /*   //添加头部banner
        LinearLayout mHeader = ((LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.test_head, null));
        mTextRefreshing = ((TextView) mHeader.findViewById(R.id.tv_refreshing));
        mHeader.removeView(mTextRefreshing);
        adapter.addHeaderView(mTextRefreshing);*/

    }

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        L.d(TAG, "yison loadListData pageSize " + pageSize + " isRefresh " + isRefresh + " page = " + page);
        mPresenter.FeedArticleList(isRefresh,rlRefreshLayout,page);
    }


    @Override
    public FamousFragmentContract.Presenter createPresenter() {
        return new FamousFragmentPresenter();
    }

    @Override
    public FamousFragmentContract.View createView() {
        return this;
    }

}
