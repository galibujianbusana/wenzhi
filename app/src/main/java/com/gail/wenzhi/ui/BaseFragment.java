package com.gail.wenzhi.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gail.wenzhi.R;
import com.gail.wenzhi.base.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements BaseView {


    public BaseFragment() {
        // Required empty public constructor
    }


    public View onCreateView(View view) {

        setupView();
        return  view;
    }

    public void setupView(){

    }

    @Override
    public void showProgressDialog() {
       // showProgressDialog();
    }

    @Override
    public void hideProgressDialog() {
       // hideProgressDialog();
    }
}
