package com.mmt.ui_layer.components.search;

import com.mmt.ui_layer.pages.base.SearchResultPage;
import com.mmt.ui_layer.pages.base.UILayer;

public abstract class SearchComponent extends UILayer {
    abstract public SearchResultPage search();

    abstract public void populateSearchDetails();
}
