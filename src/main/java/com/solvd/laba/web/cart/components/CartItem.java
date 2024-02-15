package com.solvd.laba.web.cart.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartItem extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class = 'inventory_item_name']")
    private ExtendedWebElement itemName;
    @FindBy(xpath = ".//*[@class = 'inventory_item_price']")
    private ExtendedWebElement itemPrice;
    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTextItemName() {
        return itemName.getText();
    }
}
