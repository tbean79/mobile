package com.example.mobile.view;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile.R;
import com.example.mobile.model.Review;
import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;
import com.example.mobile.presenter.ListingPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListingFragment extends Fragment implements ListingPresenter.View {

    private final int[] listingImages = new int[]{R.drawable.branbury, R.drawable.windsor_park, R.drawable.alta,
                R.drawable.brittany, R.drawable.village};

    ListingPresenter presenter;

    TextView headerNameText;
    TextView headerAddressText;
    ImageView headerImage;

    TextView ratingText;
    TextView monthlyRateText;
    TextView utilRateText;
    TextView bedBathNumRoomTypeText;
    LinearLayout topLablesLayout;

    TextView amenitiesListText;

    ImageView phoneIcon;
    ImageView emailIcon;
    ImageView websiteIcon;

    TextView timeToCampusText;
    TextView timeToUVXText;
    TextView timeToGrocerText;

    ReviewRecyclerViewAdapter reviewRecyclerViewAdapter;
    RecyclerView reviewsRecyclerView;
    LinearLayoutManager layoutManager;
    TextView seeMoreTextView;

    FloatingActionButton fab;
    boolean savedToFavorites;

    public ListingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);

        headerNameText = view.findViewById(R.id.headerNameText);
        headerAddressText = view.findViewById(R.id.addressText);
        headerImage = view.findViewById(R.id.headerImage);

        ratingText = view.findViewById(R.id.ratingTextView);
        monthlyRateText = view.findViewById(R.id.monthlyRateTextView);
        utilRateText = view.findViewById(R.id.utilRateTextView);
        bedBathNumRoomTypeText = view.findViewById(R.id.bedBathNumRoomTypeText);
        topLablesLayout = view.findViewById(R.id.labelsLayout);

        amenitiesListText = view.findViewById(R.id.amenitiesListTextView);

        phoneIcon = view.findViewById(R.id.phoneImageView);
        emailIcon = view.findViewById(R.id.mailImageView);
        websiteIcon = view.findViewById(R.id.webImageView);

        timeToCampusText = view.findViewById(R.id.toCampusTextView);
        timeToUVXText = view.findViewById(R.id.toUVXTextView);
        timeToGrocerText = view.findViewById(R.id.toGrocerTextView);

        reviewsRecyclerView = view.findViewById(R.id.reviewsRecyclerView);
        layoutManager = new LinearLayoutManager(this.getContext());
        reviewsRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(reviewsRecyclerView.getContext(),
                layoutManager.getOrientation());
        reviewsRecyclerView.addItemDecoration(dividerItemDecoration);
        seeMoreTextView = view.findViewById(R.id.seeMoreTextView);

        fab = view.findViewById(R.id.fab);

        presenter = new ListingPresenter(this, this.getArguments().getInt("position"),
                this.getArguments().getBoolean("forHome"));

        return view;
    }

    @Override
    public void initHeader(String name, String address, int headerImageDrawableID) {
        headerNameText.setText(name);
        headerAddressText.setText(address);
        headerImage.setImageResource(listingImages[headerImageDrawableID]);
    }

    @Override
    public void initTopCard(float rating, int monthlyRate, int utilRate, int bathNum, int bedNum, String roomType, EnumSet<Label> topLabels) {
        ratingText.setText(String.format("%.1f", rating));
        setRatingColor(rating, ratingText);
        String monthlyRateString = "$" + monthlyRate;
        monthlyRateText.setText(monthlyRateString);
        String utilRateString = "$" + utilRate + " ";
        utilRateText.setText(utilRateString);
        String bedBathNumRoomTypeString = bedNum + " Bed " + bathNum + " Bath ?? " + roomType;
        bedBathNumRoomTypeText.setText(bedBathNumRoomTypeString);

        initLabels(topLabels, topLablesLayout);
    }

    public void setRatingColor(float rating, TextView textView) {
        GradientDrawable backgroundDrawable = (GradientDrawable) textView.getBackground();
        if (rating < 4) {
            backgroundDrawable.setColor(getResources().getColor(R.color.red));
        }
        else if (rating < 7) {
            backgroundDrawable.setColor(getResources().getColor(R.color.yellow));
        }
        else {
            backgroundDrawable.setColor(getResources().getColor(R.color.green));
        }
    }

    @Override
    public void initAmenitiesCard(EnumSet<Amenity> amenities) {
        String amenitiesListString = "";
        Iterator<Amenity> it = amenities.iterator();
        while(it.hasNext()) {
            Amenity currentAmenity = it.next();
            amenitiesListString += currentAmenity.getCaption();
            if (it.hasNext())
                amenitiesListString += "\n";
        }
        amenitiesListText.setText(amenitiesListString);
    }

    @Override
    public void initContactCard(final String phoneNumber, final String emailAddress, final String website) {
        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "tel:" + phoneNumber.trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        emailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        websiteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(website));
                startActivity(i);
            }
        });
    }

    @Override
    public void initReviewsCard(List<Review> reviews) {
        List<Review> firstReview = reviews.subList(0, 1);
        final List<Review> restReviews = reviews.subList(1, reviews.size());
        reviewRecyclerViewAdapter = new ReviewRecyclerViewAdapter(firstReview, getContext());
        reviewsRecyclerView.setAdapter(reviewRecyclerViewAdapter);
        if (restReviews.size() == 0)
            seeMoreTextView.setVisibility(View.INVISIBLE);
        else {
            String seeMoreString;
            if (restReviews.size() == 1)
                seeMoreString = "See " + restReviews.size() + " more review ???";
            else
                seeMoreString = "See " + restReviews.size() + " more reviews ???";
            seeMoreTextView.setText(seeMoreString);
            seeMoreTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reviewRecyclerViewAdapter.addItems(restReviews);
                    seeMoreTextView.setVisibility(View.INVISIBLE);
                }
            });
        }
    }

    @Override
    public void initGettingAroundCard(int timeToCampus, int timeToUVX, int timeToGrocer) {
        timeToCampusText.setText(String.valueOf(timeToCampus));
        timeToUVXText.setText(String.valueOf(timeToUVX));
        timeToGrocerText.setText(String.valueOf(timeToGrocer));
    }

    public void initLabels(EnumSet<Label> labels, LinearLayout linearLayout) {
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams.setMargins(5, 3, 5, 3);
        Iterator<Label> it = labels.iterator();
        while (it.hasNext()) {
            Label currentLabel = it.next();
            TextView newLabelView = new TextView(getContext());
            newLabelView.setLayoutParams(lparams);
            newLabelView.setPadding(10, 5, 10, 5);
            newLabelView.setBackgroundColor(Color.parseColor("#e5e5e5"));
            newLabelView.setTextColor(Color.parseColor("#000000"));
            newLabelView.setText(currentLabel.getCaption());
            newLabelView.setTextSize(12);
            linearLayout.addView(newLabelView);
        }
    }

    public void initFAB(boolean saved) {
        if (saved) {
            savedToFavorites = true;
            fab.setImageResource(R.drawable.ic_saved);
        }
        else {
            savedToFavorites = false;
            fab.setImageResource(R.drawable.ic_add);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedToFavorites) {
                    presenter.removeCurrentListingFromFavorites();
                    savedToFavorites = false;
                    fab.setImageResource(R.drawable.ic_add);
                }
                else {
                    presenter.addCurrentListingToFavorites();
                    savedToFavorites = true;
                    fab.setImageResource(R.drawable.ic_saved);
                }
            }
        });
    }
}
