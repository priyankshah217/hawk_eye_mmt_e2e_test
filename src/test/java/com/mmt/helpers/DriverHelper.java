package com.mmt.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    private static ThreadLocal<WebDriver> webDriverThreadLocal;

    public static void createDriver() {
        final WebDriver driver = new ChromeDriver();
        if (webDriverThreadLocal == null) {
            webDriverThreadLocal = ThreadLocal.withInitial(() -> driver);
        }
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }
}