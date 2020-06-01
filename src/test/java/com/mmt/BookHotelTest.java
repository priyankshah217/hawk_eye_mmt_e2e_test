package com.mmt;

import com.mmt.business_layer.BookingBusinessLayer;
import com.mmt.business_layer.HotelBusinessLayer;
import com.mmt.helpers.BrowserHelper;
import com.mmt.helpers.DriverHelper;
import com.mmt.helpers.RunHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BookHotelTest {

    @BeforeMethod
    @Parameters(value = {"browserName", "hubUrl", "url"})
    public void setup(String browserName, String hubUrl, String url) throws MalformedURLException {
        DriverHelper.createDriver(browserName, hubUrl);
        BrowserHelper.launchUrl(url);
        RunHelper.initRunData();
    }

    @Test
    public void shouldBeAbleToSelectHotelsAndProceedToCheckout() {
        new HotelBusinessLayer().selectHotel();
        new BookingBusinessLayer().confirmHotel();
    }

    @AfterMethod
    public void teardown() {
        DriverHelper.quitDriver();
    }
}
