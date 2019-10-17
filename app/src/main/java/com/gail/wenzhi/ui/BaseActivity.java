package com.gail.wenzhi.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gail.wenzhi.R;
import com.gail.wenzhi.utils.ColorUtils;
import com.gail.wenzhi.utils.StatusBarUtils;

public class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }


    @Override
    public void setContentView(int view) {
        super.setContentView(view);
        getSupportActionBar().hide();
        // setStatusBar();
        StatusBarUtils.setWindowStatusBarColor(this, ColorUtils.toHexEncoding(getResources().getColor(R.color.colorPrimary)));
        setUpView();

    }


    protected void setUpView() {

    }


    protected void setStatusBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
