package com.example.mobile.view;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobile.R;
import com.example.mobile.model.Review;
import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;
import com.example.mobile.presenter.ListingPresenter;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListingFragment extends Fragment implements ListingPresenter.View {

    private final int[] listingImages = new int[]{R.drawable.windsor_park};

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

    public ListingFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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

        presenter = new ListingPresenter(this);

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
        String monthlyRateString = "$" + monthlyRate;
        monthlyRateText.setText(monthlyRateString);
        String utilRateString = "$" + utilRate + " ";
        utilRateText.setText(utilRateString);
        String bedBathNumRoomTypeString = bedNum + " Bed " + bathNum + " Bath · " + roomType;
        bedBathNumRoomTypeText.setText(bedBathNumRoomTypeString);

        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams.setMargins(5, 3, 5, 3);
        Iterator<Label> it = topLabels.iterator();
        while (it.hasNext()) {
            Label currentLabel = it.next();
            TextView newLabelView = new TextView(getContext());
            newLabelView.setLayoutParams(lparams);
            newLabelView.setPadding(10, 5, 10, 5);
            newLabelView.setBackgroundColor(Color.parseColor("#e5e5e5"));
            newLabelView.setTextColor(Color.parseColor("#000000"));
            newLabelView.setText(currentLabel.getCaption());
            topLablesLayout.addView(newLabelView);
        }
    }

    @Override
    public void initAmenitiesCard(EnumSet<Amenity> amenities) {
        String amenitiesListString = "";
        Iterator<Amenity> it = amenities.iterator();
        while(it.hasNext()) {
            Amenity currentAmenity = it.next();
            amenitiesListString = currentAmenity.getCaption();
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

    }

    @Override
    public void initGettingAroundCard(int timeToCampus, int timeToUVX, int timeToGrocer) {
        timeToCampusText.setText(String.valueOf(timeToCampus));
        timeToUVXText.setText(String.valueOf(timeToUVX));
        timeToGrocerText.setText(String.valueOf(timeToGrocer));
    }
}
