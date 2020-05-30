package com.mmt.pages;

import com.mmt.helpers.DriverHelper;
import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    protected WebDriver driver = DriverHelper.getDriver();
}
