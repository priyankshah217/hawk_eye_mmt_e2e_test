package com.mmt.data_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmt.annotations.Data;

@Data
public record Traveller(
        @JsonProperty("firstName")String firstName,
        @JsonProperty("lastName")String lastName,
        @JsonProperty("email")String email,
        @JsonProperty("mobileNumber")String mobileNumber) {
}
