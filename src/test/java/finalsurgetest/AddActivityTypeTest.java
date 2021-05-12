package finalsurgetest;

import io.qameta.allure.Description;
import model.ActivityTypeModel;
import org.testng.annotations.Test;

public class AddActivityTypeTest extends BaseTest {

    ActivityTypeModel activityTypeModel = new ActivityTypeModel();

    @Test
    @Description(value = "Add new activity type test")
    public void addNewActivityTypeTest() {
        initActivityTypeModel();
        loginSteps
                .openLoginPage()
                .authentication();
        addNewActivityTypeSteps.openActivityTypePage()
                .fillNewActivityType(activityTypeModel)
                .saveNewActivityType()
                .checkingNewTypeAdded(activityTypeModel);
    }

    private void initActivityTypeModel() {
        activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setATypeName("Yoga");
    }
}
