package com.ibotntest.moduletest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ibotntest.moduletest.bean.FeedArticleData;
import com.ibotntest.moduletest.bean.FeedArticleListData;

import java.util.List;

public class MainListAdapter extends BaseQuickAdapter<FeedArticleData,BaseViewHolder>
{


    public MainListAdapter(int layoutResId, @Nullable List<FeedArticleData> data) {
        super(layoutResId, data);
    }

    public MainListAdapter(@Nullable List<FeedArticleData> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FeedArticleData item) {

    }

}
