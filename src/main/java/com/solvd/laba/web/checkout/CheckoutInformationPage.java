package com.solvd.laba.web.checkout;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutInformationPage extends AbstractPage {

    @FindBy(id = "first-name")
    ExtendedWebElement firstNameInput;
    @FindBy(id = "last-name")
    ExtendedWebElement lastNameInput;
    @FindBy(id = "postal-code")
    ExtendedWebElement postalCodeInput;
    @FindBy(id = "continue")
    ExtendedWebElement continueButton;
    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    private void fillUpCheckout(String firstName, String lasName, String postalCode) {
        firstNameInput.type(firstName);
        lastNameInput.type(lasName);
        postalCodeInput.type(postalCode);
    }

    public CheckoutOverviewPage checkout(String firstName, String lasName, String postalCode) {
        fillUpCheckout(firstName, lasName, postalCode);
        continueButton.click();
        return new CheckoutOverviewPage(getDriver());
    }

}
