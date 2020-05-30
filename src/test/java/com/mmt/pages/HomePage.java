package com.mmt.pages;

import com.mmt.annotations.Page;
import com.mmt.enums.ServiceOption;
import com.mmt.pages.components.search.SearchComponent;
import com.mmt.pages.factories.SearchComponentFactory;
import org.openqa.selenium.By;

@Page
public class HomePage extends BaseUI {
    private String homeUrl = "https://makemytrip.com/";
    private SearchComponent searchComponent;
    private By flightLinkLocator = By.className("menu_Flights");
    private By hotelLinkLocator = By.className("menu_Hotels");

    public HomePage() {
        driver.get(homeUrl);
    }

    public HomePage selectService(ServiceOption option) {
        switch (option) {
            case HOTELS -> getElement(hotelLinkLocator).click();
            case FLIGHTS, DEFAULT -> getElement(flightLinkLocator).click();
        }
        searchComponent = SearchComponentFactory.getInstance(option);
        return this;
    }

    public void search() {
        searchComponent.search();
    }
}
