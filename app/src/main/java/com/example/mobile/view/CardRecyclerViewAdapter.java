package com.example.mobile.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile.R;
import com.example.mobile.model.Listing;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardRecyclerViewAdapter.CardHolder> {

    final ListingResultsPagerFragment pagerFragment = new ListingResultsPagerFragment();
    private final List<Listing> listings = new ArrayList<>();
    Context context;
    boolean forHome;

    private final int[] listingImages = new int[]{R.drawable.branbury_home, R.drawable.windsor_park_home, R.drawable.alta_home,
            R.drawable.brittany_home, R.drawable.village_home};

    public CardRecyclerViewAdapter(Context context, List<Listing> listings, boolean forHome) {
        this.context = context;
        addItems(listings);
        this.forHome = forHome;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.grid_card, parent, false);
        return new CardRecyclerViewAdapter.CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        holder.bindCard(listings.get(position), position);
    }

    @Override
    public int getItemCount() {
        return listings.size();
    }

    public void addItems(List<Listing> newListings) {
        int startInsertPosition = listings.size();
        listings.addAll(newListings);
        this.notifyItemRangeInserted(startInsertPosition, newListings.size());
    }

    class CardHolder extends RecyclerView.ViewHolder {

        MaterialCardView card;
        ConstraintLayout cardLayout;
        TextView gridRatingTextView;
        TextView gridMonthlyRateTextView;
        TextView gridUtilRateTextView;


        public CardHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardView);
            cardLayout = itemView.findViewById(R.id.cardConstraintLayout);
            gridRatingTextView = itemView.findViewById(R.id.gridRatingTextView);
            gridMonthlyRateTextView = itemView.findViewById(R.id.gridMonthlyRateTextView);
            gridUtilRateTextView = itemView.findViewById(R.id.gridUtilRateTextView);
        }

        public void bindCard(Listing listing, final int position) {
            final FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pagerFragment.setIndex(position);
                    pagerFragment.setForHome(forHome);
                    manager.beginTransaction().replace(R.id.flHomeFragment, pagerFragment).commit();
                }
            });
            cardLayout.setBackgroundResource(listingImages[listing.getHeaderImage()]);
            gridRatingTextView.setText(String.format("%.1f", listing.getRating()));
            setRatingColor(listing.getRating(), gridRatingTextView);
            String monthlyRateString = "$" + listing.getMonthlyRate();
            gridMonthlyRateTextView.setText(monthlyRateString);
            String utilRateString = "$" + listing.getUtilRate() + " ";
            gridUtilRateTextView.setText(utilRateString);
        }

        public void setRatingColor(float rating, TextView textView) {
            GradientDrawable backgroundDrawable = (GradientDrawable) textView.getBackground();
            if (rating < 4) {
                backgroundDrawable.setColor(context.getResources().getColor(R.color.red));
            }
            else if (rating < 7) {
                backgroundDrawable.setColor(context.getResources().getColor(R.color.yellow));
            }
            else {
                backgroundDrawable.setColor(context.getResources().getColor(R.color.green));
            }
        }
    }
}
