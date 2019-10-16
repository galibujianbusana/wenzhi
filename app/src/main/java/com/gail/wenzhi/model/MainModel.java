package com.gail.wenzhi.model;

import com.gail.wenzhi.Const.Cons;
import com.gail.wenzhi.api.ApiService;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.callback.MainCallBack;
import com.gail.wenzhi.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel {

    public static void getTouTiaoData(String type, final MainCallBack mainCallBack) {

        ApiService apiService = RetrofitHelper.getInstance().create(ApiService.class);
        Call<TopRootInfo> call = apiService.getTouTiaoData("top", Cons.TOU_TIAO_KEY);
        call.enqueue(new Callback<TopRootInfo>() {
            @Override
            public void onResponse(Call<TopRootInfo> call, Response<TopRootInfo> response) {

                mainCallBack.showSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TopRootInfo> call, Throwable t) {
                mainCallBack.shoError("请求失败!");
            }
        });
    }
}
