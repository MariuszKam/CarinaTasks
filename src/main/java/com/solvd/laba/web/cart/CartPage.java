package com.solvd.laba.web.cart;

import com.solvd.laba.web.cart.components.CartItem;
import com.solvd.laba.web.checkout.CheckoutInformationPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CartPage extends AbstractPage {

    @FindBy(className = "cart_item")
    private List<CartItem> cartItems;
    @FindBy(id = "checkout" )
    private ExtendedWebElement checkout;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage clickCheckout() {
        checkout.click();
        return new CheckoutInformationPage(getDriver());
    }
}
