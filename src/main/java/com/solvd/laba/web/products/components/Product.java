package com.solvd.laba.web.products.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class Product extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class = 'inventory_item_name ']")
    private ExtendedWebElement productName;
    @FindBy(xpath = ".//*[@class = 'inventory_item_price']")
    private ExtendedWebElement productPrice;
    @FindBy(xpath = ".//*[@class = 'btn btn_primary btn_small btn_inventory ']")
    private ExtendedWebElement addButton;
    @FindBy(xpath = ".//*[@class = 'btn btn_secondary btn_small btn_inventory ']")
    private ExtendedWebElement removeButton;
    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickBuyButton() {
        addButton.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public String getProductName() {
        return productName.getText();
    }

    public Double getPriceInDouble() {
        return Double.valueOf(productPrice.getText().replace("$", ""));
    }

    public boolean isAddButtonDisplayed() {
        return addButton.isDisplayed();
    }

    public boolean isRemoveButtonDisplayed() {
        return removeButton.isDisplayed();
    }
}
