package com.mmt.ui_layer.factories;

import com.mmt.enums.CommonRunVariables;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.RunHelper;
import com.mmt.ui_layer.pages.ReviewBookingPage;
import com.mmt.ui_layer.pages.hotels.HotelReviewBookingPage;

public class ReviewBookingPageFactory {
    public static ReviewBookingPage getInstance() {
        ServiceOption option = (ServiceOption) RunHelper.getRunData(CommonRunVariables.SERVICE_OPTION);
        return switch (option) {
            case HOTELS -> new HotelReviewBookingPage();
            case DEFAULT -> throw new RuntimeException("Not Implemented");
        };
    }
}
