package com.example.mobile.view;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import com.example.mobile.R;
import com.example.mobile.model.User;
import com.example.mobile.model.enums.Label;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    ImageView headerImageView;
    FloatingActionButton fab;

    private Spinner spinner;
    private static final String[] pricePaths = {"$ 300", "$ 400", "$ 500", "$ 600", "$ 700"};
    private Spinner spinner2;
    private static final String[] ratingPaths = {"9.0", "7.0", "5.0", "3.0", "1.0"};
    private Spinner spinner3;
    private static final String[] tagPaths = {"tags" ,"Laundry in Unit", "Pool", "Private Room",
            "Utilities Included", "Wheelchair Accessible"};

    CardRecyclerViewAdapter cardRecyclerViewAdapter;
    RecyclerView cardRecyclerView;
    GridLayoutManager layoutManager;
    ProfileInterface profileInterface;
    View view;
    public ProfileFragment(ProfileInterface profileObserver) {
        // Required empty public constructor
        this.profileInterface = profileObserver;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        headerImageView = view.findViewById(R.id.homeHeaderImage);
        headerImageView.setImageResource(R.drawable.profile_image);
        headerImageView.setColorFilter(Color.argb(143, 0, 0, 0));

        fab = view.findViewById(R.id.fab);

        // Max Price Drop Down Menu
        spinner = (Spinner)view.findViewById(R.id.spinner1);
        ArrayAdapter<String> priceAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,pricePaths);

        priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(priceAdapter);
        spinner.setOnItemSelectedListener(this);

        // Minimum Rating Drop Down Menu
        spinner2 = (Spinner)view.findViewById(R.id.spinner2);
        ArrayAdapter<String> ratingAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,ratingPaths);

        ratingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(ratingAdapter);
        spinner2.setOnItemSelectedListener(this);

        // Tags Drop Down Menu
        spinner3 = (Spinner)view.findViewById(R.id.spinner3);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,tagPaths);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(spinnerAdapter);
        spinner3.setOnItemSelectedListener(this);

        fab.setImageResource(R.drawable.ic_search_foreground);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileInterface.swapToListing();
            }
        });

        return view;
    }

    public interface ProfileInterface{
        public void swapToListing();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        //System.out.println("Parent ID =   " + parent.getId());
        //System.out.println("spinner1 ID = " + R.id.spinner1);
        switch (parent.getId()) {
            case R.id.spinner1:
                switch (position) {
                    case 0:
                        System.out.println("$ 300!");
                        User.getInstance().getFilterSettings().setRateUpperBoundary(300);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 1:
                        User.getInstance().getFilterSettings().setRateUpperBoundary(400);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 2:
                        User.getInstance().getFilterSettings().setRateUpperBoundary(500);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 3:
                        User.getInstance().getFilterSettings().setRateUpperBoundary(600);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 4:
                        User.getInstance().getFilterSettings().setRateUpperBoundary(700);
                        User.getInstance().updateFilteredListings();
                        break;
                }
                break;
            case R.id.spinner2:
                switch (position) {
                    case 0:
                        System.out.println("$ RATINGS!");
                        User.getInstance().getFilterSettings().setRatingLowerBoundary(9);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 1:
                        User.getInstance().getFilterSettings().setRatingLowerBoundary(7);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 2:
                        User.getInstance().getFilterSettings().setRatingLowerBoundary(5);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 3:
                        User.getInstance().getFilterSettings().setRatingLowerBoundary(3);
                        User.getInstance().updateFilteredListings();
                        break;
                    case 4:
                        User.getInstance().getFilterSettings().setRatingLowerBoundary(1);
                        User.getInstance().updateFilteredListings();
                        break;
                }
                break;
            case R.id.spinner3:
                switch (position) {
                    case 0:
                        System.out.println("$ TAGS!");
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected;Laundry in Unit
                        break;
                    case 2:
                        // Whatever you want to happen when the third item gets selected
                        break;
                    case 3:
                        // Whatever you want to happen when the 4th item gets selectedPrivate Room
                        System.out.println("Private Room!");
                        View linearLayout = view.findViewById(R.id.tagsListTextView);
                        //LinearLayout layout = (LinearLayout) findViewById(R.id.info);
                        /*
                        TextView valueTV = new TextView(getContext());
                        valueTV.setText("X Private Room");
                        valueTV.setId(position);
                        valueTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

                        ((LinearLayout) linearLayout).addView(valueTV);

                        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        lparams.setMargins(5, 3, 5, 3);

                        Label currentLabel = "X Private Room";
                        TextView newLabelView = new TextView(getContext());
                        newLabelView.setLayoutParams(lparams);
                        newLabelView.setPadding(10, 5, 10, 5);
                        newLabelView.setBackgroundColor(Color.parseColor("#e5e5e5"));
                        newLabelView.setTextColor(Color.parseColor("#000000"));
                        newLabelView.setText(currentLabel.getCaption());
                        newLabelView.setTextSize(12);
                        linearLayout.addView(newLabelView); */

                        break;
                    case 4:
                        // Whatever you want to happen when the 5th item gets selected
                        break;
                    case 5:
                        // Whatever you want to happen when the 5th item gets selected
                        break;

                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
