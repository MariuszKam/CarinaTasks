package com.solvd.laba.web.login.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class LogPanel extends AbstractUIObject {
    @FindBy(id = "user-name")
    private ExtendedWebElement userInput;
    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;
    @FindBy(id = "login-button")
    private ExtendedWebElement logButton;
    @FindBy(xpath = "./div/form/div[3]/h3")
    private ExtendedWebElement errorOutput;

    public LogPanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void typeUserLogin(String login) {
        userInput.type(login);
    }

    private void typeUserPassword(String password) {
        passwordInput.type(password);
    }

    public void clickLogButton() {
        logButton.click();
    }

    public boolean isErrorOutputVisible() {
        return errorOutput.isVisible();
    }

    public void pageLogin(String login, String password) {
        typeUserLogin(login);
        typeUserPassword(password);
        clickLogButton();
    }



}
