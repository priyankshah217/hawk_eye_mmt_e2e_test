package com.mmt.helpers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;

public class CapabilityHelper {
    public static Capabilities capabilities;

    public static Capabilities getCapabilities(String browser) {
        return switch (browser) {
            case BrowserType.FIREFOX -> BrowserOptionsManager.getFirefoxOptions();
            case BrowserType.CHROME -> BrowserOptionsManager.getChromeOptions();
            default -> throw new RuntimeException("Browser type not supported");
        };
    }
}
