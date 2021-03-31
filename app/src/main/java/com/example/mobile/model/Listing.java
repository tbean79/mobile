package com.example.mobile.model;

import android.graphics.drawable.Drawable;

import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;
import com.example.mobile.model.enums.RoomType;

import java.util.EnumSet;
import java.util.List;

public class Listing {

    private String name;
    private String address;
    private float rating;
    private int monthlyRate;
    private int utilRate;
    private int bedNum;
    private int bathNum;
    private RoomType roomType;
    private int headerImageID;

    private String phoneNumber;
    private String emailAddress;
    private String website;

    private List<Review> reviews;
    private EnumSet<Amenity> amenities;
    private EnumSet labels;

    private int timeToCampus;
    private int timeToUVX;
    private int timeToGrocer;

    public Listing(ListingBuilder listingBuilder) {
        this.name = listingBuilder.name;
        this.address = listingBuilder.address;
        this.monthlyRate = listingBuilder.monthlyRate;
        this.utilRate = listingBuilder.utilRate;
        this.bedNum = listingBuilder.bedNum;
        this.bathNum = listingBuilder.bathNum;
        this.roomType = listingBuilder.roomType;
        this.headerImageID = listingBuilder.headerImageID;
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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getRating() {
        return rating;
    }

    public int getMonthlyRate() {
        return monthlyRate;
    }

    public int getUtilRate() {
        return utilRate;
    }

    public int getBedNum() {
        return bedNum;
    }

    public int getBathNum() {
        return bathNum;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getWebsite() {
        return website;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public EnumSet<Amenity> getAmenities() {
        return amenities;
    }

    public EnumSet getLabels() {
        return labels;
    }

    public int getTimeToCampus() {
        return timeToCampus;
    }

    public int getTimeToUVX() {
        return timeToUVX;
    }

    public int getTimeToGrocer() {
        return timeToGrocer;
    }

    public int getHeaderImage() {
        return headerImageID;
    }

    private float calculateRating() {
        if (reviews.size() == 0)
            return 0;
        float total = 0;
        for (Review rev : reviews) {
            total += rev.rating;
        }
        return total / reviews.size();
    }

    private EnumSet calculateTopLabels() {
        EnumSet<Label> allLabels = EnumSet.noneOf(Label.class); // didn't bother to calculate most occurring labels lol
        for (Review rev : reviews) {
            allLabels.addAll(rev.labels);
            if (allLabels.size() == 2)
                break;
        }
        return allLabels;
    }
}


