package com.solvd.laba.web.products;

import com.solvd.laba.web.products.components.InventoryContainer;
import com.solvd.laba.web.products.components.PrimaryHeaderContainer;
import com.solvd.laba.web.products.components.SecondHeaderContainer;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'primary_header']")
    private PrimaryHeaderContainer primaryHeaderContainer;
    @FindBy(xpath = "//*[@class = 'header_secondary_container']")
    private SecondHeaderContainer secondHeaderContainer;
    @FindBy(xpath = "//*[@class = 'inventory_container']")
    private InventoryContainer inventoryContainer;
    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("inventory.html");
    }


}
