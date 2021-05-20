package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class BikePage extends BasePage {

    private static final By EQUIPMENT_SHOES_BUTTON = By.xpath("//div[@class='w-box-content']//a[contains(.,'Bikes')]");
    private static final By EQUIPMENT_SHOES_HEADER = By.xpath("//h4[contains(.,'Current Bikes')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_BIKE_BUTTON = By.id("saveButton");
    private static final By ACTUAL_INFORMATION = By.xpath("//table[@class='table']//td[2]");

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

    public String getActualText() {
        WebElement element = driver.findElement(ACTUAL_INFORMATION);
        return element.getText();
    }
}
