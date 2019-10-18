package com.gail.wenzhi.presenter;

import android.util.Log;

import com.gail.wenzhi.bean.WeatherInfo;
import com.gail.wenzhi.callback.WeatherCallBack;
import com.gail.wenzhi.model.WeatherModel;
import com.gail.wenzhi.view.WeatherView;

public class WeatherPresenter {


    private static final String TAG = "MainPresenter";

    private WeatherView view;

    public WeatherPresenter(WeatherView view){
        this.view = view;
    }

    public void  getWeatherData(String city){


        WeatherModel.getWeatherData(city, new WeatherCallBack() {
            @Override
            public void showProgressDialog() {
                view.showProgressDialog();
            }

            @Override
            public void hideProgressDialog() {
                view.hideProgressDialog();
            }

            @Override
            public void showSuccess(WeatherInfo data) {
                Log.d("TAGW: " , data.toString());
                view.showSuccessData(data);
            }

            @Override
            public void shoError(String s) {
                view.showErrorData(s);
            }
        });
    }
}
