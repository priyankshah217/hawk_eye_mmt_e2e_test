package com.mmt.pages.components.search;

import org.openqa.selenium.By;

public class HotelSearchComponent extends SearchComponent {
    private By searchButton = By.id("hsw_search_button");

    public void search() {
        driver.findElement(searchButton).click();
    }
}
