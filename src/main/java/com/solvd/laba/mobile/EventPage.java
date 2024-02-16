package com.solvd.laba.mobile;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EventPage.class)
public class EventPage extends AbstractPage {

    @FindBy(id = "com.google.android.calendar:id/title")
    private ExtendedWebElement titleInput;
    @FindBy(id = "com.google.android.calendar:id/save")
    private ExtendedWebElement saveButton;

    public EventPage(WebDriver driver) {
        super(driver);
    }

    public void clickSave() {
        saveButton.click();
    }

    public void typeTitle(String value) {
        titleInput.type(value);
    }

    public void createEvent(String value) {
        titleInput.type(value);
        clickSave();
    }
}
