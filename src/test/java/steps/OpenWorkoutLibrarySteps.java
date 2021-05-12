package steps;

import elements.DropdownSelectByVisibleText;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OpenWorkoutLibrarySteps extends AbstractCalendarPageSteps {

    public OpenWorkoutLibrarySteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public OpenWorkoutLibrarySteps openWorkoutLibraryPanel() {
        openCalendarPage();
        calendarPage.openWorkoutLibraryPanel();
        return this;
    }

    @Step
    public OpenWorkoutLibrarySteps selectActivityTypeFilter() {
        new DropdownSelectByVisibleText(driver, "ActivityTypeFilter").select("Run");
        return this;
    }

    @Step
    public void checkingLibraryIsOpen() {
        Assert.assertTrue(calendarPage.checkingLibraryIsOpen(),"Library didn't open");
    }
}

