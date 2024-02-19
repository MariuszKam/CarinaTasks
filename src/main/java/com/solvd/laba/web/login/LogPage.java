package com.solvd.laba.web.login;


import com.solvd.laba.web.products.ProductsPage;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class LogPage extends AbstractPage {

    @FindBy(id = "user-name")
    private ExtendedWebElement userInput;
    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;
    @FindBy(id = "login-button")
    private ExtendedWebElement logButton;
    @FindBy(xpath = "//*[@id= 'login_button_container']/div/form/div[3]")
    private ExtendedWebElement errorOutput;

    public LogPage(WebDriver driver) {
        super(driver);
        setPageURL("");
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

    public ProductsPage pageLogin(String login, String password) {
        typeUserLogin(login);
        typeUserPassword(password);
        clickLogButton();
        return new ProductsPage(getDriver());
    }

}
