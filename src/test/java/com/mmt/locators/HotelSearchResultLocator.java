package com.mmt.locators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmt.annotations.Locators;

@Locators
@JsonIgnoreProperties(ignoreUnknown = true)
public record HotelSearchResultLocator(@JsonProperty("backdrop")
                                       String backdrop,
                                       @JsonProperty("priceSlider")
                                       String priceSlider,
                                       @JsonProperty("minValue")
                                       String minValue,
                                       @JsonProperty("userRating")
                                       String userRating,
                                       @JsonProperty("userRatingsItems")
                                       String userRatingsItems,
                                       @JsonProperty("results")
                                       String results,
                                       @JsonProperty("hotelNameLocator")
                                       String hotelNameLocator) {
}
