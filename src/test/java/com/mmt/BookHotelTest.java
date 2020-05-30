package com.mmt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookHotelTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test() {
        driver = new ChromeDriver();
        driver.get("https://makemytrip.com/");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
