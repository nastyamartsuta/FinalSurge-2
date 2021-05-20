package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class AbstractCalendarPageSteps extends AbstractStep {

    protected CalendarPage calendarPage;
    protected NewWorkoutQuickPage newWorkoutQuickPage;
    protected UploadWorkoutDataPage uploadWorkoutDataPage;
    protected DeleteWorkoutPage deleteWorkoutPage;
    protected ViewWorkoutPage viewWorkoutPage;
    protected AddCommentPage commentPage;
    protected MoveWorkoutPage moveWorkoutPage;


    public AbstractCalendarPageSteps(WebDriver driver) {
        super(driver);
    }

    public void openCalendarPage() {
        calendarPage = new CalendarPage(driver);
        calendarPage.openPage();
        validateComponentIsLoaded(calendarPage);
    }
}