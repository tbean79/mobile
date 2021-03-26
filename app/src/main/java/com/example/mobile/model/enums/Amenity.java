package com.example.mobile.model.enums;

public enum Amenity {

    IN_UNIT_LAUNDRY("In Unit Laundry"),
    POOL("Pool"),
    A_C("A/C"),
    OUTDOOR_GRILL("Outdoor Grill"),
    WHEELCHAIR_ACCESSIBLE("Wheelchair Accessible");

    String caption;

    Amenity(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
