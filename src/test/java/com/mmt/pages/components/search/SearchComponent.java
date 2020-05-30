package com.mmt.pages.components.search;

import com.mmt.pages.BasePage;
import com.mmt.pages.SearchResultPage;

public abstract class SearchComponent extends BasePage {
    abstract public SearchResultPage search();

    abstract public void populateSearchDetails();
}
