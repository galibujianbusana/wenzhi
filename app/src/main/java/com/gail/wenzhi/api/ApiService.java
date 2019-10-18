package com.gail.wenzhi.api;

import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.bean.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("index")
    Call<TopRootInfo> getTouTiaoData(@Query("type") String type, @Query("key") String key);

    @GET("query")
    Call<WeatherInfo> getWeatherData(@Query("city") String type, @Query("key") String key);
}
