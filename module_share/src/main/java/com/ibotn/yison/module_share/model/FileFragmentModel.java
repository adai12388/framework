package com.ibotn.yison.module_share.model;

import android.content.Context;

import com.framework.yison.component_base.base.mvp.DisposablePool;
import com.ibotn.yison.module_share.bean.ShareFileBean;
import com.ibotn.yison.module_share.contract.IFileFragmentContract;
import com.ibotn.yison.module_share.utils.FileUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class FileFragmentModel extends DisposablePool implements IFileFragmentContract.Model {

    private Context context = null;

    public FileFragmentModel(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<ShareFileBean>> loadFile(boolean isRefresh, int page, int type) {
        Observable<List<ShareFileBean>> Observable = io.reactivex.Observable.create(new ObservableOnSubscribe<List<ShareFileBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ShareFileBean>> e) throws Exception {

                List<ShareFileBean> list = FileUtils.getShareFiles(context, type);

                e.onNext(list);
                e.onComplete();
            }
        });
        return Observable;
    }

}
