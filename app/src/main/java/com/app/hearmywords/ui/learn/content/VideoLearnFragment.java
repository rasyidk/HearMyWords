package com.app.hearmywords.ui.learn.content;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.hearmywords.R;
import com.app.hearmywords.databinding.FragmentLearnBinding;
import com.app.hearmywords.databinding.FragmentVideoLearnBinding;
import com.app.hearmywords.ui.learn.LearnViewModel;

import java.util.ArrayList;


public class VideoLearnFragment extends Fragment {

    private FragmentVideoLearnBinding binding;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LearnViewModel learnViewModel =
                new ViewModelProvider(this).get(LearnViewModel.class);

        binding = FragmentVideoLearnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.videoRv;


        Integer[] thumbnail = {R.drawable.promo, R.drawable.rasyid};
        String[] judul = {"Judul 1", "Judul 1"};
        String[] duration = {"Duration 1", "Duration 2"};
        String[] level = {"beginner", "intermediatie"};
        String[] link = {"link 1", "link 2"};

        mainModels = new ArrayList<>();

        for(int i=0; i< thumbnail.length;i++){
            MainModel model = new MainModel(thumbnail[i],judul[i],duration[i],level[i], link[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false
        );

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(getActivity(), mainModels);

        recyclerView.setAdapter(mainAdapter);

        return root;
    }
}