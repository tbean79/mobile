package com.example.mobile.model;

import com.example.mobile.model.enums.Amenity;

import java.util.EnumSet;

public class Filter {

    int rateUpperBoundary;
    int ratingUpperBoundary;
    int distanceToCampusUpperBoundary;
    EnumSet<Amenity> amenityFilters =
            EnumSet.allOf(Amenity.class); // this should init a superset of all amenities
}
