package com.example.mobile.view;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mobile.R;
import com.example.mobile.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView headerImageView;

    CardRecyclerViewAdapter cardRecyclerViewAdapter;
    RecyclerView cardRecyclerView;
    GridLayoutManager layoutManager;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        headerImageView = view.findViewById(R.id.homeHeaderImage);
        headerImageView.setImageResource(R.drawable.home);
        headerImageView.setColorFilter(Color.argb(143, 0, 0, 0));

        cardRecyclerView = view.findViewById(R.id.homeCardRecyclerView);
        layoutManager = new GridLayoutManager(this.getContext(), 2);
        cardRecyclerView.setLayoutManager(layoutManager);

        cardRecyclerViewAdapter = new CardRecyclerViewAdapter(getContext(), User.getInstance().getFilteredListings());
        cardRecyclerView.setAdapter(cardRecyclerViewAdapter);

        return view;
    }
}
