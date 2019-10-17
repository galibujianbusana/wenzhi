package com.gail.wenzhi.ui.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gail.wenzhi.R;
import com.gail.wenzhi.adapter.HomeAdapter;
import com.gail.wenzhi.bean.TopRootInfo;
import com.gail.wenzhi.presenter.HomePresenter;
import com.gail.wenzhi.presenter.MainPresenter;
import com.gail.wenzhi.ui.BaseFragment;
import com.gail.wenzhi.ui.UiControllerUtil;
import com.gail.wenzhi.view.HomeView;
import com.gail.wenzhi.view.MainView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeView,SwipeRefreshLayout.OnRefreshListener {


    private static final String TAG = "HomeFragment";
    private View rtView;
    private RecyclerView recycle;
    private List<TopRootInfo.Data> data = new ArrayList<>();
    private HomeAdapter adapter;
    private HomePresenter homePresenter;
    private SwipeRefreshLayout swipe;
    private AVLoadingIndicatorView avi;
    private RelativeLayout layoutError;
    private TextView tvTitle;
    public  static String  curUrl;
    private static String TITLE_NAME ="顾远";
    private static String TYPE = "top";
    public HomeFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rtView = inflater.inflate(R.layout.fragment_home, container, false);
        return super.onCreateView(rtView);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setupView() {
        super.setupView();
        tvTitle = rtView.findViewById(R.id.tvTitle);
        recycle = rtView.findViewById(R.id.recycle);
        swipe = rtView.findViewById(R.id.swipe);
        avi = rtView.findViewById(R.id.avi);
        layoutError = rtView.findViewById(R.id.layoutError);
        swipe.setOnRefreshListener(this);
        homePresenter = new HomePresenter(this);
        updateType(TYPE,TITLE_NAME);
        adapter = new HomeAdapter(data,getContext());
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle.setAdapter(adapter);
        adapter.setOnItemListener(url -> {
            curUrl = url;
            UiControllerUtil.getInstance().changeFragment(UiControllerUtil.HOME_ITEM_TAG,getActivity());
        });


    }

    @Override
    public void showSuccessData(TopRootInfo date) {

        Log.d(TAG,"callback! success! " +date.toString());
        int code = date.getError_code();
        if(code == 10012){
            layoutError.setVisibility(View.VISIBLE);
            swipe.setRefreshing(false);
        }else{
            try {
                data.clear();
                data.addAll(date.getResult().getData());
                adapter.notifyDataSetChanged();
                swipe.setRefreshing(false);
                layoutError.setVisibility(View.GONE);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void showErrorData(String s) {
        layoutError.setVisibility(View.VISIBLE);
        swipe.setRefreshing(false);
    }

    @Override
    public void showProgressDialog() {
      //  avi.setVisibility(View.VISIBLE);
        //layoutError.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressDialog() {
       // avi.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh() {
        homePresenter.getTouTiaoData(TYPE);
    }

    public void updateType(String type,String name){
        TITLE_NAME = name;
        tvTitle.setText(TITLE_NAME);
        TYPE = type;
        homePresenter.getTouTiaoData(TYPE);

    }
}
