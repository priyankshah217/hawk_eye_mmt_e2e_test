package com.mmt.pages.components;

import com.mmt.helpers.ServiceOption;
import com.mmt.pages.BasePage;

import static com.mmt.locators.ServiceOptionsHeaderLocator.getLocatorFor;

public class ServiceOptionsHeader extends BasePage {
    public void select(ServiceOption option) {
        var optionLocator = getLocatorFor(option);
        driver.findElement(optionLocator).click();
    }
}
