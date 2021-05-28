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

    @Step
    public AddShoesSteps openShoesPage() {
        openEquipmentPage();
        shoesPage.openPage();
        validateComponentIsLoaded(shoesPage);
        return this;
    }

    @Step
    public AddShoesSteps fillNewShoes(ShoesModel shoesModel) {
        new Input(driver, "ShoeName").enterInput(shoesModel.getShoesName());
        new DropdownEquipment(driver, "s2id_ShoeBrand").select(shoesModel.getBrand());
        new Dropdown(driver, "ShoeSize").select(shoesModel.getShoeSize());
        new Dropdown(driver, "DistType").select(shoesModel.getDistanceType());
        new Dropdown(driver, "DistAlertType").select(shoesModel.getDistanceAlertType());
        new Input(driver, "ShoeModel").enterInput(shoesModel.getModel());
        new Input(driver, "ShoeCost").enterInput(shoesModel.getCost());
        new Input(driver, "ShoeDate").enterInput(shoesModel.getDatePurchased());
        new Input(driver, "StartDist").enterInput(shoesModel.getStartingDistance());
        new Input(driver, "DistAlert").enterInput(shoesModel.getDistanceAlert());
        new Input(driver, "ShoeNotes").enterInput(shoesModel.getNotes());
        return this;
    }

    @Step
    public AddShoesSteps saveNewShoes() {
        shoesPage.clickAddShoesButton();
        return this;
    }

    @Step
    public void checkingShoesAdd(ShoesModel shoesModel) {

        Assert.assertEquals(shoesPage.getActualShoesBrandModel(), shoesModel.getBrand() + " " + shoesModel.getModel(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesCost(), shoesModel.getCost(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesName(), shoesModel.getShoesName(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesSize(), shoesModel.getShoeSize(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesDatePurchased(), shoesModel.getDatePurchased(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesDistanceAlert(), shoesModel.getDistanceAlert(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesDistanceType(), shoesModel.getDistanceType(), "Incorrect text");
        Assert.assertEquals(shoesPage.getActualShoesNotes(), shoesModel.getNotes(), "Incorrect text");
    }
}
