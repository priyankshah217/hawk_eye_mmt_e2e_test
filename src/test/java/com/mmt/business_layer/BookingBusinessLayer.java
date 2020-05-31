package com.mmt.business_layer;

import com.mmt.pages.factories.ReviewBookingPageFactory;

public class BookingBusinessLayer {
    public void addTravellerInformation() {
        ReviewBookingPageFactory.getInstance().addTravellerDetails();
    }
}
