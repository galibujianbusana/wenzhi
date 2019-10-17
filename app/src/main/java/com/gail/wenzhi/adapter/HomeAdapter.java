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
import com.gail.wenzhi.bean.TopRootInfo;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {


    private List<TopRootInfo.Data> data;

    private Context context;

    public HomeAdapter(List<TopRootInfo.Data> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_item,parent,false);
        final Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TopRootInfo.Data  dataItem = data.get(position);
        holder.titleAuthorName.setText(dataItem.getAuthor_name());
        holder.tvTitle.setText(dataItem.getTitle());
        Glide.with(context).load(dataItem.getThumbnail_pic_s()).into(holder.img1);
        Glide.with(context).load(dataItem.getThumbnail_pic_s02()).into(holder.img2);
        Glide.with(context).load(dataItem.getThumbnail_pic_s03()).into(holder.img3);
        holder.relative.setOnClickListener( v->{
            if(onItemListener!= null){
                onItemListener.onClick(dataItem.getUrl());
            }
        });
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView titleAuthorName, tvTitle;

        ImageView img1, img2, img3;

        View item;

        RelativeLayout relative;

        public Holder(@NonNull View itemView) {
            super(itemView);
            item = itemView;
            titleAuthorName = itemView.findViewById(R.id.titleAuthorName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            img3 = itemView.findViewById(R.id.img3);
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
