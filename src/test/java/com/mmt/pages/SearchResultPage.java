package com.mmt.pages;

public abstract class SearchResultPage extends BasePage {
    public abstract SearchResultPage applyFilters();

    public abstract HotelDetailsPage selectHotelAtPosition(int position);
}
