package com.mmt.ui_layer.components.search;

import com.mmt.ui_layer.pages.hotels.HotelSearchResultPage;
import com.mmt.ui_layer.pages.SearchResultPage;
import org.openqa.selenium.By;

public class HotelSearchComponent extends SearchComponent {
    private By searchButton = By.id("hsw_search_button");
    private By travelFor = By.className("travelFor");
    private By rooms = By.className("roomGuests");
    private By addRooms = By.className("btnAddRoom");
    private By applyRooms = By.className("btnApply");
    private By travelPopup = By.className("travelForPopup");
    private By listElements = By.tagName("li");

    public SearchResultPage search() {
        findElement(searchButton).click();
        return new HotelSearchResultPage();
    }

    public void populateSearchDetails() {
        addRoom();
        selectTravellingFor();
    }

    private void addRoom() {
        findElement(rooms).click();
        findElement(addRooms).click();
        findElement(applyRooms).click();
    }

    private void selectTravellingFor() {
        findElement(travelFor).click();
        findElement(travelPopup).findElements(listElements).get(0).click();
    }

}
