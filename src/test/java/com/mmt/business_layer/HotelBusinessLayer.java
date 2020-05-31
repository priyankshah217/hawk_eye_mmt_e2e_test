package com.mmt.business_layer;

import com.mmt.enums.ServiceOption;
import com.mmt.pages.HomePage;

public class HotelBusinessLayer {

    public void selectHotel() {
        new HomePage()
                .selectService(ServiceOption.HOTELS)
                .populateSearchDetails()
                .search()
                .applyFilters()
                .selectHotelAtPosition(5)
                .selectRoom();
    }
}
