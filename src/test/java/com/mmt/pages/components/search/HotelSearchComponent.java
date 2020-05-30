package com.mmt.pages.components.search;

import com.mmt.annotations.PageComponent;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@PageComponent
public class HotelSearchComponent extends SearchComponent {
    private By searchButton = By.id("hsw_search_button");
    private By location = By.id("city");
    private By locationInput = By.cssSelector(".react-autosuggest__input");
    private By locationList = By.id("react-autowhatever-1");
    private By checkInButton = By.id("checkin");
    private By dateController = By.className("DayPicker-Day");
    private By guestLocator = By.id("guest");
    private By roomDetails = By.className("addRooomDetails");
    private By saveGuestInfo = By.cssSelector("button.primaryBtn.btnApply");
    private By travelForButton = By.cssSelector("div.hsw_inputBox.travelFor");
    private By travelForOptions = By.cssSelector("div.hsw_inputBox.travelFor.inactiveWidget.activeWidget > ul");
    private By backdropBackground = By.className("overlayHighlight");

    public void search() {
        getElement(location).click();
        getElement(locationInput).sendKeys("Mumbai");
        getElements(locationList).stream().findFirst().get().click();
        getElement(checkInButton).click();
        List<WebElement> webElementList = getCheckinDates();
        webElementList.get(1).click();
        webElementList.get(5).click();
        getElement(guestLocator).click();
        List<WebElement> guestList = getGuestList();
        guestList.get(3).click();
        guestList.get(13).click();
        getElement(saveGuestInfo).click();
        getElement(travelForButton).click();
        getElement(travelForOptions).findElements(By.tagName("li")).get(0).click();
        getElement(searchButton).click();
    }

    @NotNull
    private List<WebElement> getGuestList() {
        return getElements(roomDetails)
                .stream()
                .filter(webElement -> !webElement.getText().isBlank())
                .flatMap(webElement -> webElement.findElements(By.tagName("li")).stream())
                .collect(Collectors.toList());
    }

    @NotNull
    private List<WebElement> getCheckinDates() {
        return getElements(dateController)
                .stream()
                .filter(webElement -> webElement.getAttribute("aria-disabled").equals("false"))
                .collect(Collectors.toList());
    }
}
