package com.solvd.laba.web.components;

import com.solvd.laba.web.ProductsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class LogPanel extends AbstractUIObject {
    @FindBy(xpath = ".//input[@id = 'user-name']")
    private ExtendedWebElement userInput;
    @FindBy(xpath = ".//input[@id = 'password']")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = ".//*[@id = 'login-button']")
    private ExtendedWebElement logButton;

    public LogPanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeUserLogin(String login) {
        userInput.sendKeys(login);
    }

    public void typeUserPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public ProductsPage clickLogButton() {
        logButton.click();
        return new ProductsPage(getDriver());
    }

}
