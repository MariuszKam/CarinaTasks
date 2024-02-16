package com.solvd.laba;

import com.solvd.laba.mobile.CalendarHomePage;
import com.solvd.laba.mobile.EventPage;
import com.solvd.laba.mobile.HomePage;
import com.solvd.laba.mobile.SearchPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest extends AbstractTest {
    /**
     * Simple Test to get Calendar App
     * Click on search button in Home Page
     * Input calendar
     * Click on Calendar app
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void openCalendarTest() {
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = homePage.clickSearchButton();
        CalendarHomePage calendarHomePage = searchPage.getCalendarHomePage();
        Assert.assertTrue(calendarHomePage.isPresentTodayButton(), "It's not calendar app");
    }

    /**
     * Event Creation:
     * Open the Calendar application
     * Create a new calendar event
     * Verify is event exists
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void eventCreationTest() {
        CalendarHomePage calendarHomePage = new CalendarHomePage(getDriver());
//        EventPage eventPage = calendarHomePage.getEventPage();
//        eventPage.createEvent("MyEvent");
        calendarHomePage.showDays();

    }
}
