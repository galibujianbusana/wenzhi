package com.gail.wenzhi.presenter;

import com.gail.wenzhi.base.BasePresenter;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.callback.MainCallBack;
import com.gail.wenzhi.model.MainModel;
import com.gail.wenzhi.view.MainView;

public class MainPresenter implements BasePresenter {

    private MainView view;

    public MainPresenter(MainView view){
        this.view = view;
    }

    public void  getTouTiaoData(){

        MainModel.getTouTiaoData("top", new MainCallBack() {
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
