package com.solvd.laba.mobile;

import com.zebrunner.carina.webdriver.IDriverPool;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class DayPage extends AbstractPage {
    @FindBy(id = "com.google.android.calendar:id/info_action_edit_hit")
    private ExtendedWebElement editButton;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    private ExtendedWebElement moreOptionsButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.calendar:id/title\" and @text=\"Delete\"]")
    private ExtendedWebElement deleteButton;
    @FindBy(id = "android:id/button1")
    private ExtendedWebElement acceptDeleteButton;

    public DayPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(editButton);
    }

    public EventPage clickEditButton() {
        editButton.click();
        return new EventPage(getDriver());
    }
    public void deleteEvent() {
        moreOptionsButton.click();
        waitUntil(ExpectedConditions.visibilityOf(deleteButton), 5);
        deleteButton.click();
        waitUntil(ExpectedConditions.visibilityOf(acceptDeleteButton), 5);
        acceptDeleteButton.click();
    }

}
