package com.mmt.ui_layer.pages.base;

import com.mmt.ui_layer.pages.hotels.HotelDetailsPage;

public abstract class SearchResultPage extends UILayer {
    public abstract SearchResultPage applyFilters();

    public abstract HotelDetailsPage selectHotelAtPosition(int position);
}
