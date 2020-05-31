package com.mmt.pages.factories;

import com.mmt.enums.CommonRunVariables;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.RunHelper;
import com.mmt.pages.ReviewBookingPage;
import com.mmt.pages.hotels.HotelReviewBookingPage;

public class ReviewBookingPageFactory {
    public static ReviewBookingPage getInstance() {
        ServiceOption option = (ServiceOption) RunHelper.getRunData(CommonRunVariables.SERVICE_OPTION);
        return switch (option) {
            case HOTELS -> new HotelReviewBookingPage();
            case DEFAULT -> throw new RuntimeException("Not Implemented");
        };
    }
}
