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
    @Parameters(value = {"browserName", "run", "hubUrl", "url"})
    public void setup(String browserName, String run, String hubUrl, String url) throws MalformedURLException {
        if (isRemoteRun(run, hubUrl)) {
            DriverHelper.createDriver(browserName.toLowerCase(), hubUrl);
        } else {
            DriverHelper.createDriver(browserName.toLowerCase());
        }
        BrowserHelper.launchUrl(url);
        RunHelper.initRunData();
    }

    private boolean isRemoteRun(String run, String hubUrl) {
        if (hubUrl.equals("") && run.equalsIgnoreCase("remote"))
            throw new RuntimeException("Hub url should not be empty");
        else
            return !run.equalsIgnoreCase("local");
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
