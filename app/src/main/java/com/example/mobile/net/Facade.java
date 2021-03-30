package com.example.mobile.net;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobile.model.Listing;

import java.util.List;

public class Facade {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<Listing> generateRandomListings() {
        return ListingGenerator.generateRandomListings();
    }
}
