package com.solvd.laba.mobile;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Stream;

@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalendarHomePage.class)
public class CalendarHomePage extends AbstractPage implements IAndroidUtils {

    @FindBy(id = "com.google.android.calendar:id/action_today")
    private ExtendedWebElement todayButton;
    @FindBy(id = "com.google.android.calendar:id/floating_action_button")
    private ExtendedWebElement addButton;
    @FindBy(id = "com.google.android.calendar:id/speed_dial_event_container")
    private ExtendedWebElement eventButton;
    @FindBy(id = "com.google.android.calendar:id/action_search")
    private ExtendedWebElement searchButton;
    @FindBy(className = "android.view.View")
    private List<ExtendedWebElement> views;
    public CalendarHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(todayButton);

    }

    public void clickAddButton() {
        addButton.click();
    }

    public EventPage getEventPage() {
        clickAddButton();
        waitUntil(ExpectedConditions.visibilityOf(eventButton), 2);
        eventButton.click();
        return new EventPage(getDriver());
    }

    public CalendarSearch clickSearch() {
        searchButton.click();
        return new CalendarSearch(getDriver());
    }

    public List<String> showDays() {
        return views.stream().map(view -> view.getAttribute("content-desc")).toList();
    }

    public boolean isEventNameOnList(String name) {
        return showDays().stream().anyMatch(view -> view.contains(name));
    }

    public DayPage getDayPageByEventName(String name) {
        for (ExtendedWebElement element:views) {
            if (element.getAttribute("content-desc").contains(name)) {
                element.click();
                break;
            }
        }
        return new DayPage(getDriver());
    }


}
