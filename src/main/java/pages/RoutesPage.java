package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.StringUtils;

@Log4j2
public class RoutesPage extends BasePage {

    private static final By EQUIPMENT_BUTTON = By.xpath("//a[contains(.,'Gear & Routes')]");
    private static final By EQUIPMENT_ROUTES_BUTTON = By.xpath("//div[@id='fade-menu']//a[text()='Routes']");
    private static final By EQUIPMENT_ROUTS_HEADER = By.xpath("//h4[contains(.,'Current Routes')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_ROUTE_BUTTON = By.id("saveButton");
    private static final By ACTUAL_ROUTES_NOTES = By.xpath("//table[@class='table']//td[1]");
    private static final By ACTUAL_ROUTES_NAME = By.xpath("//table[@class='table']//td[1]//strong");
    private static final By ACTUAL_ROUTES_ACTIVITY = By.xpath("//span[@class='label label-inverse']");
    private static final By ACTUAL_ROUTES_DATE_TIME = By.xpath("//table[@class='table']//span[2]");
    private static final By ACTUAL_ROUTES_DISTANCE = By.xpath("//table[@class='table']//td[2]/span");

    public RoutesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Routes page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIPMENT_ROUTS_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Move to {}", EQUIPMENT_BUTTON);
        new Actions(driver)
                .moveToElement(driver.findElement(EQUIPMENT_BUTTON))
                .perform();
        log.info("Click {} in order to open Routes page", EQUIPMENT_ROUTES_BUTTON);
        driver.findElement(EQUIPMENT_ROUTES_BUTTON).click();
    }

    public void clickAddRoutesButton() {
        log.info("Click {} in order to add a new Routes", ADD_ROUTE_BUTTON);
        driver.findElement(ADD_ROUTE_BUTTON).click();
    }

    public String getActualRoutesNotes() {
        log.info("Get the actual notes");
        return StringUtils.getWebElementText(driver, ACTUAL_ROUTES_NOTES);
    }

    public String getActualRoutesName() {
        log.info("Get the actual routes name");
        WebElement element = driver.findElement(ACTUAL_ROUTES_NAME);
        return element.getText().trim();
    }

    public String getActualRoutesActivity() {
        log.info("Get the actual routes activity");
        WebElement element = driver.findElement(ACTUAL_ROUTES_ACTIVITY);
        return element.getText().trim();
    }

    public String getActualRoutesTime() {
        log.info("Get the actual routes time");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_ROUTES_DATE_TIME);
        return nodeText.split("of")[1].split("on")[0].trim();
    }

    public String getActualRoutesData() {
        log.info("Get the actual routes data");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_ROUTES_DATE_TIME);
        return nodeText.split("of")[1].split("on")[1].trim();
    }

    public String getActualRoutesDistance() {
        log.info("Get the actual routes distance");
        WebElement element = driver.findElement(ACTUAL_ROUTES_DISTANCE);
        return element.getText().split(" ")[0].trim();
    }

    public String getActualRoutesDistanceType() {
        log.info("Get the actual routes distance type");
        WebElement element = driver.findElement(ACTUAL_ROUTES_DISTANCE);
        return element.getText().split(" ")[1].trim();
    }
}