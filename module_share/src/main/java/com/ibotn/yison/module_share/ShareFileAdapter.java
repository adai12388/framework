package com.ibotn.yison.module_share;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ibotn.yison.module_share.bean.ShareFileBean;

import java.util.List;

public class ShareFileAdapter extends BaseQuickAdapter<ShareFileBean,BaseViewHolder> {

    public ShareFileAdapter(int layoutResId, @Nullable List<ShareFileBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShareFileBean item) {
        helper.setImageResource(R.id.img_icon,item.getFleTyeIconId());
        helper.setText(R.id.tv_name,item.getFileName());
    }
}
