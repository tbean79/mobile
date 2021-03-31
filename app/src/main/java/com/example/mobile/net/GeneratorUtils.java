package com.example.mobile.net;

import com.example.mobile.model.enums.Amenity;
import com.example.mobile.model.enums.Label;
import com.example.mobile.model.enums.RoomType;

import java.util.EnumSet;

public class GeneratorUtils {
    private static final EnumSet<Label> LABELS_1 = EnumSet.of(Label.CLOSE_QUARTERS, Label.GOODBYE_DEPOSIT);
    private static final EnumSet<Label> LABELS_2 = EnumSet.of(Label.PET_FRIENDLY);
    private static final EnumSet<Label> LABELS_3 = EnumSet.of(Label.DID_YOU_EVEN_CLEAN, Label.SOCIAL_WARD);
    private static final EnumSet<Label> LABELS_4 = EnumSet.of(Label.SOCIAL_WARD, Label.GOODBYE_DEPOSIT);

    public static final EnumSet[] DUMMY_LABELS = new EnumSet[]{LABELS_1, LABELS_2, LABELS_3, LABELS_4};

    private static final EnumSet<Amenity> AMENITIES_1 = EnumSet.of(Amenity.WHEELCHAIR_ACCESSIBLE, Amenity.OUTDOOR_GRILL);
    private static final EnumSet<Amenity> AMENITIES_2 = EnumSet.of(Amenity.IN_UNIT_LAUNDRY);
    private static final EnumSet<Amenity> AMENITIES_3 = EnumSet.of(Amenity.A_C, Amenity.POOL, Amenity.WHEELCHAIR_ACCESSIBLE);
    private static final EnumSet<Amenity> AMENITIES_4 = EnumSet.allOf(Amenity.class);

    public static final EnumSet[] DUMMY_AMENITIES = new EnumSet[]{AMENITIES_1, AMENITIES_2, AMENITIES_3, AMENITIES_4};



}
