package com.example.mobile.view;


import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mobile.R;
import com.example.mobile.model.User;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView headerImageView;

    HomeCardRecyclerViewAdapter homeCardRecyclerViewAdapter;
    RecyclerView homeCardRecyclerView;
    GridLayoutManager layoutManager;

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

        homeCardRecyclerView = view.findViewById(R.id.homeCardRecyclerView);
        layoutManager = new GridLayoutManager(this.getContext(), 2);
        homeCardRecyclerView.setLayoutManager(layoutManager);

        homeCardRecyclerViewAdapter = new HomeCardRecyclerViewAdapter(getContext(), User.getInstance().getFilteredListings());
        homeCardRecyclerView.setAdapter(homeCardRecyclerViewAdapter);

        return view;
    }

}
