package com.solvd.laba.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class LogBody extends AbstractUIObject {
    @FindBy(xpath = ".//*[@id = 'login_button_container']")
    private LogPanel logPanel;

    public LogBody(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
