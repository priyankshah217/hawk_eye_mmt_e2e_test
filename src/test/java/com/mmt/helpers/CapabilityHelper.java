package com.mmt.helpers;

import org.openqa.selenium.Capabilities;

public class CapabilityHelper {
    public static Capabilities capabilities;

    public static Capabilities getCapabilities(String browser) {
        if (browser.toLowerCase().contains("firefox")) {
            capabilities = BrowserOptionsManager.getFirefoxOptions();
        } else {
            capabilities = BrowserOptionsManager.getChromeOptions();
        }
        return capabilities;
    }
}
