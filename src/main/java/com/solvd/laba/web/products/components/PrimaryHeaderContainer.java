package com.solvd.laba.web.products.components;

import com.solvd.laba.web.cart.CartPage;
import com.solvd.laba.web.login.LogPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class PrimaryHeaderContainer extends AbstractUIObject {
    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement menuButton;
    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;
    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutButton;
    public PrimaryHeaderContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(getDriver());
    }

    public LogPage clickLogOut() {
        menuButton.click();
        logoutButton.click();
        return new LogPage(getDriver());
    }
}
