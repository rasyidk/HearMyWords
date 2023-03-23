package com.app.hearmywords.ui.learn.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.hearmywords.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<MainModel> mainModels;
    Context context;



    public MainAdapter(Context context, ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        holder.imageView.setImageResource(mainModels.get(position).getLangLogo());
//        holder.tv_menu.setText(mainModels.get(position).getLangName());
//        holder.tv_desc.setText(mainModels.get(position).getLangDesc());
//        holder.tv_rating.setText(mainModels.get(position).getLangRating());

        holder.img_thumbnail.setImageResource(mainModels.get(position).getThumbnail());
        holder.tv_judul.setText(mainModels.get(position).getJudul());
        holder.tv_duration.setText(mainModels.get(position).getDuration());
        holder.tv_level.setText(mainModels.get(position).getLevel());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_thumbnail;
        TextView tv_judul, tv_duration, tv_level;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_thumbnail = itemView.findViewById(R.id.video__img_thumbnail);
            tv_judul = itemView.findViewById(R.id.video__tv_judul);
            tv_duration = itemView.findViewById(R.id.video__tv_durasi);
            tv_level = itemView.findViewById(R.id.video__tv_level);

//            imageView = itemView.findViewById(R.id.home_menu_image);
//            tv_menu = itemView.findViewById(R.id.home_menu_utama);
//            tv_desc = itemView.findViewById(R.id.home_menu_desc);
//            tv_rating = itemView.findViewById(R.id.home_menu_rating);
        }
    }
}