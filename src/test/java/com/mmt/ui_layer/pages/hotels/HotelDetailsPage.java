package com.mmt.ui_layer.pages.hotels;

import com.mmt.annotations.Page;
import com.mmt.enums.HotelDetail;
import com.mmt.helpers.LocatorHelper;
import com.mmt.helpers.RunHelper;
import com.mmt.locators.HotelDetailsLocator;
import com.mmt.ui_layer.pages.base.UILayer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Page
public class HotelDetailsPage extends UILayer {
    @NotNull
    private static final HotelDetailsLocator hotelDetailsLocator = Objects.requireNonNull(LocatorHelper.getLocators("locators/hoteldetails.yml"));

    public void selectRoom() {
        scrollToElement(hotelDetailsLocator.roomSection());
        storeRoomDetails();
        getElement(hotelDetailsLocator.selectRoom()).click();
    }

    private void storeRoomDetails() {
        RunHelper.addRunData(HotelDetail.ROOM_NAME, getElement(hotelDetailsLocator.roomName()).getText());
    }
}
