package com.mmt.pages;

import com.mmt.enums.HotelDetail;
import com.mmt.helpers.RunHelper;
import org.openqa.selenium.By;

public class HotelDetailsPage extends BasePage {
    private By roomName = By.cssSelector(".roomWrap .sticky :first-child");
    private By selectRoom = By.cssSelector(".roomWrap .primaryBtn");
    private By roomSection = By.id("RoomType");

    public void selectRoom() {
        scrollToElement(roomSection);
        storeRoomDetails();
        findElement(selectRoom).click();
    }

    private void storeRoomDetails() {
        RunHelper.addRunData(HotelDetail.ROOM_NAME, findElement(roomName).getText());
    }
}
