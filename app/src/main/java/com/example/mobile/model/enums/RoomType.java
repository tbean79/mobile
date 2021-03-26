package com.example.mobile.model.enums;

public enum RoomType {
    SHARED("Shared"),
    PRIVATE("Private");

    String caption;

    RoomType(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
