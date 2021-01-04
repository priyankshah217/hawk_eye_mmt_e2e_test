package com.mmt.ui_layer.pages.hotels;

import com.mmt.annotations.Page;
import com.mmt.enums.HotelDetail;
import com.mmt.helpers.ElementHelper;
import com.mmt.helpers.LocatorHelper;
import com.mmt.helpers.RunHelper;
import com.mmt.locators.HotelSearchResultLocator;
import com.mmt.ui_layer.pages.base.SearchResultPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Objects;
import java.util.stream.Collectors;

@Page
public class HotelSearchResultPage extends SearchResultPage {
    @NotNull
    private static final HotelSearchResultLocator hotelSearchResultLocator = Objects.requireNonNull(LocatorHelper.getLocators("locators/hotelsearchresult.yml"));
    private final String minimumUserRating = "4";
    private final By hotelNameLocator = By.id("hlistpg_hotel_name");
    private final int maxSliderMoves = 3;
    private final String requiredMinPrice = "INR 1000";
    private final By userRatingsItems = By.tagName("li");

    public SearchResultPage applyFilters() {
        dismissBackdrop();
        applyMinPriceFilter(maxSliderMoves);
        applyRatingFilter();
        return this;
    }

    public HotelDetailsPage selectHotelAtPosition(int position) {
        WebElement selectedHotel = ElementHelper.getElements(hotelSearchResultLocator.results()).get(position);
        storeHotelDetails(selectedHotel);
        selectedHotel.click();
        ElementHelper.switchToLastTab();
        return new HotelDetailsPage();
    }

    private void storeHotelDetails(WebElement selectedHotel) {
        String hotelName = selectedHotel.findElement(hotelNameLocator).getText();
        RunHelper.addRunData(HotelDetail.HOTEL_NAME, hotelName);
    }

    private void dismissBackdrop() {
        ElementHelper.getElement(hotelSearchResultLocator.backdrop()).click();
    }

    private void applyMinPriceFilter(int maxTries) {
        ElementHelper.scrollToElement(hotelSearchResultLocator.priceSlider());
        if (isNotRequiredPrice() && maxTries > 0) {
            ElementHelper.getElement(hotelSearchResultLocator.priceSlider()).sendKeys(Keys.ARROW_RIGHT);
            applyMinPriceFilter(--maxTries);
        }
    }

    private boolean isNotRequiredPrice() {
        return !ElementHelper.getElement(hotelSearchResultLocator.minValue())
                .getText().equals(requiredMinPrice);
    }

    private void applyRatingFilter() {
        ElementHelper.scrollToElement(hotelSearchResultLocator.userRating());
        ElementHelper.getElement(hotelSearchResultLocator.userRating())
                .findElements(userRatingsItems).stream()
                .filter(e -> e.getText().contains(minimumUserRating))
                .collect(Collectors.toList())
                .get(0)
                .click();
    }
}
