package com.mmt.ui_layer.factories;

import com.mmt.enums.ServiceOption;
import com.mmt.ui_layer.components.search.FlightSearchComponent;
import com.mmt.ui_layer.components.search.HotelSearchComponent;
import com.mmt.ui_layer.components.search.SearchComponent;

public class SearchComponentFactory {
    public static SearchComponent getInstance(ServiceOption option) {
        return switch (option) {
            case HOTELS -> new HotelSearchComponent();
            case DEFAULT -> new FlightSearchComponent();
        };
    }
}
