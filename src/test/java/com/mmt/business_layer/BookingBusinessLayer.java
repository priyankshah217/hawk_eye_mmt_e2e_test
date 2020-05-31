package com.mmt.business_layer;

import com.mmt.ui_layer.factories.ReviewBookingPageFactory;

public class BookingBusinessLayer {
    public void confirmHotel() {
        int numberOfSpecialRequestsToAdd = 2;

        ReviewBookingPageFactory.getInstance()
                .addTravellerDetails()
                .addSpecialRequests(numberOfSpecialRequestsToAdd)
                .removeDonations()
                .proceedToPay();
    }
}
