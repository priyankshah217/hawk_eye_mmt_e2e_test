package com.mmt.pages.components.search;

import com.mmt.annotations.PageComponent;
import com.mmt.helpers.LocatorHelper;
import com.mmt.locators.HotelSearchComponentLocator;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@PageComponent
public class HotelSearchComponent extends SearchComponent {

    private static final HotelSearchComponentLocator hotelSearchComponentLocator = LocatorHelper.getLocators("locators/hotelsearchcomponent.yml");

    public void search() {
        getElement(hotelSearchComponentLocator.location()).click();
        getElement(hotelSearchComponentLocator.locationInput()).sendKeys("Mumbai");
        getElements(hotelSearchComponentLocator.locationList()).stream().findFirst().get().click();
        getElement(hotelSearchComponentLocator.checkInButton()).click();
        List<WebElement> webElementList = getCheckinDates();
        webElementList.get(1).click();
        webElementList.get(5).click();
        getElement(hotelSearchComponentLocator.guestLocator()).click();
        List<WebElement> guestList = getGuestList();
        guestList.get(3).click();
        guestList.get(13).click();
        getElement(hotelSearchComponentLocator.saveGuest()).click();
        getElement(hotelSearchComponentLocator.travelForButton()).click();
        getElement(hotelSearchComponentLocator.travelForOptions()).findElements(By.tagName("li")).get(0).click();
        getElement(hotelSearchComponentLocator.searchButton()).click();
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
