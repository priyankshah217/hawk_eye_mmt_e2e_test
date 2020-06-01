package com.mmt.helpers;

public class BrowserHelper {
    public static void launchUrl(String url) {
        DriverHelper.getDriver().get(url);
    }
}
