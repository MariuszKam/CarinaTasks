package com.solvd.laba.web.checkout;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutCompletePage extends AbstractPage {
    @FindBy(id = "checkout_complete_container")
    private ExtendedWebElement completedCheckout;
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCompletedDisplay() {
        return completedCheckout.isDisplayed();
    }
}
