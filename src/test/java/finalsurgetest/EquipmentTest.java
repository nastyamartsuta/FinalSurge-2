package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class EquipmentTest extends WithLoginTest {

    @Test
    @Description(value = "Add new shoes test")
    public void addNewShoesTest() {
        addShoesSteps
                .openShoesPage()
                .fillNewShoes()
                .saveNewShoes()
                .checkingShoesAdd()
                .deleteNewShoes();
    }

    @Test
    @Description(value = "Add new bike test")
    public void addNewBikeTest() {
        addBikeSteps
                .openBikePage()
                .fillNewBike()
                .saveNewBike()
                .checkingBikeAdd()
                .deleteNewBike();
    }

    @Test
    @Description(value = "Add new route test")
    public void addNewRouteTest() {
        addRoutesSteps
                .openRoutesPage()
                .fillNewRoutes()
                .saveNewRoutes()
                .checkingRotesAdd()
                .deleteNewRoutes();
    }
}

