package com.example.mobile.model;

import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;
import com.example.mobile.model.enums.RoomType;

import java.util.EnumSet;
import java.util.List;

public class Listing {

    String name;
    String address;
    float rating;
    int monthlyRate;
    int utilRate;
    int bedNum;
    int bathNum;
    RoomType roomType;
    byte[] headerImage; //TODO change to something else if better alternative (like path to file)

    String phoneNumber;
    String emailAddress;
    String website;

    List<Review> reviews;
    EnumSet<Amenity> amenities;
    EnumSet<Label> labels;

    int timeToCampus;
    int timeToUVX;
    int timeToGrocer;

    public Listing(ListingBuilder listingBuilder) {
        this.name = listingBuilder.name;
        this.address = listingBuilder.address;
        this.monthlyRate = listingBuilder.monthlyRate;
        this.utilRate = listingBuilder.utilRate;
        this.bedNum = listingBuilder.bedNum;
        this.bathNum = listingBuilder.bathNum;
        this.roomType = listingBuilder.roomType;
        this.headerImage = listingBuilder.headerImage;
        this.phoneNumber = listingBuilder.phoneNumber;
        this.emailAddress = listingBuilder.emailAddress;
        this.website = listingBuilder.website;
        this.reviews = listingBuilder.reviews;
        this.amenities = listingBuilder.amenities;
        this.timeToCampus = listingBuilder.timeToCampus;
        this.timeToUVX = listingBuilder.timeToUVX;
        this.timeToGrocer = listingBuilder.timeToGrocer;
        this.rating = calculateRating();
        this.labels = calculateTopLabels();
    }

    float calculateRating() {
        float total = 0;
        for (Review rev : reviews) {
            total += rev.rating;
        }
        return total / reviews.size();
    }

    EnumSet calculateTopLabels() {
        EnumSet<Label> allLabels = EnumSet.noneOf(Label.class); // didn't bother to calculate most occuring labels lol
        for (Review rev : reviews) {
            allLabels.addAll(rev.labels);
        }
        return allLabels;
    }
}


