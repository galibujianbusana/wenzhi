package com.gail.wenzhi.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gail.wenzhi.R;
import com.gail.wenzhi.base.BaseActivity;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.presenter.MainPresenter;
import com.gail.wenzhi.view.MainView;

public class MainActivity extends BaseActivity implements MainView {


    private TextView tv;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setContentView(View view) {
        super.setContentView(R.layout.activity_main);
    }

    @Override
    protected void setUpView() {
        tv =findViewById(R.id.tv);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getTouTiaoData();

    }

    @Override
    public void showSuccessData(TopRootInfo date) {
        tv.setText(date.getResult().getData().toString());
    }

    @Override
    public void showErrorData(String s) {
        tv.setText(s);
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }
}
