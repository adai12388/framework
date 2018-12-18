package com.ibotntest.moduletest.api;

import com.framework.yison.component_base.net.HttpHelper;
import com.framework.yison.component_base.util.RxUtils;
import com.framework.yison.component_data.bean.BaseObj;

import io.reactivex.Observable;

public class ModelVpService {


    /**
     * 获取api的回调
     * @param <T>
     */
    public interface MethodSelect<T>{

        Observable<BaseObj<T>> selectM(ApiService service);
    }

    public static <T> Observable<BaseObj<T>> getRemoteDataVp(MethodSelect<T> select) {
        //设置不同的BaseUrl
        return select.selectM(HttpHelper.getDefault(1)
                .create(ApiService.class))
                .compose(RxUtils.<BaseObj<T>>rxSchedulerHelper())
                ;
//                .subscribeWith(new BaseVpObserver<BaseObj<T>>() {
//                                   @Override
//                                   protected void onNextSuccess(BaseObj<T> tBaseObj) {
//
//                                       callback.onSuccess(tBaseObj.getData());
//                                   }
//                               }
//                );
    }
}
