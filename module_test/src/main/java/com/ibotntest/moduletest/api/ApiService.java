package com.ibotntest.moduletest.api;

import com.framework.yison.component_data.bean.BaseObj;
import com.ibotntest.moduletest.bean.BannerData;
import com.ibotntest.moduletest.bean.FeedArticleListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("banner/json")
    Observable<BaseObj<List<BannerData>>> getBannerData();

    @GET("article/list/{num}/json")
    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(@Path("num") int num);
}
