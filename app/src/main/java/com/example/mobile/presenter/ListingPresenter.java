package com.example.mobile.presenter;

import com.example.mobile.model.Listing;
import com.example.mobile.model.Review;
import com.example.mobile.model.User;
import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;

import java.util.EnumSet;
import java.util.List;

public class ListingPresenter {

    private View view;
    private User user;
    private Listing currentListing;

    public ListingPresenter(View view, int position) {
        this.view = view;
        user = User.getInstance();
        currentListing = user.getFilteredListings().get(position);
        init();
    }

    private void init() {
        view.initHeader(currentListing.getName(), currentListing.getAddress(), currentListing.getHeaderImage());
        view.initTopCard(currentListing.getRating(), currentListing.getMonthlyRate(), currentListing.getUtilRate(),
                currentListing.getBathNum(), currentListing.getBedNum(), currentListing.getRoomType().getCaption(),
                currentListing.getLabels());
        view.initAmenitiesCard(currentListing.getAmenities());
        view.initContactCard(currentListing.getPhoneNumber(), currentListing.getEmailAddress(), currentListing.getWebsite());
        view.initReviewsCard(currentListing.getReviews());
        view.initGettingAroundCard(currentListing.getTimeToCampus(), currentListing.getTimeToUVX(), currentListing.getTimeToGrocer());
        view.initFAB(user.getSavedListings().contains(currentListing));
    }

    public void addCurrentListingToFavorites() {
        user.getSavedListings().add(currentListing);
    }

    public void removeCurrentListingFromFavorites() {
        user.getSavedListings().remove(currentListing);
    }

    public interface View {
        void initHeader(String name, String address, int headerImageDrawableID);
        void initTopCard(float rating, int monthlyRate, int utilRate, int bathNum, int bedNum, String roomType,
                         EnumSet<Label> topLabels);
        void initAmenitiesCard(EnumSet<Amenity> amenities);
        void initContactCard(String phoneNumber, String emailAddress, String website);
        void initReviewsCard(List<Review> reviews);
        void initGettingAroundCard(int timeToCampus, int timeToUVX, int timeToGrocer);
        void initFAB(boolean saved);
    }
}
