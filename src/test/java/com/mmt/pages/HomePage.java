package com.mmt.pages;

import com.mmt.annotations.Page;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.LocatorHelper;
import com.mmt.locators.HomePageLocator;
import com.mmt.pages.components.search.SearchComponent;
import com.mmt.pages.factories.SearchComponentFactory;

@Page
public class HomePage extends BaseUI {
    private static final HomePageLocator homePageLocator = LocatorHelper.getLocators("locators/homepage.yml");
    private String homeUrl = "https://makemytrip.com/";
    private SearchComponent searchComponent;

    public HomePage() {
        driver.get(homeUrl);
    }

    public HomePage selectService(ServiceOption option) {
        switch (option) {
            case HOTELS -> getElement(homePageLocator.hotelOption()).click();
            case FLIGHTS, DEFAULT -> getElement(homePageLocator.flightOption()).click();
        }
        searchComponent = SearchComponentFactory.getInstance(option);
        return this;
    }

    public void search() {
        searchComponent.search();
    }
}
