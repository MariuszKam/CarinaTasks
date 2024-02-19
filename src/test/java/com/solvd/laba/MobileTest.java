package com.solvd.laba;

import com.solvd.laba.mobile.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
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
        calendarHomePage.assertPageOpened();
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
        EventPage eventPage = calendarHomePage.getEventPage();
        eventPage.createEvent(R.TESTDATA.get("test_event"));
        Assert.assertTrue(calendarHomePage.isEventNameOnList(R.TESTDATA.get("test_event")));
    }

    /**
     * Find event by search:
     * Verify if on calendar home page
     * Navigate to search and verify if in search
     * Type event name
     * Verify if found existing event
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    private void findEvent() {
        CalendarHomePage calendarHomePage = new CalendarHomePage(getDriver());
        calendarHomePage.assertPageOpened();
        CalendarSearch calendarSearch = calendarHomePage.clickSearch();
        calendarSearch.assertPageOpened();
        calendarSearch.searchFor(R.TESTDATA.get("test_event"));
        Assert.assertTrue(calendarSearch.hasFound(), "Event not found");
    }

    /**
     * Edit Event:
     * Verify is event exists
     * Go to Event and verify if event page's open
     * Edit event and change name
     * Verify if event exists(with new name)
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void eventEditTest() {
        CalendarHomePage calendarHomePage = new CalendarHomePage(getDriver());
        Assert.assertTrue(calendarHomePage.isEventNameOnList(R.TESTDATA.get("test_event")));
        DayPage dayPage = calendarHomePage.getDayPageByEventName(R.TESTDATA.get("test_event"));
        EventPage eventPage = dayPage.clickEditButton();
        eventPage.assertPageOpened();
        eventPage.createEvent(R.TESTDATA.get("edited_event"));
        Assert.assertTrue(calendarHomePage.isEventNameOnList(R.TESTDATA.get("edited_event")));
    }

    /**
     * Delete Event:
     * Verify is event exists
     * Go to Event and verify if event page's open
     * Delete event
     * Verify if event does not exist
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void deleteEditTest() {
        CalendarHomePage calendarHomePage = new CalendarHomePage(getDriver());
        Assert.assertTrue(calendarHomePage.isEventNameOnList(R.TESTDATA.get("edited_event")));
        DayPage dayPage = calendarHomePage.getDayPageByEventName(R.TESTDATA.get("edited_event"));
        dayPage.deleteEvent();
        calendarHomePage.assertPageOpened();
        Assert.assertFalse(calendarHomePage.isEventNameOnList(R.TESTDATA.get("edited_event")));
    }

}
