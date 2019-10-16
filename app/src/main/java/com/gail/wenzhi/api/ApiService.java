package com.gail.wenzhi.api;

import com.gail.wenzhi.bean.TopRootInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("index")
    Call<TopRootInfo> getTouTiaoData(@Query("type") String type, @Query("key") String key);

}
