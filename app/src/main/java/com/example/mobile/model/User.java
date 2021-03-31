package com.example.mobile.model;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobile.model.enums.Amenity;
import com.example.mobile.net.Facade;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class User extends Application {

    private String name;

    private byte[] profilePicture; //TODO change to better type as needed, like Drawable

    private List<Listing> allListings;
    private List<Listing> filteredListings;
    private List<Listing> savedListings;
    private Filter filterSettings;

    private static User instance;

    private User() {
        name = "Sample User";
        filterSettings = new Filter();
        allListings = Facade.generateRandomListings();
        filteredListings = new ArrayList<>(allListings);
        savedListings = new ArrayList<>();
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public List<Listing> getFilteredListings() {
        return filteredListings;
    }

    public List<Listing> getSavedListings() {
        return savedListings;
    }

    public Filter getFilterSettings() {
        return filterSettings;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void resetToAllListings() {
        filteredListings = new ArrayList<>(allListings);
    }

    public void updateFilteredListings() {
        resetToAllListings();
        if (filterSettings.getRateUpperBoundary() != null) {
            int upperBoundary = filterSettings.getRateUpperBoundary();
            for (Listing listing : filteredListings) {
                if (listing.getMonthlyRate() > upperBoundary)
                    filteredListings.remove(listing);
            }
        }
        if (filterSettings.getRatingLowerBoundary() != null) {
            int lowerBoundary = filterSettings.getRatingLowerBoundary();
            for (Listing listing : filteredListings) {
                if (listing.getRating() < lowerBoundary)
                    filteredListings.remove(listing);
            }
        }
        if (filterSettings.getDistanceToCampusUpperBoundary() != null) {
            int upperBoundary = filterSettings.getDistanceToCampusUpperBoundary();
            for (Listing listing : filteredListings) {
                if (listing.getRating() > upperBoundary)
                    filteredListings.remove(listing);
            }
        }
        EnumSet<Amenity> amenities = filterSettings.getAmenityFilters();
        for (Listing listing : filteredListings) {
            if (!listing.getAmenities().containsAll(amenities))
                filteredListings.remove(listing);
        }

    }
}
