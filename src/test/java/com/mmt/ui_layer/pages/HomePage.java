package com.mmt.ui_layer.pages;

import com.mmt.annotations.Page;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.LocatorHelper;
import com.mmt.locators.HomePageLocator;
import com.mmt.ui_layer.components.search.SearchComponent;
import com.mmt.ui_layer.factories.SearchComponentFactory;
import com.mmt.ui_layer.pages.base.SearchResultPage;
import com.mmt.ui_layer.pages.base.UILayer;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Page
public class HomePage extends UILayer {
    private static final HomePageLocator homePageLocator = LocatorHelper.getLocators("locators/homepage.yml");
    private SearchComponent searchComponent;

    public HomePage selectService(ServiceOption option) {
        WebElement selectedOption = switch (option) {
            case HOTELS -> getElement(Objects.requireNonNull(homePageLocator).hotelOption());
            case FLIGHTS, DEFAULT -> getElement(Objects.requireNonNull(homePageLocator).flightOption());
        };
        selectedOption.click();
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
