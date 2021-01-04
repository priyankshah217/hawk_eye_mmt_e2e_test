package com.mmt.ui_layer.pages.hotels;

import com.mmt.annotations.Page;
import com.mmt.data_models.Traveller;
import com.mmt.helpers.ElementHelper;
import com.mmt.helpers.LocatorHelper;
import com.mmt.locators.HotelReviewBookingLocator;
import com.mmt.ui_layer.pages.base.ReviewBookingPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static com.mmt.helpers.ResourceHelper.getData;

@Page
public class HotelReviewBookingPage extends ReviewBookingPage {

    @NotNull
    private static final HotelReviewBookingLocator hotelReviewBookingLocator = Objects.requireNonNull(LocatorHelper.getLocators("locators/hotelreviewbooking.yml"));
    Traveller traveller = getData("data/traveller.yml");

    public HotelReviewBookingPage addTravellerDetails() {
        ElementHelper.getElement(hotelReviewBookingLocator.firstName()).sendKeys(traveller.firstName());
        ElementHelper.getElement(hotelReviewBookingLocator.lastName()).sendKeys(traveller.lastName());
        ElementHelper.getElement(hotelReviewBookingLocator.email()).sendKeys(traveller.email());
        ElementHelper.getElement(hotelReviewBookingLocator.email()).sendKeys(traveller.mobileNumber());
        return this;
    }

    public HotelReviewBookingPage addSpecialRequests(int numberOfSpecialRequests) {
        List<WebElement> availableSpecialRequests = ElementHelper.getElements(hotelReviewBookingLocator.specialRequests());
        int specialRequestsToSelect = Math.min(availableSpecialRequests.size(), numberOfSpecialRequests);
        availableSpecialRequests.subList(0, specialRequestsToSelect).forEach(WebElement::click);
        return this;
    }

    public ReviewBookingPage removeDonations() {
        ElementHelper.getElement(hotelReviewBookingLocator.donation()).click();
        return this;
    }

    @Override
    public void proceedToPay() {
        ElementHelper.getElement(hotelReviewBookingLocator.paymentButton()).click();
    }
}
