package com.gail.wenzhi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gail.wenzhi.Const.Cons;
import com.gail.wenzhi.R;

import java.util.List;

public class MoKAdapter  extends BaseAdapter {

    public static String [] MOKUAI_NAME = { "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"};


    List<String> data;

    Context context;

    public MoKAdapter(List<String> name, Context context) {
        this.data = name;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HolderMK holder;
        if(view == null){
            holder = new HolderMK();
            view = View.inflate(context, R.layout.mokuai_item,null);
            holder.img = view.findViewById(R.id.img);
            holder.tvName = view.findViewById(R.id.tvName);
            view.setTag(holder);
        }else{
            holder = (HolderMK) view.getTag();
        }
        holder.tvName.setText(MOKUAI_NAME[i]);
        Glide.with(context).load(context.getResources().getDrawable(Cons.MOKUAIIMG[i])).into(holder.img);

        return view;
    }

    class HolderMK {

        ImageView img;

        TextView tvName;

    }
}
