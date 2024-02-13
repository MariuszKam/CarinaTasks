package com.solvd.laba;

import com.solvd.laba.web.LogPage;
import com.solvd.laba.web.ProductsPage;
import com.solvd.laba.web.components.LogPanel;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest extends AbstractTest {

    /**First test
     *Testing log in on site
     */
    @Test
    public void logTest() {
        LogPage logPage = new LogPage(getDriver());
        logPage.open();
        logPage.isPageOpened();
        LogPanel logPanel = logPage.getLogBody().getLogPanel();
        logPanel.assertUIObjectPresent();

        // Check if it's not null
        System.out.println("LogPanel: " + logPanel);
        System.out.println("UserInput: " + logPanel.getUserInput());
//        logPanel.getUserInput().sendKeys("standard_user");

        Assert.assertTrue(logPanel.getUserInput().isElementPresent(2), "User input does not exist");
        Assert.assertEquals(logPanel.getUserInput().getAttribute("placeholder"), "Username", "Incorrect placeholder");
        Assert.assertTrue(logPanel.getPasswordInput().isElementPresent(2), "Password input does not exist");
        Assert.assertEquals(logPanel.getPasswordInput().getAttribute("placeholder"), "Password", "Incorrect placeholder");
        Assert.assertTrue(logPanel.getLogButton().isElementPresent(2), "Button doesn't exist");

        // Interact with the password input field
        logPanel.typeUserLogin("standard_user");
        logPanel.typeUserPassword("secret_sauce");
        ProductsPage productsPage = logPanel.clickLogButton();
        productsPage.isPageOpened();

    }

    @Test
    @MethodOwner(owner = "Mariusz")
    public void TutorialLog() {
        WebDriver webDriver = getDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().fullscreen();
        WebElement userInput = webDriver.findElement(By.xpath("//body//*[@id = 'login_button_container']//*[@id = 'user-name']"));
        WebElement passwordInput = webDriver.findElement(By.xpath("//body//*[@id = 'login_button_container']//*[@id = 'password']"));
        WebElement buttonClick = webDriver.findElement(By.xpath("//body//*[@id = 'login_button_container']//*[@id = 'login-button']"));
        userInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        buttonClick.click();
    }
}
