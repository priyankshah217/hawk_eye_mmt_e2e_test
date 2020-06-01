package com.mmt.locators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmt.annotations.Locators;

@Locators
@JsonIgnoreProperties(ignoreUnknown = true)
public record HotelReviewBookingLocator(
        @JsonProperty("roomName")
        String firstName,
        @JsonProperty("lastName")
        String lastName,
        @JsonProperty("email")
        String email,
        @JsonProperty("mobileNumber")
        String mobileNumber,
        @JsonProperty("specialRequests")
        String specialRequests,
        @JsonProperty("donation")
        String donation,
        @JsonProperty("paymentButton")
        String paymentButton) {
}
