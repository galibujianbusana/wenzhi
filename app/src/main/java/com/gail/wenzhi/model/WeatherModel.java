package com.gail.wenzhi.model;

import android.util.Log;

import com.gail.wenzhi.Const.Cons;
import com.gail.wenzhi.api.ApiService;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.bean.WeatherInfo;
import com.gail.wenzhi.callback.WeatherCallBack;
import com.gail.wenzhi.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherModel {

    private static final String TAG = "MainModel";

    public static void getWeatherData(String type, final WeatherCallBack weatherCallBack) {

        ApiService apiService = RetrofitHelper.getWeatherInstance().create(ApiService.class);

        Call<WeatherInfo> call = apiService.getWeatherData(type, Cons.TIAN_QI_KEY);

        //weatherCallBack.showProgressDialog();

        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {

                Log.d(TAG, "onResponse: 成功！");
                weatherCallBack.hideProgressDialog();
                weatherCallBack.showSuccess(response.body());

            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Log.d(TAG, "onResponse: 失败！");
                weatherCallBack.hideProgressDialog();
                weatherCallBack.shoError("请求失败!");
            }
        });
    }
}

