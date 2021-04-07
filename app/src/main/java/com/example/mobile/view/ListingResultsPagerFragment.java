package com.example.mobile.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListingResultsPagerFragment extends Fragment {

    ViewPager2 resultsViewPager;
    private int index;
    boolean forHome;


    public ListingResultsPagerFragment() {
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setForHome(boolean forHome) {
        this.forHome = forHome;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_results_pager, container, false);

        final ResultsFragmentStateAdapter resultsFragmentStateAdapter = new ResultsFragmentStateAdapter(this, getContext(), forHome);
        resultsViewPager = view.findViewById(R.id.resultsViewPager);
        resultsViewPager.setAdapter(resultsFragmentStateAdapter);
        resultsViewPager.setCurrentItem(index);
        resultsViewPager.setSaveEnabled(false);

        return view;
    }

}
