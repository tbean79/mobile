package com.example.mobile.model.enums;

public enum Label {

    SOCIAL_WARD("Social Ward"),
    PET_FRIENDLY("Pet Friendly"),
    DID_YOU_EVEN_CLEAN("\"Did you even clean?\""),
    GOODBYE_DEPOSIT("Goodbye Deposit"),
    CLOSE_QUARTERS("Close Quarters");

    String caption;

    Label(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
