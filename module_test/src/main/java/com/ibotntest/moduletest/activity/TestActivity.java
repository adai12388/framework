package com.ibotntest.moduletest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.adapter.TestAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TestActivity extends Activity {
    @BindView(R.id.test_recyclerView)
    RecyclerView testRecyclerView;
    @BindView(R.id.test_smartRefreshLayout)
    SmartRefreshLayout testSmartRefreshLayout;
    private static final String TAG = TestActivity.class.getSimpleName();

    Unbinder unbinder;

    private BaseQuickAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_test_activity);
        unbinder = ButterKnife.bind(this);

        initViews();
    }

    private ArrayList<String> data;

    private void initViews() {
        testSmartRefreshLayout.autoRefresh();
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("123");
            data.add("yison");
        }
        adapter = new TestAdapter(R.layout.test_item_yison, data);
        testRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        testRecyclerView.setAdapter(adapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
