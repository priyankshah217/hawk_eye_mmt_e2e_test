package com.mmt.ui_layer.pages.hotels;

import com.mmt.data_models.Traveller;
import com.mmt.ui_layer.pages.ReviewBookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.mmt.helpers.ResourceHelper.getData;

public class HotelReviewBookingPage extends ReviewBookingPage {
    private By firstName = By.id("fName");
    private By lastName = By.id("lName");
    private By email = By.id("email");
    private By mobileNumber = By.id("mNo");
    private By specialRequests = By.cssSelector("._SpecialRequest li");
    private By donation = By.cssSelector(".donationOuter .checkmarkOuter");
    private By paymentButton = By.className("btnPayNow");
    Traveller traveller = getData("data/traveller.yml");

    public HotelReviewBookingPage addTravellerDetails() {
        findElement(firstName).sendKeys(traveller.firstName());
        findElement(lastName).sendKeys(traveller.lastName());
        findElement(email).sendKeys(traveller.email());
        findElement(mobileNumber).sendKeys(traveller.mobileNumber());
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
