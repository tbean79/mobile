package com.example.mobile.model.enums;

public enum Amenity {

    IN_UNIT_LAUNDRY("Laundry In Unit"),
    POOL("Pool"),
    A_C("A/C"),
    OUTDOOR_GRILL("Outdoor Grill"),
    WHEELCHAIR_ACCESSIBLE("Wheelchair Accessible"),
    PRIVATE_ROOM("Private Room"),
    UTILITIES_INCLUDED("Utilities Included");

    String caption;

    Amenity(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
