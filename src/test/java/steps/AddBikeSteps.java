package steps;

import elements.Dropdown;
import elements.DropdownEquipment;
import elements.Input;
import io.qameta.allure.Step;
import model.BikeModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddBikeSteps extends AbstractEquipmentsSteps {

    public AddBikeSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public AddBikeSteps openBikePage() {
        openEquipmentPage();
        bikePage.openPage();
        validateComponentIsLoaded(bikePage);
        return this;
    }

    @Step
    public AddBikeSteps fillNewBike(BikeModel bikeModel) {

        new Input(driver, "ShoeName").enterInput(bikeModel.getBikeName());
        new DropdownEquipment(driver, "BMC").select();
        new Input(driver, "ShoeModel").enterInput(bikeModel.getModel());
        new Input(driver, "ShoeCost").enterInput(bikeModel.getCost());
        new Input(driver, "ShoeDate").enterInput(bikeModel.getDatePurchased());
        new Input(driver, "StartDist").enterInput(bikeModel.getStartingDistance());
        new Input(driver, "ShoeNotes").enterInput(bikeModel.getNotes());
        new Dropdown(driver, "DistType").select(bikeModel.getDistanceType());

        return this;
    }

    @Step
    public AddBikeSteps saveNewBike() {
        bikePage.clickAddBikeButton();
        return this;
    }

    @Step
    public void checkingBikeAdd(BikeModel bikeModel) {
        Assert.assertTrue(bikePage.getActualText().contains(
                bikeModel.getBikeName() + " ("
                        + bikeModel.getBrand() + " " + bikeModel.getModel() + ")" + "\n"
                        + "Purchased: " + bikeModel.getDatePurchased() + " "
                        + "Cost: $" + bikeModel.getCost() + "\n"
                        + bikeModel.getNotes()),
                "Incorrect text");
    }
}
