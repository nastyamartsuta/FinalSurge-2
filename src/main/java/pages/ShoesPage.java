package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.StringUtils;

@Log4j2
public class ShoesPage extends BasePage {

    private static final By EQUIPMENT_SHOES_BUTTON = By.xpath("//div[@class='w-box-content']//a[contains(.,'Shoes')]");
    private static final By EQUIPMENT_SHOES_HEADER = By.xpath("//h4[contains(.,'Current Shoes')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_SHOES_BUTTON = By.id("saveButton");
    private static final By ACTUAL_INFORMATION = By.xpath("//table[@class='table']//td[2]");
    private static final By ACTUAL_SHOES_NAME = By.xpath("//table[@class='table']//td[2]/strong");
    private static final By ACTUAL_SHOES_DATE_PURCHASED = By.xpath("//table[@class='table']//td[2]/span[@class='label'][1]");
    private static final By ACTUAL_SHOES_COST = By.xpath("//table[@class='table']//td[2]/span[@class='label'][2]");
    private static final By ACTUAL_SHOES_SIZE = By.xpath("//table[@class='table']//td[2]/span[@class='label'][3]");
    private static final By ACTUAL_DISTANCE_ALERT = By.xpath("//table[@class='table']//td[2]/span[4]");

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Shoes page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIPMENT_SHOES_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Shoes page", EQUIPMENT_SHOES_BUTTON);
        driver.findElement(EQUIPMENT_SHOES_BUTTON).click();
    }

    public void clickAddShoesButton() {
        log.info("Click {} in order to add new Shoes", ADD_SHOES_BUTTON);
        driver.findElement(ADD_SHOES_BUTTON).click();
    }

    public String getActualShoesName() {
        log.info("Get the actual shoes name");
        WebElement element = driver.findElement(ACTUAL_SHOES_NAME);
        return element.getText().trim();
    }

    public String getActualShoesBrandModel() {
        log.info("Get the actual shoes brand and model");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);
        String firstLine = nodeText.split("\n")[0].trim();

        return firstLine.substring(1, firstLine.length() - 1);
    }

    public String getActualShoesDatePurchased() {
        log.info("Get the actual shoes data purchased");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_SHOES_DATE_PURCHASED);

        return nodeText.trim();
    }

    public String getActualShoesCost() {
        log.info("Get the actual shoes cost");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_SHOES_COST);

        return nodeText.substring(1).trim();
    }

    public String getActualShoesSize() {
        log.info("Get the actual shoes size");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_SHOES_SIZE);

        return nodeText.trim();
    }

    public String getActualShoesDistanceAlert() {
        log.info("Get the actual shoes size");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_DISTANCE_ALERT);

        return nodeText.split(":")[1].trim().split(" ")[0];
    }

    public String getActualShoesDistanceType() {
        log.info("Get the actual shoes size");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_DISTANCE_ALERT);

        return nodeText.split(":")[1].trim().split(" ")[1];
    }

    public String getActualShoesNotes() {
        log.info("Get the actual shoes notes");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);

        return nodeText.split("\n")[2].trim();
    }
}