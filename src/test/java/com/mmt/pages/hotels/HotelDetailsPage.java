package com.mmt.pages.hotels;

import com.mmt.enums.HotelDetail;
import com.mmt.helpers.RunHelper;
import com.mmt.pages.BasePage;
import org.openqa.selenium.By;

public class HotelDetailsPage extends BasePage {
    private By roomName = By.cssSelector(".roomWrap .sticky :first-child");
    private By selectRoom = By.cssSelector(".roomWrap .primaryBtn");
    private By roomSection = By.id("RoomType");

    public HotelReviewBookingPage selectRoom() {
        scrollToElement(roomSection);
        storeRoomDetails();
        findElement(selectRoom).click();
        return new HotelReviewBookingPage();
    }

    private void storeRoomDetails() {
        RunHelper.addRunData(HotelDetail.ROOM_NAME, findElement(roomName).getText());
    }
}
