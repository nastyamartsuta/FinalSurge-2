package finalsurgetest;

import io.qameta.allure.Description;
import model.ActivityTypeModel;
import org.testng.annotations.Test;

import static pages.BasePage.*;
import static pages.BasePage.YEAR_PATTERN;
import static pages.CalendarPage.WORKOUTS;

public class AddActivityTypeTest extends WithLoginTest {

    ActivityTypeModel activityTypeModel = new ActivityTypeModel();

    @Test
    @Description(value = "Add new activity type test")
    public void addNewActivityTypeTest() {
        initActivityTypeModel();
        addNewActivityTypeSteps
                .openActivityTypePage()
                .fillNewActivityType(activityTypeModel)
                .saveNewActivityType()
                .checkingNewTypeAdded(activityTypeModel);
    }

    private void initActivityTypeModel() {
        activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setATypeName("Yoga");
    }
}
