package com.solvd.laba.mobile;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalendarHomePage.class)
public class CalendarHomePage extends AbstractPage {

    @FindBy(id = "com.google.android.calendar:id/action_today")
    private ExtendedWebElement todayButton;
    @FindBy(id = "com.google.android.calendar:id/floating_action_button")
    private ExtendedWebElement addButton;
    @FindBy(id = "com.google.android.calendar:id/speed_dial_event_container")
    private ExtendedWebElement eventButton;
    @FindBy(className = "android.view.View")
    private List<ExtendedWebElement> views;
    public CalendarHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickTodayButton() {
        todayButton.click();
    }

    public boolean isPresentTodayButton() {
        return todayButton.isPresent();
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

    public void showDays() {
        views.forEach(System.out::println);
        //views.stream().map(ExtendedWebElement::).forEach(System.out::println);
    }

}
