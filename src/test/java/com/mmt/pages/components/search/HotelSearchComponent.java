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

    public void search() {
        getElement(location).click();
        getElement(locationInput).sendKeys("Mumbai");
        getElements(locationList).stream().findFirst().get().click();
        getElement(checkInButton).click();
        List<WebElement> webElementList = getCheckinDates();
        webElementList.get(1).click();
        webElementList.get(5).click();
        System.out.println("End");
    }

    @NotNull
    private List<WebElement> getCheckinDates() {
        return getElements(dateController)
                .stream()
                .filter(webElement -> webElement.getAttribute("aria-disabled").equals("false"))
                .collect(Collectors.toList());
    }
}
