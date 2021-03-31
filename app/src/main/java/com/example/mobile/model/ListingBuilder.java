package com.example.mobile.model;

import android.graphics.drawable.Drawable;

import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;
import com.example.mobile.model.enums.RoomType;

import java.util.EnumSet;
import java.util.List;

public class ListingBuilder {

    String name;
    String address;
    int monthlyRate;
    int utilRate;
    int bedNum;
    int bathNum;
    RoomType roomType;
    int headerImageID;

    String phoneNumber;
    String emailAddress;
    String website;

    List<Review> reviews;
    EnumSet<Amenity> amenities;

    int timeToCampus;
    int timeToUVX;
    int timeToGrocer;

    public ListingBuilder(String name, String address, int monthlyRate, int utilRate) {
        this.name = name;
        this.address = address;
        this.monthlyRate = monthlyRate;
        this.utilRate = utilRate;
    }

    public ListingBuilder bedAndBath(int bedNum, int bathNum) {
        this.bedNum = bedNum;
        this.bathNum = bathNum;
        return this;
    }

    public ListingBuilder roomType(RoomType type) {
        this.roomType = type;
        return this;
    }

    public ListingBuilder image(int image) {
        this.headerImageID = image;
        return this;
    }

    public ListingBuilder contact(String phoneNumber, String emailAddress, String website) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.website = website;
        return this;
    }

    public ListingBuilder reviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public ListingBuilder amenities(EnumSet<Amenity> amenities) {
        this.amenities = amenities;
        return this;
    }


    public ListingBuilder transit(int timeToCampus, int timeToUVX, int timeToGrocer) {
        this.timeToCampus = timeToCampus;
        this.timeToUVX = timeToUVX;
        this.timeToGrocer = timeToGrocer;
        return this;
    }

    public Listing build() {
        Listing listing = new Listing(this);
        return listing;
    }
}
