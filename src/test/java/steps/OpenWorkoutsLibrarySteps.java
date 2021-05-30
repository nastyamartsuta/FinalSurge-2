package steps;

import elements.DropdownSelectByVisibleText;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OpenWorkoutsLibrarySteps extends AbstractCalendarPageSteps {

    public OpenWorkoutsLibrarySteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open workouts library panel")
    public OpenWorkoutsLibrarySteps openWorkoutsLibraryPanel() {
        openCalendarPage();
        calendarPage.openWorkoutLibraryPanel();
        return this;
    }

    @Step("Select activity type filter")
    public OpenWorkoutsLibrarySteps selectActivityTypeFilter() {
        new DropdownSelectByVisibleText(driver, "ActivityTypeFilter").select("Run");
        return this;
    }

    @Step("Checking workouts library was opened")
    public void checkingLibraryWasOpened() {
        Assert.assertTrue(calendarPage.checkingLibraryIsOpen(), "Library didn't open");
    }
}

