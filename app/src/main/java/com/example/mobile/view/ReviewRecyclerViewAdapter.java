package com.example.mobile.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile.R;
import com.example.mobile.model.Review;
import com.example.mobile.model.enums.Label;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

class ReviewRecyclerViewAdapter extends RecyclerView.Adapter<ReviewRecyclerViewAdapter.ReviewHolder> {

    private final List<Review> reviews = new ArrayList<>();
    Context context;


    public ReviewRecyclerViewAdapter(List<Review> reviews, Context context) {
        this.context = context;
        addItems(reviews);
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.review_row, parent, false);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        holder.bindReview(reviews.get(position));
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    void addItems(List<Review> newReviews) {
        int startInsertPosition = reviews.size();
        reviews.addAll(newReviews);
        this.notifyItemRangeInserted(startInsertPosition, newReviews.size());
    }

    class ReviewHolder extends RecyclerView.ViewHolder {

        TextView ratingView;
        TextView reviewNameDateView;
        LinearLayout reviewLabelsLayout;
        TextView reviewBodyTextView;

        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            ratingView = itemView.findViewById(R.id.ratingTextView);
            reviewNameDateView = itemView.findViewById(R.id.reviewNameDateTextView);
            reviewLabelsLayout = itemView.findViewById(R.id.reviewLabelsLayout);
            reviewBodyTextView = itemView.findViewById(R.id.reviewBodyTextView);
        }

        void bindReview(Review review) {
            ratingView.setText(String.valueOf(review.getRating()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d YYYY");
            String reviewNameDateString = review.getName() + " · " + formatter.format(review.getTime());
            reviewNameDateView.setText(reviewNameDateString);
            initLabels(review.getLabels(), reviewLabelsLayout);
            reviewBodyTextView.setText(review.getBody());
        }

        public void initLabels(EnumSet<Label> labels, LinearLayout linearLayout) {
            LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lparams.setMargins(5, 3, 5, 3);
            Iterator<Label> it = labels.iterator();
            while (it.hasNext()) {
                Label currentLabel = it.next();
                TextView newLabelView = new TextView(context);
                newLabelView.setLayoutParams(lparams);
                newLabelView.setPadding(10, 5, 10, 5);
                newLabelView.setBackgroundColor(Color.parseColor("#e5e5e5"));
                newLabelView.setTextColor(Color.parseColor("#000000"));
                newLabelView.setTextSize(12);
                newLabelView.setText(currentLabel.getCaption());
                linearLayout.addView(newLabelView);
            }
        }
    }
}