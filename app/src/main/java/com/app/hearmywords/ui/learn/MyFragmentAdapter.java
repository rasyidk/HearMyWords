package com.app.hearmywords.ui.learn;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.hearmywords.ui.learn.content.ModuleLearnFragment;
import com.app.hearmywords.ui.learn.content.VideoLearnFragment;

public class MyFragmentAdapter extends FragmentStateAdapter {

    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return  new VideoLearnFragment();
        }
        return  new ModuleLearnFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
