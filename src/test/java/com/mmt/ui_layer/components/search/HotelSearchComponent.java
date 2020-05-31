package com.mmt.ui_layer.components.search;

import com.mmt.annotations.PageComponent;
import com.mmt.helpers.LocatorHelper;
import com.mmt.locators.HotelSearchComponentLocator;
import com.mmt.ui_layer.pages.base.SearchResultPage;
import com.mmt.ui_layer.pages.hotels.HotelSearchResultPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@PageComponent
public class HotelSearchComponent extends SearchComponent {
    private static final HotelSearchComponentLocator hotelSearchComponentLocator = LocatorHelper.getLocators("locators/hotelsearchcomponent.yml");


    public SearchResultPage search() {
        getElement(hotelSearchComponentLocator.searchButton()).click();
        return new HotelSearchResultPage();
    }

    public void populateSearchDetails() {
        getElement(Objects.requireNonNull(hotelSearchComponentLocator).location()).click();
        getElement(hotelSearchComponentLocator.locationInput()).sendKeys("Goa");
        getElements(hotelSearchComponentLocator.locationList()).stream().findFirst().get().click();
        getElement(hotelSearchComponentLocator.checkInButton()).click();
        List<WebElement> webElementList = getCheckinDates();
        webElementList.get(1).click();
        webElementList.get(5).click();
        addRoom();
        selectTravellingFor();
    }

    private void addRoom() {
        getElement(hotelSearchComponentLocator.guestLocator()).click();
        List<WebElement> guestList = getGuestList();
        guestList.get(3).click();
        guestList.get(13).click();
        getElement(hotelSearchComponentLocator.saveGuest()).click();
    }

    private void selectTravellingFor() {
        getElement(Objects.requireNonNull(hotelSearchComponentLocator).travelForButton()).click();
        getElement(hotelSearchComponentLocator.travelForOptions()).findElements(By.tagName("li")).get(0).click();
    }

    @NotNull
    private List<WebElement> getGuestList() {
        return getElements(Objects.requireNonNull(hotelSearchComponentLocator).roomDetails())
                .stream()
                .filter(webElement -> !webElement.getText().isBlank())
                .flatMap(webElement -> webElement.findElements(By.tagName("li")).stream())
                .collect(Collectors.toList());
    }

    @NotNull
    private List<WebElement> getCheckinDates() {
        return getElements(Objects.requireNonNull(hotelSearchComponentLocator).dateController())
                .stream()
                .filter(webElement -> webElement.getAttribute("aria-disabled").equals("false"))
                .collect(Collectors.toList());
    }

}
