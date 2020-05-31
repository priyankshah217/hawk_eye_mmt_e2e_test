package com.mmt.pages;

import com.mmt.pages.hotels.HotelDetailsPage;

public abstract class SearchResultPage extends BasePage {
    public abstract SearchResultPage applyFilters();

    public abstract HotelDetailsPage selectHotelAtPosition(int position);
}
