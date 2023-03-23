package com.app.hearmywords.ui.learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.app.hearmywords.R;

import java.util.ArrayList;

public class LearnViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LearnViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public static class MainAdapter extends  RecyclerView.Adapter<MainAdapter.ViewHolder>{
        ArrayList<LearnFragment.MainModel> mainModels;
        Context context;



        public MainAdapter(Context context, ArrayList<LearnFragment.MainModel> mainModels){
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


            holder.imageView.setImageResource(mainModels.get(position).getThumbNail());
            holder.tv_judul.setText(mainModels.get(position).getJudul());
            holder.tv_durasi.setText(mainModels.get(position).getDuration());
            holder.tv_level.setText(mainModels.get(position).getLevel());
        }

        @Override
        public int getItemCount() {
            return mainModels.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView tv_judul, tv_durasi, tv_level;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.video__img_thumbnail);
                tv_judul = itemView.findViewById(R.id.video__tv_judul);
                tv_durasi = itemView.findViewById(R.id.video__tv_durasi);
                tv_level = itemView.findViewById(R.id.video__tv_level);


            }
        }


    }
}