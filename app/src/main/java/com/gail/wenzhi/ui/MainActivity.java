package com.gail.wenzhi.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.gail.wenzhi.R;
import com.gail.wenzhi.base.BaseActivity;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.presenter.MainPresenter;
import com.gail.wenzhi.view.MainView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements MainView {

    private static final String TAG = "MainActivity";

    private TextView tv;
    private MainPresenter mainPresenter;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
      
    }


    @Override
    public void setContentView(int view) {
        super.setContentView(view);
        Log.d(TAG, "setContentView: ");
    }

    @Override
    protected void setUpView() {
        Log.d(TAG, "setUpView: ");
        tv =findViewById(R.id.tv);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getTouTiaoData();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               if(menuItem.getTitle().toString().equals("选项一")){
                   Log.d(TAG, "onNavigationItemSelected: 1");
               }else if(menuItem.getTitle().toString().equals("选项二")){
                   Log.d(TAG, "onNavigationItemSelected: 2");
               }else if(menuItem.getTitle().toString().equals("选项三")){
                   Log.d(TAG, "onNavigationItemSelected: 3");
               }
                return true;
            }
        });

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
