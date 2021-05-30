package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.StringUtils;

@Log4j2
public class BikePage extends BasePage {

    private static final By EQUIPMENT_SHOES_BUTTON = By.xpath("//div[@class='w-box-content']//a[contains(.,'Bikes')]");
    private static final By EQUIPMENT_SHOES_HEADER = By.xpath("//h4[contains(.,'Current Bikes')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_BIKE_BUTTON = By.id("saveButton");
    private static final By ACTUAL_INFORMATION = By.xpath("//table[@class='table']//td[2]");
    private static final By ACTUAL_BIKE_NAME = By.xpath("//table[@class='table']//td[2]/strong/a");
    private static final By ACTUAL_BIKE_DATE_PURCHASED = By.xpath("//table[@class='table']//td[2]/span[@class='label'][1]");
    private static final By ACTUAL_BIKE_COST = By.xpath("//table[@class='table']//td[2]/span[@class='label'][2]");

    public BikePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Bike page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIPMENT_SHOES_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Bike page", EQUIPMENT_SHOES_BUTTON);
        driver.findElement(EQUIPMENT_SHOES_BUTTON).click();
    }

    public void clickAddBikeButton() {
        log.info("Click {} in order to add a new Bike", ADD_BIKE_BUTTON);
        driver.findElement(ADD_BIKE_BUTTON).click();
    }

    public String getActualBikeName() {
        log.info("Get the actual bike name");
        WebElement element = driver.findElement(ACTUAL_BIKE_NAME);
        return element.getText().trim();
    }

    public String getActualBikeBrandModel() {
        log.info("Get the actual bike brand and model");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);
        String firstLine = nodeText.split("\n")[0].trim();

        return firstLine.substring(1, firstLine.length() - 1);
    }

    public String getActualBikeDatePurchased() {
        log.info("Get the actual bike data purchased");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_BIKE_DATE_PURCHASED);

        return nodeText.trim();
    }

    public String getActualBikeCost() {
        log.info("Get the actual bike cost");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_BIKE_COST);

        return nodeText.substring(1).trim();
    }

    public String getActualBikeNotes() {
        log.info("Get the actual bike notes");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);

        return nodeText.split("\n")[3].trim();
    }
}
