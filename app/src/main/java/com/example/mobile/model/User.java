package com.example.mobile.model;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobile.net.Facade;

import java.util.ArrayList;
import java.util.List;

public class User extends Application {

    private String name;

    private byte[] profilePicture; //TODO change to better type as needed, like Drawable

    private List<Listing> filteredListings;
    private List<Listing> savedListings;
    private Filter filterSettings;

    private static User instance;

    @RequiresApi(api = Build.VERSION_CODES.O)
    private User() {
        name = "Sample User";
        filterSettings = new Filter();
        filteredListings = Facade.generateRandomListings();
        savedListings = new ArrayList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
    }

}
