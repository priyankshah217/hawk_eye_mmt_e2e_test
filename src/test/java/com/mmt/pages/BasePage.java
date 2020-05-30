package com.mmt.pages;

import com.mmt.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected WebDriver driver = DriverHelper.getDriver();
    private int maxWaitTime = 30;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    protected WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
