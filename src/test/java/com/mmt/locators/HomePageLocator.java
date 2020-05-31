package com.mmt.locators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmt.annotations.Locators;

@Locators
@JsonIgnoreProperties(ignoreUnknown = true)
public record HomePageLocator(
        @JsonProperty("flight_option")
        String flightOption,
        @JsonProperty("hotel_option")
        String hotelOption) {
}