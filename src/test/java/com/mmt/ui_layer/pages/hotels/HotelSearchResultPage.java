package com.mmt.ui_layer.pages.hotels;

import com.mmt.annotations.Page;
import com.mmt.enums.HotelDetail;
import com.mmt.helpers.LocatorHelper;
import com.mmt.helpers.RunHelper;
import com.mmt.locators.HotelSearchResultLocator;
import com.mmt.ui_layer.pages.base.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Objects;
import java.util.stream.Collectors;

@Page
public class HotelSearchResultPage extends SearchResultPage {
    private static final HotelSearchResultLocator hotelSearchResultLocator = LocatorHelper.getLocators("locators/hotelsearchresult.yml");
    private String minimumUserRating = "4";
    private By hotelNameLocator = By.id("hlistpg_hotel_name");
    private final int maxSliderMoves = 3;
    private final String requiredMinPrice = "INR 1000";
    private By userRatingsItems = By.tagName("li");

    public SearchResultPage applyFilters() {
        dismissBackdrop();
        applyMinPriceFilter(maxSliderMoves);
        applyRatingFilter();
        return this;
    }

    public HotelDetailsPage selectHotelAtPosition(int position) {
        WebElement selectedHotel = getElements(Objects.requireNonNull(hotelSearchResultLocator).results()).get(position);
        storeHotelDetails(selectedHotel);
        selectedHotel.click();
        switchToLastTab();
        return new HotelDetailsPage();
    }

    private void storeHotelDetails(WebElement selectedHotel) {
        String hotelName = selectedHotel.findElement(hotelNameLocator).getText();
        RunHelper.addRunData(HotelDetail.HOTEL_NAME, hotelName);
    }

    private void dismissBackdrop() {
        getElement(Objects.requireNonNull(hotelSearchResultLocator).backdrop()).click();
    }

    private void applyMinPriceFilter(int maxTries) {
        scrollToElement(Objects.requireNonNull(hotelSearchResultLocator).priceSlider());
        if (isNotRequiredPrice() && maxTries > 0) {
            getElement(Objects.requireNonNull(hotelSearchResultLocator).priceSlider()).sendKeys(Keys.ARROW_RIGHT);
            applyMinPriceFilter(--maxTries);
        }
    }

    private boolean isNotRequiredPrice() {
        return !getElement(Objects.requireNonNull(hotelSearchResultLocator).minValue())
                .getText().equals(requiredMinPrice);
    }

    private void applyRatingFilter() {
        scrollToElement(Objects.requireNonNull(hotelSearchResultLocator).userRating());
        getElement(Objects.requireNonNull(hotelSearchResultLocator).userRating())
                .findElements(userRatingsItems).stream()
                .filter(e -> e.getText().contains(minimumUserRating))
                .collect(Collectors.toList())
                .get(0)
                .click();
    }
}
