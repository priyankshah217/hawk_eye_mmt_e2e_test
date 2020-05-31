package com.mmt;

import com.mmt.business_layer.HotelBusinessLayer;
import com.mmt.helpers.DriverHelper;
import com.mmt.helpers.RunHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookHotelTest {

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        DriverHelper.createDriver();
        RunHelper.initRunData();
    }

    @Test
    public void shouldBeAbleToSelectHotelsAndProceedToCheckout() {
        new HotelBusinessLayer().selectHotel();
    }
    @AfterMethod
    public void teardown() {
        DriverHelper.getDriver().quit();
    }
}
