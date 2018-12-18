package com.framework.yison.module_shop_mall.bean;

import com.framework.yison.component_data.bean.BaseResponse;

/**
 * @author quchao
 * @date 2018/2/12
 */

public class FeedArticleListResponse extends BaseResponse {

    private FeedArticleListData data;

    public FeedArticleListData getData() {
        return data;
    }

    public void setData(FeedArticleListData data) {
        this.data = data;
    }
}
