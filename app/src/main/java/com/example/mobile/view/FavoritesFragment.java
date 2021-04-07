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
import android.widget.TextView;

import com.example.mobile.R;
import com.example.mobile.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    ImageView headerImageView;

    CardRecyclerViewAdapter cardRecyclerViewAdapter;
    RecyclerView cardRecyclerView;
    GridLayoutManager layoutManager;

    TextView noneSavedTextView;

    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        headerImageView = view.findViewById(R.id.homeHeaderImage);
        headerImageView.setImageResource(R.drawable.dorm);
        headerImageView.setColorFilter(Color.argb(143, 0, 0, 0));

        cardRecyclerView = view.findViewById(R.id.homeCardRecyclerView);
        layoutManager = new GridLayoutManager(this.getContext(), 2);
        cardRecyclerView.setLayoutManager(layoutManager);

        cardRecyclerViewAdapter = new CardRecyclerViewAdapter(getContext(), User.getInstance().getSavedListings(), false);
        cardRecyclerView.setAdapter(cardRecyclerViewAdapter);

        if (User.getInstance().getSavedListings().size() == 0) {
            noneSavedTextView = view.findViewById(R.id.noneSavedText);
            noneSavedTextView.setVisibility(View.VISIBLE);
        }

        return view;
    }

}
