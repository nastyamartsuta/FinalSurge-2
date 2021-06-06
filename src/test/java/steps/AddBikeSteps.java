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

    @Step("Open bike page")
    public AddBikeSteps openBikePage() {
        openEquipmentPage();
        bikePage.openPage();
        validateComponentIsLoaded(bikePage);
        return this;
    }

    @Step("Fill in the fields to add a new bike")
    public AddBikeSteps fillNewBike() {
        new Input(driver, "ShoeName").enterInput(BikeModel.bikeName);
        new DropdownEquipment(driver, "s2id_ShoeBrand").select(BikeModel.brand);
        new Input(driver, "ShoeModel").enterInput(BikeModel.model);
        new Input(driver, "ShoeCost").enterInput(BikeModel.cost);
        new Input(driver, "ShoeDate").enterInput(BikeModel.datePurchased);
        new Input(driver, "StartDist").clear();
        new Input(driver, "StartDist").enterInput(BikeModel.startingDistance);
        new Input(driver, "ShoeNotes").enterInput(BikeModel.notes);
        new Dropdown(driver, "DistType").select(BikeModel.distanceType);
        return this;
    }

    @Step("Save  new bike")
    public AddBikeSteps saveNewBike() {
        bikePage.clickAddBikeButton();
        return this;
    }

    @Step("Checking that the bike was added")
    public AddBikeSteps checkingBikeAdd() {
        Assert.assertEquals(bikePage.getActualBikeName(), BikeModel.bikeName, "Incorrect text");
        Assert.assertEquals(bikePage.getActualBikeBrandModel(), BikeModel.brand + " " + BikeModel.model, "Incorrect text");
        Assert.assertEquals(bikePage.getActualBikeDatePurchased(), BikeModel.datePurchased, "Incorrect text");
        Assert.assertEquals(bikePage.getActualBikeCost(), BikeModel.cost, "Incorrect text");
        Assert.assertEquals(bikePage.getActualBikeNotes(), BikeModel.notes, "Incorrect text");
        return this;
    }

    @Step("Delete new bike")
    public void deleteNewBike() {
        equipmentPage.deleteNewEquipment();
        Assert.assertTrue(equipmentPage.checkingNewNewEquipmentWasDeleted(), " Equipment was not deleted");
    }
}
