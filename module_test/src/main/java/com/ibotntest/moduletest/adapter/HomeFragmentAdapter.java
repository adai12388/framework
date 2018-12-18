package com.ibotntest.moduletest.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ibotntest.moduletest.R;
import com.ibotntest.moduletest.bean.HomefragmentBean;

import java.util.List;

public class HomeFragmentAdapter extends BaseQuickAdapter<HomefragmentBean, BaseViewHolder> {
    public HomeFragmentAdapter(int layoutResId, @Nullable List<HomefragmentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomefragmentBean item) {
        helper.setText(R.id.nav_name,item.getName());
        helper.setImageResource(R.id.img_head,R.drawable.ic_camera);
    }


}
