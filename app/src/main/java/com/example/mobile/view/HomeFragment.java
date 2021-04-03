package com.example.mobile.view;


import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mobile.R;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView headerImageView;
    ConstraintLayout leftCardLayout;
    ConstraintLayout rightCardLayout;

    MaterialCardView leftCard;
    MaterialCardView rightCard;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        headerImageView = view.findViewById(R.id.homeHeaderImage);
        headerImageView.setImageResource(R.drawable.home);
        headerImageView.setColorFilter(Color.argb(143, 0, 0, 0));

        final ListingResultsPagerFragment pagerFragment = new ListingResultsPagerFragment();

        leftCard = view.findViewById(R.id.leftCardView);
        leftCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerFragment.setIndex(0);
                getChildFragmentManager().beginTransaction().replace(R.id.flHomeFragment, pagerFragment).commit();
            }
        });

        rightCard = view.findViewById(R.id.rightCardView);
        rightCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerFragment.setIndex(1);
                getChildFragmentManager().beginTransaction().replace(R.id.flHomeFragment, pagerFragment).commit();
            }
        });


        return view;
    }

}
