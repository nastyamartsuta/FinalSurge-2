package finalsurgetest;

import io.qameta.allure.Description;

import model.CaloricNeedsModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends BaseTest {

    CaloricNeedsModel caloricNeedsModel = new CaloricNeedsModel();


    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        initCaloricNeedsModel();
    }

    @Test
    @Description(value = "Calculate Training Pace test")
    public void calculateNeedsTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        otherCalculatorSteps
                .openOtherCalculatorPage()
                .openCaloricNeeds()
                .fillCaloricNeeds(caloricNeedsModel)
                .saveCalculateCaloricNeeds()
                .checkCalculation();

    }

    private void initCaloricNeedsModel() {
        caloricNeedsModel = new CaloricNeedsModel();
        //input
        caloricNeedsModel.setWeight("60");
        caloricNeedsModel.setHeight("180");
        caloricNeedsModel.setAge("25");
        caloricNeedsModel.setRunDistance("5");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}
