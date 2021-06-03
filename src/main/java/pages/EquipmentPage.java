package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

@Log4j2
public class EquipmentPage extends BasePage {

    private static final By EQUIPMENT_BUTTON = By.xpath("//a[contains(.,'Gear & Routes')]");
    private static final By EQUIPMENT_HEADER = By.xpath("//h4[contains(.,'About Equipment')]/ancestor::div[@class='w-box-header']");
    private static final By EDIT_BUTTON = By.xpath("//a[@class='btn btn-mini']");
    private static final By DELETE_BUTTON = By.xpath("//a[@class='btn btn-mini']//i[@class='icon-trash']");
    private static final By OK_BUTTON = By.xpath("//a[@class='btn btn-primary']");
    private static final By HEADER_NEW_EQUIPMENT = By.xpath("//table[@class='table']");

    public EquipmentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Equipment page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIPMENT_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Equipment page", EQUIPMENT_BUTTON);
        driver.findElement(EQUIPMENT_BUTTON).click();
    }

    public void deleteNewEquipment() {
        log.info("Click {} in order to edit new Equipment", EDIT_BUTTON);
        driver.findElement(EDIT_BUTTON).click();
        log.info("Click {} in order to delete new Equipment", DELETE_BUTTON);
        driver.findElement(DELETE_BUTTON).click();
        log.info("Scroll to the top");
        DriverUtils.scrollToTop(driver);
        log.info("Click {} in order to confirm delete new Equipment", OK_BUTTON);
        explicitlyWait.until(ExpectedConditions.visibilityOf(driver.findElement(OK_BUTTON))).click();
    }

    public boolean checkingNewNewEquipmentWasDeleted() {
        log.info("Checking new Equipment was deleted");
        explicitlyWait.until(ExpectedConditions.invisibilityOfElementLocated(HEADER_NEW_EQUIPMENT));
        return true;
    }
}