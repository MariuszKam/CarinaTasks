package com.solvd.laba.web.products;

import com.solvd.laba.web.products.components.ProductsBody;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsPage extends AbstractPage {

    @FindBy(xpath = "//body")
    private ProductsBody productsBody;
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


}
