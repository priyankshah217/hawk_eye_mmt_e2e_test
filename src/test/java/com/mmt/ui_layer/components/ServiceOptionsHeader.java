package com.mmt.ui_layer.components;

import com.mmt.enums.ServiceOption;
import com.mmt.ui_layer.UILayer;

import static com.mmt.locators.ServiceOptionsHeaderLocator.getLocatorFor;

public class ServiceOptionsHeader extends UILayer {
    public void select(ServiceOption option) {
        var optionLocator = getLocatorFor(option);
        driver.findElement(optionLocator).click();
    }
}
