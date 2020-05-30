package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.stream.Collectors;

public class HotelSearchResultPage extends SearchResultPage {
    private By backdrop = By.className("mmBackdrop");
    private By priceSlider = By.className("input-range__slider");
    private By minValue = By.className("minValue");
    private By userRating = By.id("hlistpg_fr_user_rating");
    private String minimumUserRating = "4";
    private By userRatingsItems = By.tagName("li");

    private final int maxSliderMoves = 3;
    private final String requiredMinPrice = "INR 1000";

    public SearchResultPage applyFilters() {
        dismissBackdrop();
        applyMinPriceFilter(maxSliderMoves);
        applyRatingFilter();
        return this;
    }

    private void dismissBackdrop() {
        findElement(backdrop).click();
    }

    private void applyMinPriceFilter(int maxTries) {
        scrollToElement(priceSlider);
        if (isNotRequiredPrice() && maxTries > 0) {
            findElement(priceSlider).sendKeys(Keys.ARROW_RIGHT);
            applyMinPriceFilter(--maxTries);
        }
    }

    private boolean isNotRequiredPrice() {
        return !findElement(minValue).getText().equals(requiredMinPrice);
    }

    private void applyRatingFilter() {
        scrollToElement(userRating);
        findElement(userRating).findElements(userRatingsItems).stream()
                .filter(e -> e.getText().contains(minimumUserRating))
                .collect(Collectors.toList())
                .get(0)
                .click();
    }
}
