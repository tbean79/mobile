package com.example.mobile.net;

import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobile.model.Listing;
import com.example.mobile.model.ListingBuilder;
import com.example.mobile.model.enums.RoomType;

import java.util.ArrayList;
import java.util.List;

public class ListingGenerator {
    private static final int MAX_LISTINGS = 5;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<Listing> generateRandomListings() {
        List<Listing> listings = new ArrayList<>(MAX_LISTINGS);

        listings.add( new ListingBuilder("Branbury", "449 W 1720 N, Provo", 329, 35)
                .bedAndBath(2, 2)
                .roomType(RoomType.PRIVATE)
                .reviews(ReviewGenerator.getInstance().generateRandomReviews())
                .amenities(GeneratorUtils.DUMMY_AMENITIES[0])
                .contact("(801) 416-3198", null, "https://www.thebranbury.com/")
                .transit(10, 5, 15)
                .build());

        listings.add( new ListingBuilder("Windsor Park", "104 W 1230 N, Provo", 435, 55)
                .bedAndBath(3, 2)
                .roomType(RoomType.PRIVATE)
                .image(Drawable.createFromPath("/app/src/main/res/drawable/windsor_park.png"))
                .reviews(ReviewGenerator.getInstance().generateRandomReviews())
                .amenities(GeneratorUtils.DUMMY_AMENITIES[0])
                .contact("(801) 224-4846", "frontdesk@aspenridgemanagement.com", "http://www.aspenridgemanagement.com/units/windsor-park-219/")
                .transit(10, 10, 5)
                .build());

        listings.add( new ListingBuilder("Alta Apartments", "1850 N University Ave, Provo", 330, 35)
                .bedAndBath(6, 2)
                .roomType(RoomType.SHARED)
                .reviews(ReviewGenerator.getInstance().generateRandomReviews())
                .amenities(GeneratorUtils.DUMMY_AMENITIES[1])
                .contact("(801) 360-0424", "altaapartments@gmail.com", "https://altaapartment.com/")
                .transit(10, 5, 15)
                .build());

        listings.add( new ListingBuilder("The Brittany", "243 E 500 N, Provo", 360, 33)
                .bedAndBath(4, 2)
                .roomType(RoomType.SHARED)
                .reviews(ReviewGenerator.getInstance().generateRandomReviews())
                .amenities(GeneratorUtils.DUMMY_AMENITIES[2])
                .contact("(801) 374-9788", null, "https://brittanyapts.net/")
                .transit(10, 5, 15)
                .build());

        listings.add( new ListingBuilder("The Village", "602 E 600 N, Provo, UT 84606", 360, 33)
                .bedAndBath(4, 2)
                .roomType(RoomType.PRIVATE)
                .reviews(ReviewGenerator.getInstance().generateRandomReviews())
                .amenities(GeneratorUtils.DUMMY_AMENITIES[3])
                .contact("(855) 710-4232", null, "https://www.thevillageatsouthcampus.com/")
                .transit(5, 2, 15)
                .build());

        return listings;
    }
}
