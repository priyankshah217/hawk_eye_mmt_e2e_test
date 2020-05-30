package com.mmt.pages;

import com.mmt.helpers.ServiceOption;
import com.mmt.pages.components.ServiceOptionsHeader;

public class HomePage extends BasePage {
    private String homeUrl = "https://makemytrip.com/";
    private ServiceOptionsHeader serviceOptionsHeader;

    public HomePage() {
        driver.get(homeUrl);
        serviceOptionsHeader = new ServiceOptionsHeader();
    }

    public void selectService(ServiceOption option) {
        serviceOptionsHeader.select(option);
    }
}
