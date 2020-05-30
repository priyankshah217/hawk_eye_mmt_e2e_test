package com.mmt.business_layer;

import com.mmt.helpers.ServiceOption;
import com.mmt.pages.HomePage;
import com.mmt.pages.HotelDetailsPage;

public class HotelBusinessLayer {

    public HotelDetailsPage selectHotel() {
        return new HomePage()
                .selectService(ServiceOption.HOTELS)
                .populateSearchDetails()
                .search()
                .applyFilters()
                .selectHotelAtPosition(5);
    }
}
