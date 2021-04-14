package com.example.mobile.view;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobile.R;
import com.example.mobile.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListingResultsPagerFragment extends Fragment {

    ViewPager2 resultsViewPager;
    RelativeLayout tutorialRelativeLayout;
    TextView tutorialTextView;
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

        if (forHome && !User.getInstance().isDidTutorial()) {

            tutorialRelativeLayout = view.findViewById(R.id.tutorialLayout);
            tutorialRelativeLayout.setVisibility(View.VISIBLE);
            tutorialRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User.getInstance().setDidTutorial(true);
                    tutorialRelativeLayout.setVisibility(View.INVISIBLE);
                }
            });

            String text = "Swipe to see more  ➔\n\nTap to dismiss";
            Spannable spannable = new SpannableString(text);
            spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#33b5e5")), 22, 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new AbsoluteSizeSpan(14, true), 22, 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tutorialTextView = view.findViewById(R.id.tutorialTextView);
            tutorialTextView.setText(spannable, TextView.BufferType.SPANNABLE);
        }

        return view;
    }

}
