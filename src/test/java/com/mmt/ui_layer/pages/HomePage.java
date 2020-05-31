package com.mmt.ui_layer.pages;

import com.mmt.annotations.Page;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.LocatorHelper;
import com.mmt.locators.HomePageLocator;
import com.mmt.ui_layer.components.search.SearchComponent;
import com.mmt.ui_layer.factories.SearchComponentFactory;
import com.mmt.ui_layer.pages.base.SearchResultPage;
import com.mmt.ui_layer.pages.base.UILayer;

import java.util.Objects;

@Page
public class HomePage extends UILayer {
    private static final HomePageLocator homePageLocator = LocatorHelper.getLocators("locators/homepage.yml");
    private String homeUrl = "https://makemytrip.com/";
    private SearchComponent searchComponent;


    public HomePage() {
        driver.get(homeUrl);
    }

    public HomePage selectService(ServiceOption option) {
        switch (option) {
            case HOTELS -> getElement(Objects.requireNonNull(homePageLocator).hotelOption()).click();
            case FLIGHTS, DEFAULT -> getElement(Objects.requireNonNull(homePageLocator).flightOption()).click();
        }
        searchComponent = SearchComponentFactory.getInstance(option);
        return this;
    }

    public HomePage populateSearchDetails() {
        searchComponent.populateSearchDetails();
        return this;
    }

    public SearchResultPage search() {
        return searchComponent.search();
    }
}
