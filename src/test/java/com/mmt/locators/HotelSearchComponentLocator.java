package com.mmt.locators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmt.annotations.Locators;

@Locators
@JsonIgnoreProperties(ignoreUnknown = true)
public record HotelSearchComponentLocator(@JsonProperty("location")
                                          String location,
                                          @JsonProperty("locationInput")
                                          String locationInput,
                                          @JsonProperty("location_list")
                                          String locationList,
                                          @JsonProperty("checkInButton")
                                          String checkInButton,
                                          @JsonProperty("dateController")
                                          String dateController,
                                          @JsonProperty("guestLocator")
                                          String guestLocator,
                                          @JsonProperty("roomDetails")
                                          String roomDetails,
                                          @JsonProperty("saveGuest")
                                          String saveGuest,
                                          @JsonProperty("travelForButton")
                                          String travelForButton,
                                          @JsonProperty("travelForOptions")
                                          String travelForOptions,
                                          @JsonProperty("searchButton")
                                          String searchButton) {
}