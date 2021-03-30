package com.example.mobile.net;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobile.model.Review;
import com.example.mobile.model.enums.Label;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ReviewGenerator {
    private static final int MAX_REVIEWS = 2;

    private static final String BODY_1 = "prompt maintenance but awful parking";
    private static final String BODY_2 = "You might be looking for the best place to stay, trust me, this is not it";
    private static final String BODY_3 = "loved the management and roommates are my best friends";
    private static final String BODY_4 = "kind of run down but very close to campus";
    private static final String[] DUMMY_BODIES = {BODY_1, BODY_2, BODY_3, BODY_4};

    private static final int TOP_RATING = 10;

    private static final String NAME_1 = "George W";
    private static final String NAME_2 = "Roberta R";
    private static final String NAME_3 = "Michael P";
    private static final String NAME_4 = "Susan Q";
    private static final String[] DUMMY_NAMES = {NAME_1, NAME_2, NAME_3, NAME_4};

    private static final LocalDate DATE = LocalDate.of(2020, 1, 8);


    private static ReviewGenerator instance;

    private ReviewGenerator() {}

    public static ReviewGenerator getInstance() {
        if(instance == null) {
            instance = new ReviewGenerator();
        }
        return instance;
    }

    public List<Review> generateRandomReviews() {
        Random random = new Random();
        int count = random.nextInt(MAX_REVIEWS);
        List<Review> reviews = new ArrayList<>(count);

        for (int i = random.nextInt(MAX_REVIEWS); reviews.size() < count; ) {
            Review newRev = new Review(DUMMY_NAMES[i], random.nextInt(TOP_RATING),
                    DATE, GeneratorUtils.DUMMY_LABELS[i], DUMMY_BODIES[i]);

            reviews.add(newRev);

            if (i == MAX_REVIEWS - 1)
                i = 0;
            else i++;
        }
        return reviews;
    }
}
