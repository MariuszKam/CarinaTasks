package com.solvd.laba.web;

import com.solvd.laba.web.components.LogBody;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class LogPage extends AbstractPage {

    @FindBy(xpath = "//body")
    private LogBody logBody;

    public LogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }
}
