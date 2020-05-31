package com.mmt.business_layer;

import com.mmt.enums.CommonRunVariables;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.RunHelper;
import com.mmt.pages.HomePage;

public class HotelBusinessLayer {

    public HotelBusinessLayer() {
        RunHelper.addRunData(CommonRunVariables.SERVICE_OPTION, ServiceOption.HOTELS);
    }

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
