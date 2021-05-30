package steps;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.ActivityTypeModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ActivityTypePage;

public class AddNewActivityTypeSteps extends AbstractEquipmentsSteps {

    ActivityTypePage activityTypePage = new ActivityTypePage(driver);

    public AddNewActivityTypeSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open activity type page")
    public AddNewActivityTypeSteps openActivityTypePage() {
        activityTypePage.openPage();
        validateComponentIsLoaded(activityTypePage);
        return this;
    }

    @Step("Fill in the fields to add a new activity type")
    public AddNewActivityTypeSteps fillNewActivityType(ActivityTypeModel activityTypeModel) {
        new Input(driver, "ATypeName").enterInput(activityTypeModel.getATypeName());
        new RadioButton(driver, "Black").selectRadioButton();
        return this;
    }

    @Step("Save new activity type")
    public AddNewActivityTypeSteps saveNewActivityType() {
        activityTypePage.clickAddActivityTypeButton();
        return this;
    }

    @Step("Checking that the new activity type was added ")
    public void checkingNewTypeAdded(ActivityTypeModel activityTypeModel) {
        Assert.assertTrue(activityTypePage.getTypeAdded(activityTypeModel), "New activity type was not added");
    }
}

