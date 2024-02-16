package com.solvd.laba.mobile;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPage.class)
public class SearchPage extends AbstractPage {

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/input")
    private ExtendedWebElement searchInput;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Calendar\"]")
    private ExtendedWebElement calendar;
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void typeSearchInput(String value) {
        searchInput.type(value);
    }

    public CalendarHomePage getCalendarHomePage() {
        typeSearchInput(R.TESTDATA.get("test_app"));
        waitUntil(ExpectedConditions.visibilityOf(calendar), 2);
        calendar.click();
        return new CalendarHomePage(getDriver());
    }


}
