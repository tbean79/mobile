package com.example.mobile.model;

import com.example.mobile.model.enums.Label;

import java.time.LocalDate;
import java.util.EnumSet;

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

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getTime() {
        return time;
    }

    public EnumSet<Label> getLabels() {
        return labels;
    }

    public String getBody() {
        return body;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public void setLabels(EnumSet<Label> labels) {
        this.labels = labels;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
