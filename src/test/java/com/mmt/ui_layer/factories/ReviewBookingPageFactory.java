package com.mmt.ui_layer.factories;

import com.mmt.enums.CommonRunVariables;
import com.mmt.enums.ServiceOption;
import com.mmt.helpers.PageHelper;
import com.mmt.helpers.RunHelper;
import com.mmt.ui_layer.pages.base.ReviewBookingPage;

public class ReviewBookingPageFactory {
    public static ReviewBookingPage getInstance() {
        ServiceOption option = (ServiceOption) RunHelper.getRunData(CommonRunVariables.SERVICE_OPTION);
        return PageHelper.getPage(option.name());
    }
}
