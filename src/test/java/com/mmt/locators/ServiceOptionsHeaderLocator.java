package com.mmt.locators;

import com.mmt.helpers.ServiceOption;
import org.openqa.selenium.By;

public class ServiceOptionsHeaderLocator {
    public static By getLocatorFor(ServiceOption option) {
        return switch (option) {
            case HOTELS -> By.className("menu_Hotels");
            case DEFAULT -> By.className("menu_Flights");
        };
    }
}
