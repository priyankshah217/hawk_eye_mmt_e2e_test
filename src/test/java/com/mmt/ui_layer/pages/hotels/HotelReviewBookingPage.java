package com.mmt.ui_layer.pages.hotels;

import com.mmt.data.TravellerData;
import com.mmt.ui_layer.pages.ReviewBookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HotelReviewBookingPage extends ReviewBookingPage {
    private By firstName = By.id("fName");
    private By lastName = By.id("lName");
    private By email = By.id("email");
    private By mobileNumber = By.id("mNo");
    private By specialRequests = By.cssSelector("._SpecialRequest li");
    private By donation = By.cssSelector(".donationOuter .checkmarkOuter");
    private By paymentButton = By.className("btnPayNow");

    public HotelReviewBookingPage addTravellerDetails() {
        findElement(firstName).sendKeys(TravellerData.FirstName.getValue());
        findElement(lastName).sendKeys(TravellerData.LastName.getValue());
        findElement(email).sendKeys(TravellerData.Email.getValue());
        findElement(mobileNumber).sendKeys(TravellerData.MobileNumber.getValue());
        return this;
    }

    public HotelReviewBookingPage addSpecialRequests(int numberOfSpecialRequests) {
        List<WebElement> availableSpecialRequests = findElements(specialRequests);
        int specialRequestsToSelect = Math.min(availableSpecialRequests.size(), numberOfSpecialRequests);
        availableSpecialRequests.subList(0, specialRequestsToSelect).forEach(WebElement::click);
        return this;
    }

    public ReviewBookingPage removeDonations() {
        findElement(donation).click();
        return this;
    }

    @Override
    public void proceedToPay() {
        findElement(paymentButton).click();
    }
}
