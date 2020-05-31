package com.mmt.data;

public enum TravellerData {
    FirstName("Headspin"),
    LastName("Hackathon"),
    Email("mmt.hackathon@gmail.com"),
    MobileNumber("1122334455");

    private final String value;

    TravellerData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}