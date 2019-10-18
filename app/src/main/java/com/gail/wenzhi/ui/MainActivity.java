package com.gail.wenzhi.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gail.wenzhi.R;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.view.MainView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class MainActivity extends BaseActivity implements MainView {

    private static final String TAG = "MainActivity";

    private TextView tv;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        UiControllerUtil.getInstance().changeFragment(UiControllerUtil.HOME_TAG,this);
      
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

        navigationView = findViewById(R.id.nav_view);
        navigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        navigationView.setOnNavigationItemSelectedListener(menuItem -> {
           if(menuItem.getTitle().toString().equals(getString(R.string.title_home))){
               UiControllerUtil.getInstance().homeFragment.updateType("top","顾远");
               UiControllerUtil.getInstance().changeFragment(UiControllerUtil.HOME_TAG,MainActivity.this);
             UiControllerUtil.getInstance().changeFragment(UiControllerUtil.HOME_TAG,MainActivity.this);
           }else if(menuItem.getTitle().toString().equals(getString(R.string.title_mokuai))){
               UiControllerUtil.getInstance().changeFragment(UiControllerUtil.MOKUAI_TAG,MainActivity.this);
           }else if(menuItem.getTitle().toString().equals(getString(R.string.title_msg))){
               UiControllerUtil.getInstance().changeFragment(UiControllerUtil.WEIXIN_TAG,MainActivity.this);
           }else if(menuItem.getTitle().toString().equals(getString(R.string.title_setting))){
               UiControllerUtil.getInstance().changeFragment(UiControllerUtil.SETTING_TAG,MainActivity.this);
           }
            return true;
        });

    }

    @Override
    public void showSuccessData(TopRootInfo date) {
       // tv.setText(date.getResult().getData().toString());
    }

    @Override
    public void showErrorData(String s) {
      //  tv.setText(s);
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }
}
