package com.mmt.ui_layer.factories;

import com.mmt.enums.ServiceOption;
import com.mmt.helpers.PageHelper;
import com.mmt.ui_layer.components.search.SearchComponent;

public class SearchComponentFactory {
    public static SearchComponent getInstance(ServiceOption option) {
        return PageHelper.getSearchComponent(option.name());
    }
}
