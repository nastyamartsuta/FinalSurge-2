package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddActivityTypeTest extends WithLoginTest {

    @Test
    @Description(value = "Add new activity type test")
    public void addNewActivityTypeTest() {
        addNewActivityTypeSteps
                .openActivityTypePage()
                .fillNewActivityType()
                .saveNewActivityType()
                .checkingNewTypeAdded();
    }
}
