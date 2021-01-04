package com.mmt.ui_layer.pages.hotels;

import com.mmt.annotations.Page;
import com.mmt.enums.HotelDetail;
import com.mmt.locators.HotelDetailsLocator;
import com.mmt.ui_layer.pages.base.UILayer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.mmt.helpers.ElementHelper.getElement;
import static com.mmt.helpers.ElementHelper.scrollToElement;
import static com.mmt.helpers.LocatorHelper.getLocators;
import static com.mmt.helpers.RunHelper.addRunData;

@Page
public class HotelDetailsPage extends UILayer {
    @NotNull
    private static final HotelDetailsLocator hotelDetailsLocator = Objects.requireNonNull(getLocators("locators/hoteldetails.yml"));

    public void selectRoom() {
        scrollToElement(hotelDetailsLocator.roomSection());
        storeRoomDetails();
        getElement(hotelDetailsLocator.selectRoom()).click();
    }

    private void storeRoomDetails() {
        addRunData(HotelDetail.ROOM_NAME, getElement(hotelDetailsLocator.roomName()).getText());
    }
}
