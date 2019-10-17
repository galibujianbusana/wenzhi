package com.gail.wenzhi.presenter;

import android.util.Log;

import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.callback.HomeCallBack;
import com.gail.wenzhi.model.HomeModel;
import com.gail.wenzhi.view.HomeView;

public class HomePresenter {


    private static final String TAG = "MainPresenter";

    private HomeView view;

    public HomePresenter(HomeView view){
        this.view = view;
    }

    public void  getTouTiaoData(String type){

        Log.d(TAG, "getTouTiaoData: ");

        HomeModel.getTouTiaoData(type, new HomeCallBack() {
            @Override
            public void showProgressDialog() {
                view.showProgressDialog();
            }

            @Override
            public void hideProgressDialog() {
                view.hideProgressDialog();
            }

            @Override
            public void showSuccess(TopRootInfo data) {
                view.showSuccessData(data);
            }

            @Override
            public void shoError(String s) {
                view.showErrorData(s);
            }
        });
    }


}
