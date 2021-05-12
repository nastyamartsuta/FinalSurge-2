package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.NewWorkoutQuickPage;

public class AbstractCalendarPageSteps extends AbstractStep {

    protected CalendarPage calendarPage;
    protected NewWorkoutQuickPage newWorkoutQuickPage;

    public AbstractCalendarPageSteps(WebDriver driver) {
        super(driver);
    }

    public void openCalendarPage() {
        calendarPage = new CalendarPage(driver);
        calendarPage.openPage();
        validateComponentIsLoaded(calendarPage);
    }
}