package com.example.mobile.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mobile.model.User;

public class ResultsFragmentStateAdapter extends FragmentStateAdapter {

    Context mContext;
    boolean forHome;

    public ResultsFragmentStateAdapter(@NonNull Fragment fragment, Context context, boolean forHome) {
        super(fragment);
        mContext = context;
        this.forHome = forHome;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putBoolean("forHome", forHome);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        if (forHome)
            return User.getInstance().getFilteredListings().size();
        else
            return User.getInstance().getSavedListings().size();
    }
}
