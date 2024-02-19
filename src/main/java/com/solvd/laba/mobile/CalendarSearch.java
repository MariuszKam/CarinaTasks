package com.solvd.laba.mobile;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarSearch extends AbstractPage implements IAndroidUtils {

    @FindBy(id = "com.google.android.calendar:id/search_text")
    private ExtendedWebElement searchInput;
    @FindBy(className = "android.view.View")
    private List<ExtendedWebElement> views;
    public CalendarSearch(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
    }

    public void searchFor(String value) {
        searchInput.click();
        searchInput.type(value);
        pressKeyboardKey(AndroidKey.ENTER);
    }

    public boolean hasFound() {
        return !views.isEmpty();
    }

}
