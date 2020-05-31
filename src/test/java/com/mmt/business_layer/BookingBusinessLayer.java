package com.mmt.business_layer;

import com.mmt.ui_layer.factories.ReviewBookingPageFactory;

public class BookingBusinessLayer {
    public void addTravellerInformation() {
        ReviewBookingPageFactory.getInstance().addTravellerDetails();
    }
}
