package com.solvd.laba.web.products.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsBody extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class = 'primary_header']")
    private  PrimaryHeaderContainer primaryHeaderContainer;
    @FindBy(xpath = ".//*[@class = 'header_secondary_container']")
    private SecondHeaderContainer secondHeaderContainer;
    @FindBy(xpath = ".//*[@class = 'inventory_container']")
    private InventoryContainer inventoryContainer;

    public ProductsBody(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
