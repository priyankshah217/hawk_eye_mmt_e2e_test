package com.mmt.pages.factories;

import com.mmt.enums.ServiceOption;
import com.mmt.pages.components.search.FlightSearchComponent;
import com.mmt.pages.components.search.HotelSearchComponent;
import com.mmt.pages.components.search.SearchComponent;

public class SearchComponentFactory {
    public static SearchComponent getInstance(ServiceOption option) {
        return switch (option) {
            case HOTELS -> new HotelSearchComponent();
            case DEFAULT -> new FlightSearchComponent();
        };
    }
}
