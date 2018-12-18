package com.ibotntest.moduletest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ibotntest.moduletest.R;

import java.util.List;

public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public TestAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.nav_name,item);
    }
}
