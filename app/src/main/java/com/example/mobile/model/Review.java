package com.example.mobile.model;

import com.example.mobile.model.enums.Label;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

public class Review {

    String name;
    int rating;
    LocalDate time;
    EnumSet<Label> labels;
    String body;

    public Review(String name, int rating, LocalDate time, EnumSet<Label> labels, String body) {
        this.name = name;
        this.rating = rating;
        this.time = time;
        this.labels = labels;
        this.body = body;
    }
}
