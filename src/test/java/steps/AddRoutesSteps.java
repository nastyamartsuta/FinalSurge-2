package steps;

import elements.Dropdown;
import elements.DropdownSelectByVisibleText;
import elements.Input;
import io.qameta.allure.Step;
import model.RoutesModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.RoutesPage;

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
    public AddRoutesSteps fillNewRoutes(RoutesModel routesModel) {
        new Input(driver, "RouteName").enterInput(routesModel.getRouteName());
        new DropdownSelectByVisibleText(driver, "Activity").select(routesModel.getActivity());
        new Input(driver, "Distance").enterInput(routesModel.getDistance());
        new Input(driver, "RoutePR").enterInput(routesModel.getRoutePersonalRecord());
        new Input(driver, "PRDate").enterInput(routesModel.getPersonalRecordDate());
        new Input(driver, "Notes").enterInput(routesModel.getNotes());
        new Dropdown(driver, "DistType").select(routesModel.getDistanceType());
        return this;
    }

    @Step("Save new routes")
    public AddRoutesSteps saveNewRoutes() {
        routesPage.clickAddRoutesButton();
        return this;
    }

    @Step("Checking that the new routes was added")
    public AddRoutesSteps checkingRotesAdd(RoutesModel routesModel) {
        Assert.assertEquals(routesPage.getActualRoutesName(), routesModel.getRouteName(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesActivity(), routesModel.getActivity(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesDistance(), routesModel.getDistance(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesDistanceType(), routesModel.getDistanceType(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesTime(), routesModel.getRoutePersonalRecord(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesData(), routesModel.getPersonalRecordDate(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesNotes(), routesModel.getNotes(), "Incorrect text");
        return this;
    }

    @Step("Delete new routes")
    public void deleteNewRoutes() {
        equipmentPage.deleteNewEquipment();
        Assert.assertTrue(equipmentPage.checkingNewNewEquipmentWasDeleted(), "Equipment was not deleted");
    }
}
