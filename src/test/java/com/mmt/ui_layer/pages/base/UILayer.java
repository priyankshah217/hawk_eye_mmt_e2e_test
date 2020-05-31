package com.mmt.ui_layer.pages.base;

import com.mmt.helpers.DriverHelper;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

abstract public class UILayer {
    private final int maxWaitTime = 30;
    protected WebDriver driver = DriverHelper.getDriver();

    public WebElement getElement(String locator) {
        By by = extractLocatorFromString(locator);
        return getElement(by);
    }

    public List<WebElement> getElements(String locator) {
        By by = extractLocatorFromString(locator);
        return getElements(by);
    }

    @NotNull
    private By extractLocatorFromString(String locator) {
        String locatorBy = locator.split(":")[0];
        String locatorString = locator.split(":")[1];
        return switch (locatorBy) {
            case "id" -> By.id(locatorString);
            case "css" -> By.cssSelector(locatorString);
            case "class" -> By.className(locatorString);
            case "tag" -> By.tagName(locatorString);
            case "xpath" -> By.xpath(locatorString);
            case "link" -> By.linkText(locatorString);
            case "partial_link" -> By.partialLinkText(locatorString);
            default -> throw new RuntimeException("No locator supported");
        };
    }

    private WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> isElementPresent(locator)) ?
                driver.findElement(locator) : null;
    }

    private List<WebElement> getElements(By locator) {
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

    protected void scrollToElement(String locator) {
        WebElement element = getElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    protected void switchToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
