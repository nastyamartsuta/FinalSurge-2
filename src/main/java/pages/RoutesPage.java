package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RoutesPage extends BasePage {

    private static final By EQUIPMENT_BUTTON = By.xpath("//a[contains(.,'Gear & Routes')]");
    private static final By EQUIPMENT_ROUTES_BUTTON = By.xpath("//div[@id='fade-menu']//a[text()='Routes']");
    private static final By EQUIPMENT_ROUTS_HEADER = By.xpath("//h4[contains(.,'Current Routes')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_ROUTE_BUTTON = By.id("saveButton");
    private static final By ACTUAL_INFORMATION = By.xpath("//table[@class='table']//td[1]");

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
        log.info("Move to {}",EQUIPMENT_BUTTON );
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

    public String getActualText() {
        log.info("Get the actual text");
        WebElement element = driver.findElement(ACTUAL_INFORMATION);
        return element.getText();
    }
}