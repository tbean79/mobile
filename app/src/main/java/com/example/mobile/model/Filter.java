package com.example.mobile.model;

import com.example.mobile.model.enums.Amenity;

import java.util.EnumSet;

public class Filter {

    private Integer rateUpperBoundary;
    private Integer ratingLowerBoundary;
    private Integer distanceToCampusUpperBoundary;
    EnumSet<Amenity> amenityFilters =
            EnumSet.noneOf(Amenity.class);

    public Integer getRateUpperBoundary() {
        return rateUpperBoundary;
    }

    public void setRateUpperBoundary(Integer rateUpperBoundary) {
        this.rateUpperBoundary = rateUpperBoundary;
    }

    public Integer getRatingLowerBoundary() {
        return ratingLowerBoundary;
    }

    public void setRatingLowerBoundary(Integer ratingUpperBoundary) {
        this.ratingLowerBoundary = ratingUpperBoundary;
    }

    public Integer getDistanceToCampusUpperBoundary() {
        return distanceToCampusUpperBoundary;
    }

    public void setDistanceToCampusUpperBoundary(Integer distanceToCampusUpperBoundary) {
        this.distanceToCampusUpperBoundary = distanceToCampusUpperBoundary;
    }

    public EnumSet<Amenity> getAmenityFilters() {
        return amenityFilters;
    }

    public void setAmenityFilters(EnumSet<Amenity> amenityFilters) {
        this.amenityFilters = amenityFilters;
    }
}
