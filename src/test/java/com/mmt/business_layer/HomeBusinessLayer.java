package com.mmt.business_layer;


import com.mmt.enums.ServiceOption;
import com.mmt.ui_layer.pages.HomePage;

public class HomeBusinessLayer {
    private HomePage homePage;

    public HomeBusinessLayer() {
        homePage = new HomePage();
    }

    public void selectHotel() {
        homePage.selectService(ServiceOption.HOTELS).search();
    }

    public void selectFlight() {
        homePage.selectService(ServiceOption.FLIGHTS).search();
    }
}
