package com.example.mobile.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ResultsFragmentStateAdapter extends FragmentStateAdapter {

    Context mContext;
    final int LARGE_SIZE=5;

    public ResultsFragmentStateAdapter(@NonNull Fragment fragment, Context context) {
        super(fragment);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return LARGE_SIZE;
    }
}
