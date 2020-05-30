package com.mmt.pages;

import com.mmt.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

abstract public class BasePage {
    protected WebDriver driver = DriverHelper.getDriver();
    private final int maxWaitTime = 30;
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));

    protected WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElements(locator);
    }

    protected void scrollToElement(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
