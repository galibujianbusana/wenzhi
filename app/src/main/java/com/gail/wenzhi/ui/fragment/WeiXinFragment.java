package com.gail.wenzhi.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.gail.wenzhi.R;
import com.gail.wenzhi.adapter.WeatherAdapter;
import com.gail.wenzhi.bean.WeatherInfo;
import com.gail.wenzhi.presenter.WeatherPresenter;
import com.gail.wenzhi.ui.BaseFragment;
import com.gail.wenzhi.view.WeatherView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeiXinFragment extends BaseFragment implements WeatherView {


    private View rtView;

    private RecyclerView recycle;

    private WeatherAdapter adapter;

    private WeatherPresenter weatherPresenter;

    private List<WeatherInfo.Future> data = new ArrayList<>();

    private SearchView searchView;

    public WeiXinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rtView = inflater.inflate(R.layout.fragment_wei_xin, container, false);
        return super.onCreateView(rtView);
    }

    @Override
    public void setupView() {
        super.setupView();
        recycle = rtView.findViewById(R.id.recycle);
        weatherPresenter = new WeatherPresenter(this);
        weatherPresenter.getWeatherData("上海");
        adapter = new WeatherAdapter(data, getContext());
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle.setAdapter(adapter);
        searchView = rtView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(s.trim().length() > 0){
                    weatherPresenter.getWeatherData(s);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }

    @Override
    public void showSuccessData(WeatherInfo date) {
        try {
            data.clear();
            data.addAll(date.getResult().getFuture());
            adapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void showErrorData(String s) {

    }
}
