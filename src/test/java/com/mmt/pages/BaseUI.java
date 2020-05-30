package com.mmt.pages;

import com.mmt.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

abstract public class BaseUI {
    private final int maxWaitTime = 30;
    protected WebDriver driver = DriverHelper.getDriver();

    public WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> isElementPresent(locator)) ?
                driver.findElement(locator) : null;
    }

    public List<WebElement> getElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> isElementPresent(locator)) ?
                driver.findElements(locator) : null;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}