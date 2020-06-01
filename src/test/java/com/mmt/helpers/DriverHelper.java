package com.mmt.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHelper {
    private static ThreadLocal<WebDriver> webDriverThreadLocal;


    public static void createDriver(String browserName, String hubUrl) throws MalformedURLException {
        final WebDriver webDriver = hubUrl != null ? getRemoteWebDriver(browserName, hubUrl) : getLocalWebDriver(browserName);
        if (webDriverThreadLocal == null) {
            webDriverThreadLocal = ThreadLocal.withInitial(() -> webDriver);
        }
        webDriverThreadLocal.set(webDriver);
    }

    public static void createDriver(String browserName) throws MalformedURLException {
        createDriver(browserName, null);
    }

    private static WebDriver getRemoteWebDriver(String browserName, String hubUrl) throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubUrl), CapabilityHelper.getCapabilities(browserName));
    }

    @NotNull
    private static WebDriver getLocalWebDriver(String browserName) {
        return browserName.contains("chrome") ? getChromeDriver() : getFirefoxDriver();
    }

    @NotNull
    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @NotNull
    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void quitDriver() {
        WebDriver webDriver = webDriverThreadLocal.get();
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }
}