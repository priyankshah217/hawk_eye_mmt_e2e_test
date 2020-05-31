package com.mmt.ui_layer.components.search;

import com.mmt.ui_layer.UILayer;
import com.mmt.ui_layer.pages.SearchResultPage;

public abstract class SearchComponent extends UILayer {
    abstract public SearchResultPage search();

    abstract public void populateSearchDetails();
}
