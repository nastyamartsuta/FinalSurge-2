package steps;

import elements.Dropdown;
import elements.DropdownEquipment;
import elements.Input;
import io.qameta.allure.Step;
import model.ShoesModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddShoesSteps extends AbstractEquipmentsSteps {

    public AddShoesSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open shoes page")
    public AddShoesSteps openShoesPage() {
        openEquipmentPage();
        shoesPage.openPage();
        validateComponentIsLoaded(shoesPage);
        return this;
    }

    @Step("Fill in the fields to add a new shoes")
    public AddShoesSteps fillNewShoes() {
        new Input(driver, "ShoeName").enterInput(ShoesModel.shoesName);
        new DropdownEquipment(driver, "s2id_ShoeBrand").select(ShoesModel.brand);
        new Dropdown(driver, "ShoeSize").select(ShoesModel.shoeSize);
        new Dropdown(driver, "DistType").select(ShoesModel.distanceType);
        new Dropdown(driver, "DistAlertType").select(ShoesModel.distanceAlertType);
        new Input(driver, "ShoeModel").enterInput(ShoesModel.model);
        new Input(driver, "ShoeCost").enterInput(ShoesModel.cost);
        new Input(driver, "ShoeDate").enterInput(ShoesModel.datePurchased);
        new Input(driver, "StartDist").enterInput(ShoesModel.startingDistance);
        new Input(driver, "DistAlert").enterInput(ShoesModel.distanceAlert);
        new Input(driver, "ShoeNotes").enterInput(ShoesModel.notes);
        return this;
    }

    @Step("Save new shoes")
    public AddShoesSteps saveNewShoes() {
        shoesPage.clickAddShoesButton();
        return this;
    }

    @Step("Checking that the shoes was added")
    public AddShoesSteps checkingShoesAdd() {
        Assert.assertEquals(shoesPage.getActualShoesBrandModel(), ShoesModel.brand + " " + ShoesModel.model, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesCost(),ShoesModel.cost, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesName(), ShoesModel.shoesName, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesSize(), ShoesModel.shoeSize, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesDatePurchased(), ShoesModel.datePurchased, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesDistanceAlert(), ShoesModel.distanceAlert, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesDistanceType(), ShoesModel.distanceType, "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesNotes(), ShoesModel.notes, "Incorrect text");
        return this;
    }

    @Step("Delete new shoes")
    public void deleteNewShoes() {
        equipmentPage.deleteNewEquipment();
        Assert.assertTrue(equipmentPage.checkingNewNewEquipmentWasDeleted(), " Equipment was not deleted");
    }
}
