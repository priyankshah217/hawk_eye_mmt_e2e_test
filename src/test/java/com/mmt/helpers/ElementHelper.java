package com.mmt.helpers;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ElementHelper {

    private static final int maxWaitTime = 30;

    public static WebElement getElement(String locator) {
        By by = extractLocatorFromString(locator);
        return getElement(by);
    }

    public static List<WebElement> getElements(String locator) {
        By by = extractLocatorFromString(locator);
        return getElements(by);
    }

    @NotNull
    private static By extractLocatorFromString(String locator) {
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

    private static WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(maxWaitTime));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> isElementPresent(locator)) ?
                DriverHelper.getDriver().findElement(locator) : null;
    }

    private static List<WebElement> getElements(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(maxWaitTime));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> isElementPresent(locator)) ?
                DriverHelper.getDriver().findElements(locator) : null;
    }

    public static boolean isElementPresent(By locator) {
        try {
            DriverHelper.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public static void scrollToElement(String locator) {
        WebElement element = getElement(locator);
        Actions actions = new Actions(DriverHelper.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public static void switchToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(DriverHelper.getDriver().getWindowHandles());
        DriverHelper.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }
}
