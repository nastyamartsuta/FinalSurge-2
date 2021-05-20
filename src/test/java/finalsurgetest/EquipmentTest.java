package finalsurgetest;

import io.qameta.allure.Description;
import model.BikeModel;
import model.RoutesModel;
import model.ShoesModel;
import org.testng.annotations.Test;

public class EquipmentTest extends BaseTest {

    ShoesModel shoesModel = new ShoesModel();
    BikeModel bikeModel = new BikeModel();
    RoutesModel routesModel = new RoutesModel();

    @Test
    @Description(value = "Add new shoes test")
    public void addNewShoesTest() {
        initShoesModel();
        loginSteps
                .openLoginPage()
                .authentication();
        addShoesSteps
                .openShoesPage()
                .fillNewShoes(shoesModel)
                .saveNewShoes()
                .checkingShoesAdd(shoesModel);
    }

    @Test
    @Description(value = "Add new bike test")
    public void addNewBikeTest(){
        initBikeModel();
        loginSteps
                .openLoginPage()
                .authentication();
        addBikeSteps
                .openBikePage()
                .fillNewBike(bikeModel)
                .saveNewBike()
                .checkingBikeAdd(bikeModel);
    }

    @Test
    @Description(value = "Add new route test")
    public void addNewRouteTest(){
        initRouteModel();
        loginSteps
                .openLoginPage()
                .authentication();
        addRoutesSteps
                .openRoutesPage()
                .fillNewRoutes(routesModel)
                .saveNewRoutes()
                .checkingRotesAdd(routesModel);
    }

    private void initRouteModel() {
        routesModel = new RoutesModel();
        routesModel.setRouteName("Green Velo");
        routesModel.setDistance("200.00");
        routesModel.setRoutePersonalRecord("8:55:10");
        routesModel.setPersonalRecordDate("6/6/2021");
        routesModel.setNotes("Very beautiful route");
        routesModel.setDistanceType("km");
        routesModel.setActivity("Bike");
    }


    private void initBikeModel() {
        bikeModel = new BikeModel();
        bikeModel.setBikeName("City bike");
        bikeModel.setModel("slr03");
        bikeModel.setCost("1,250.00");
        bikeModel.setDatePurchased("5/5/2021");
        bikeModel.setStartingDistance("0.00");
        bikeModel.setNotes("Lack of rearview mirror");
        bikeModel.setBrand("BMC");
        bikeModel.setDistanceType("km");
    }

    private void initShoesModel() {
        shoesModel = new ShoesModel();
        shoesModel.setShoesName("Running shoes");
        shoesModel.setModel("Performance");
        shoesModel.setCost("99.00");
        shoesModel.setDatePurchased("5/5/2021");
        shoesModel.setStartingDistance("5");
        shoesModel.setDistanceAlert("15");
        shoesModel.setNotes("Don't run when it's raining");
        shoesModel.setShoeSize("7.5");
        shoesModel.setDistanceType("km");
        shoesModel.setDistanceAlertType("km");
    }
}

