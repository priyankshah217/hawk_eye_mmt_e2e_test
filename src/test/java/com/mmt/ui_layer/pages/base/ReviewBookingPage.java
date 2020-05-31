package com.mmt.ui_layer.pages.base;

public abstract class ReviewBookingPage extends UILayer {
    public abstract ReviewBookingPage addTravellerDetails();

    public abstract ReviewBookingPage addSpecialRequests(int numberOfSpecialRequests);

    public abstract ReviewBookingPage removeDonations();

    public abstract void proceedToPay();
}
