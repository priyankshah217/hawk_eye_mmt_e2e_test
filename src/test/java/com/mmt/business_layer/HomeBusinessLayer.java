package com.mmt.business_layer;

import com.mmt.helpers.ServiceOption;
import com.mmt.pages.HomePage;

public class HomeBusinessLayer {
    private HomePage homePage;

    public HomeBusinessLayer() {
        homePage = new HomePage();
    }

    public void selectHotel() {
        homePage.selectService(ServiceOption.HOTELS);
    }
}
