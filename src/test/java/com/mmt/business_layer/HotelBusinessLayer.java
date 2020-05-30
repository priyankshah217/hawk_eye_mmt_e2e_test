package com.mmt.business_layer;

import com.mmt.helpers.ServiceOption;
import com.mmt.pages.HomePage;

public class HotelBusinessLayer {

    public void selectHotel() {
        new HomePage()
                .selectService(ServiceOption.HOTELS)
                .populateSearchDetails()
                .search();
    }
}
