package com.gail.wenzhi.utils;

import com.gail.wenzhi.Const.Cons;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {


    private static Retrofit retrofit;

    private static Retrofit retrofit2;

    private static OkHttpClient okHttpClient;


    public static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (RetrofitHelper.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Cons.BASE_TOU_TIAO)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

    public static Retrofit getWeatherInstance() {
        if (retrofit2 == null) {
            synchronized (RetrofitHelper.class) {
                if (retrofit2 == null) {
                    retrofit2 = new Retrofit.Builder()
                            .baseUrl(Cons.TIAN_QI_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit2;
    }

    private static OkHttpClient getOkHttpClient(){

        if(okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
}
