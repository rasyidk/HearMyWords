package com.app.hearmywords.ui.learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;


import com.app.hearmywords.databinding.FragmentLearnBinding;
import com.google.android.material.tabs.TabLayout;

public class LearnFragment extends Fragment {

    private FragmentLearnBinding binding;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MyFragmentAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LearnViewModel learnViewModel =
                new ViewModelProvider(this).get(LearnViewModel.class);

        binding = FragmentLearnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tabLayout = binding.tabLayout;
        viewPager2 = binding.viewPager2;

        tabLayout.addTab(tabLayout.newTab().setText("MODULE"));
        tabLayout.addTab(tabLayout.newTab().setText("VIDEO"));

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        adapter = new MyFragmentAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static class MainModel {

        Integer thumbNail;
        String judul;
        String link;
        String duration;
        String level;

        public MainModel(Integer thumbNail, String judul, String link, String duration, String level) {
            this.thumbNail = thumbNail;
            this.judul = judul;
            this.link = link;
            this.duration = duration;
            this.level = level;
        }

        public Integer getThumbNail() {
            return thumbNail;
        }

        public void setThumbNail(Integer thumbNail) {
            this.thumbNail = thumbNail;
        }

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}