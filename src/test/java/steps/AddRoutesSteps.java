package steps;

import elements.Dropdown;
import elements.DropdownSelectByVisibleText;
import elements.Input;
import io.qameta.allure.Step;
import model.RoutesModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.RoutesPage;

public class AddRoutesSteps extends AbstractStep {

    RoutesPage routesPage = new RoutesPage(driver);

    public AddRoutesSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public AddRoutesSteps openRoutesPage() {
        routesPage.openPage();
        validateComponentIsLoaded(routesPage);
        return this;
    }

    @Step
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

    @Step
    public AddRoutesSteps saveNewRoutes() {
        routesPage.clickAddRoutesButton();
        return this;
    }

    @Step
    public void checkingRotesAdd(RoutesModel routesModel) {

        Assert.assertEquals(routesPage.getActualRoutesName(), routesModel.getRouteName(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesActivity(), routesModel.getActivity(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesDistance(), routesModel.getDistance(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesDistanceType(), routesModel.getDistanceType(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesTime(), routesModel.getRoutePersonalRecord(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesData(), routesModel.getPersonalRecordDate(), "Incorrect text");
        Assert.assertEquals(routesPage.getActualRoutesNotes(), routesModel.getNotes(), "Incorrect text");
    }
}
