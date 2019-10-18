package com.gail.wenzhi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gail.wenzhi.R;
import com.gail.wenzhi.bean.WeatherInfo;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.Holder> {


    private List<WeatherInfo.Future> data;

    private Context context;

    public WeatherAdapter(List<WeatherInfo.Future> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.weather_item,parent,false);
        final Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        WeatherInfo.Future  dataItem = data.get(position);
        holder.tvTime.setText(dataItem.getDate());
        holder.tvTemper.setText(dataItem.getTemperature());
        holder.tvF.setText(dataItem.getDirect());
        holder.tvWeather.setText(dataItem.getWeather());

        Glide.with(context).load(R.drawable.w_qing).into(holder.img);
        holder.relative.setOnClickListener( v->{
            if(onItemListener!= null){
               // onItemListener.onClick(dataItem.getUrl());
            }
        });
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvTemper, tvWeather,tvTime,tvF;

        ImageView img;

        View item;

        RelativeLayout relative;

        public Holder(@NonNull View itemView) {
            super(itemView);
            item = itemView;
            tvTemper = itemView.findViewById(R.id.tvTemper);
            tvWeather = itemView.findViewById(R.id.tvWeather);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvF = itemView.findViewById(R.id.tvF);
            img = itemView.findViewById(R.id.img);
            relative = itemView.findViewById(R.id.relative);
        }
    }


    private OnItemListener onItemListener;

    public void setOnItemListener(OnItemListener onItemListener){
        this.onItemListener = onItemListener;
    }

    public interface OnItemListener{
        void onClick(String url);
    }
}
