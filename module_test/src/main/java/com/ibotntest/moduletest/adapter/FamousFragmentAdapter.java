package com.ibotntest.moduletest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.bean.HomefragmentBean;

import java.util.List;

public class FamousFragmentAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public FamousFragmentAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.nav_name,item);
        helper.setImageResource(R.id.img_head,R.drawable.ic_camera);
    }


}
