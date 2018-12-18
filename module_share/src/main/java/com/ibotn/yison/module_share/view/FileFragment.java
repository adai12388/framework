package com.ibotn.yison.module_share.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.framework.yison.component_base.base.mvp.BaseVpListFragment;
import com.framework.yison.component_base.util.L;
import com.ibotn.yison.module_share.R;
import com.ibotn.yison.module_share.ShareFileAdapter;
import com.ibotn.yison.module_share.bean.ShareFileBean;
import com.ibotn.yison.module_share.contract.IFileFragmentContract;
import com.ibotn.yison.module_share.presenter.FileFragmentPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;

public class FileFragment extends BaseVpListFragment<IFileFragmentContract.View, IFileFragmentContract.Presenter> implements IFileFragmentContract.View ,ShareFileAdapter.OnItemClickListener {
    private static final String TAG = FileFragment.class.getSimpleName();
    public static final byte TYPE_VIDEO = 0x0;
    public static final byte TYPE_AUDIO = 0x1;
    public static final byte TYPE_PICTURE = 0x2;
    public static final byte TYPE_DUCMENT = 0x3;
    public static final byte TYPE_OTHER = 0x4;
    @BindView(R.id.share_recyclerView)
    RecyclerView shareRecyclerView;
    @BindView(R.id.share_refreshLayout)
    SmartRefreshLayout shareRefreshLayout;
    private ShareFileAdapter adapter;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte type = TYPE_VIDEO;

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        L.e(TAG, "yison loadListData isRefresh " + isRefresh + " type " + type);
        mPresenter.loadFile(isRefresh, rlRefreshLayout, page, type);
    }

    public static FileFragment newInstance(byte type) {
        FileFragment fileFragment = new FileFragment();
        fileFragment.setType(type);

        Bundle bundle = new Bundle();
        bundle.putByte("type",type);

        return fileFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
            type = savedInstanceState.getByte("type");
    }

    @Override
    protected void initView() {
        rlRefreshLayout = shareRefreshLayout;
        super.initView();
        regEvent = true;

        adapter = new ShareFileAdapter(R.layout.share_item_video,null);
        shareRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shareRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.share_fragment_filelist;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public IFileFragmentContract.Presenter createPresenter() {
        return new FileFragmentPresenter();
    }

    @Override
    public IFileFragmentContract.View createView() {
        return this;
    }

    @Override
    public void showArticleList(List<ShareFileBean> shareFileBean) {
        adapter.setNewData(shareFileBean);
    }

    @Override
    public void initImmersionBar() {

    }

    @Override
    public boolean immersionBarEnabled() {
        return false;
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ShareFileBean bean = (ShareFileBean)(adapter.getData().get(position));
        String filePath = bean.getFilePath();
        L.e(TAG,"yison onItemClick position "+position + " bean "+bean);
        String type = "video";
        switch (bean.getFleTyeIconId())
        {
            case R.mipmap.ic_vedio:
                type = "video";
                break;
            case R.mipmap.ic_audio:
                type = "audio";
                break;
            case R.mipmap.ic_picture:
                type = "image";
                break;
            case R.mipmap.ic_file:
                type = "*";
                break;
            case R.mipmap.ic_other:
                type = "*";
                break;

        }

        //播放视频
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("file://" + filePath);
        intent.setDataAndType(uri, type + "/*");
        startActivity(intent);
    }
}
