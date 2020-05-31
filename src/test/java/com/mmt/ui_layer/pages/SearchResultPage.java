package com.mmt.ui_layer.pages;

import com.mmt.ui_layer.UILayer;
import com.mmt.ui_layer.pages.hotels.HotelDetailsPage;

public abstract class SearchResultPage extends UILayer {
    public abstract SearchResultPage applyFilters();

    public abstract HotelDetailsPage selectHotelAtPosition(int position);
}
