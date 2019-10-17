package com.gail.wenzhi.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;

import com.gail.wenzhi.R;
import com.gail.wenzhi.ui.BaseFragment;
import com.gail.wenzhi.ui.UiControllerUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeItemFragment extends BaseFragment {


    private View rtView;
    private WebView webView;

    public HomeItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rtView = inflater.inflate(R.layout.fragment_home_item, container, false);
        return super.onCreateView(rtView);
    }

    @Override
    public void setupView() {
        super.setupView();
        webView = rtView.findViewById(R.id.webView);
        rtView.findViewById(R.id.imgBack).setOnClickListener(view -> {
            UiControllerUtil.getInstance().changeFragment(UiControllerUtil.HOME_TAG,getActivity());
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (webView != null && !hidden) {
            webView.loadUrl(HomeFragment.curUrl);
        }
    }
}
