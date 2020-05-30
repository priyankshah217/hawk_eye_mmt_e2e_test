package com.mmt;

import com.mmt.business_layer.HomeBusinessLayer;
import com.mmt.helpers.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookHotelTest {

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        DriverHelper.createDriver();
    }

    @Test
    public void shouldBeAbleToSelectHotelsAndProceedToCheckout() {
        new HomeBusinessLayer()
                .selectHotel();
    }

    @AfterClass
    public void teardown() {
        DriverHelper.getDriver().quit();
    }
}
