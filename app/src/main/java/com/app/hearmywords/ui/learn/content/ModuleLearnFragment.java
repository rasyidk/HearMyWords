package com.app.hearmywords.ui.learn.content;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.hearmywords.R;
import com.app.hearmywords.VoiceTestActivity;
import com.app.hearmywords.databinding.FragmentModuleLearnBinding;
import com.app.hearmywords.databinding.FragmentVideoLearnBinding;
import com.app.hearmywords.ui.learn.LearnViewModel;

import java.util.ArrayList;


public class ModuleLearnFragment extends Fragment {

    private FragmentModuleLearnBinding binding;
    private CardView cv_alphabet,cv_action;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LearnViewModel learnViewModel =
                new ViewModelProvider(this).get(LearnViewModel.class);

        binding = FragmentModuleLearnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        cv_alphabet = binding.moduleCvAlphabet;
        cv_action = binding.moduleCvAction;

        cv_alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VoiceTestActivity.class);
                intent.putExtra("type","alphabet");
                startActivity(intent);
            }
        });

        cv_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VoiceTestActivity.class);
                intent.putExtra("type","action");
                startActivity(intent);
            }
        });



        return root;
    }
}