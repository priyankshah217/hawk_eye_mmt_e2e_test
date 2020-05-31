package com.mmt.locators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmt.annotations.Locators;

@Locators
@JsonIgnoreProperties(ignoreUnknown = true)
public record HotelDetailsLocator(@JsonProperty("roomName")
                                  String roomName,
                                  @JsonProperty("selectRoom")
                                  String selectRoom,
                                  @JsonProperty("roomSection")
                                  String roomSection) {
}
