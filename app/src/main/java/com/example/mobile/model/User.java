package com.example.mobile.model;

import java.util.List;

public class User {

    String name;

    byte[] profilePicture; //TODO change to better type as needed

    List<Listing> filteredListings;
    List<Listing> savedListings;
    Filter filterSettings;

}
