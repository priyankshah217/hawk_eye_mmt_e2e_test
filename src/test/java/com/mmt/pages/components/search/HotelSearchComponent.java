package com.mmt.pages.components.search;

import com.mmt.pages.HotelSearchResultPage;
import com.mmt.pages.SearchResultPage;
import org.openqa.selenium.By;

public class HotelSearchComponent extends SearchComponent {
    private By searchButton = By.id("hsw_search_button");
    private By travelFor = By.className("travelFor");
    private By travelPopup = By.className("travelForPopup");
    private By listElements = By.tagName("li");

    public SearchResultPage search() {
        driver.findElement(searchButton).click();
        return new HotelSearchResultPage();
    }

    public void populateSearchDetails() {
        selectTravellingFor();
    }

    private void selectTravellingFor() {
        findElement(travelFor).click();
        findElement(travelPopup).findElements(listElements).get(0).click();
    }

}
