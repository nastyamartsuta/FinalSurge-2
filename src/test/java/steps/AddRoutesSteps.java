package steps;

import elements.Dropdown;
import elements.DropdownSelectByVisibleText;
import elements.Input;
import io.qameta.allure.Step;
import model.RoutesModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddRoutesSteps extends AbstractEquipmentsSteps {

    public AddRoutesSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open routes page")
    public AddRoutesSteps openRoutesPage() {
        routesPage.openPage();
        validateComponentIsLoaded(routesPage);
        return this;
    }

    @Step("Fill in the fields to add a new route")
    public AddRoutesSteps fillNewRoutes() {
        new Input(driver, "RouteName").enterInput(RoutesModel.routeName);
        new DropdownSelectByVisibleText(driver, "Activity").select(RoutesModel.activity);
        new Input(driver, "Distance").enterInput(RoutesModel.distance);
        new Input(driver, "RoutePR").enterInput(RoutesModel.routePersonalRecord);
        new Input(driver, "PRDate").enterInput(RoutesModel.personalRecordDate);
        new Input(driver, "Notes").enterInput(RoutesModel.notes);
        new Dropdown(driver, "DistType").select(RoutesModel.distanceType);
        return this;
    }

    @Step("Save new routes")
    public AddRoutesSteps saveNewRoutes() {
        routesPage.clickAddRoutesButton();
        return this;
    }

    @Step("Checking that the new routes was added")
    public AddRoutesSteps checkingRotesAdd() {
        Assert.assertEquals(routesPage.getActualRoutesName(), RoutesModel.routeName, "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesActivity(), RoutesModel.activity, "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesDistance(), RoutesModel.distance, "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesDistanceType(), RoutesModel.distanceType, "Incorrect text");
        Assert.assertEquals(routesPage.getActualPersonalRecord(), RoutesModel.routePersonalRecord, "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesData(), RoutesModel.personalRecordDate, "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesNotes(), RoutesModel.notes, "Incorrect text");
        return this;
    }

    @Step("Delete new routes")
    public void deleteNewRoutes() {
        equipmentPage.deleteNewEquipment();
        Assert.assertTrue(equipmentPage.checkingNewNewEquipmentWasDeleted(), "Equipment was not deleted");
    }
}
