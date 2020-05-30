package com.mmt.pages.components.search;

import com.mmt.pages.BaseUI;
import org.openqa.selenium.By;

public abstract class SearchComponent extends BaseUI {
    protected By searchButton = By.id("hsw_search_button");
    abstract public void search();
}
