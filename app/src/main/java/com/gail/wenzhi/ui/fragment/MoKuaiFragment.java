package com.gail.wenzhi.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.gail.wenzhi.Const.Cons;
import com.gail.wenzhi.R;
import com.gail.wenzhi.adapter.MoKAdapter;
import com.gail.wenzhi.ui.BaseFragment;
import com.gail.wenzhi.ui.UiControllerUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoKuaiFragment extends BaseFragment {


    private View rtView;
    private GridView listView;
    private MoKAdapter adapter;

    public MoKuaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rtView = inflater.inflate(R.layout.fragment_mo_kuai, container, false);
        return  super.onCreateView(rtView);
    }

    @Override
    public void setupView() {
        super.setupView();
        listView = rtView.findViewById(R.id.listView);
        List<String> data = new ArrayList<>(Arrays.asList(Cons.MOKUAI));
        adapter = new MoKAdapter(data,getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String type = Cons.MOKUAI[i];
            String name = MoKAdapter.MOKUAI_NAME[i];
            UiControllerUtil.getInstance().homeFragment.updateType(type,name);
            UiControllerUtil.getInstance().changeFragment(UiControllerUtil.HOME_TAG,getActivity());

        });
    }
}
