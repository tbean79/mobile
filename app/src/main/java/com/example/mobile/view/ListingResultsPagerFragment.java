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


    public ListingResultsPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_results_pager, container, false);

        final ResultsFragmentStateAdapter resultsFragmentStateAdapter = new ResultsFragmentStateAdapter(this, getContext());
        resultsViewPager = view.findViewById(R.id.resultsViewPager);
        resultsViewPager.setAdapter(resultsFragmentStateAdapter);
        resultsViewPager.setSaveEnabled(false);

        return view;
    }

}
