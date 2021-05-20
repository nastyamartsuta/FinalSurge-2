package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class EquipmentPage extends BasePage {

    private static final By EQUIPMENT_BUTTON = By.xpath("//a[contains(.,'Gear & Routes')]");
    private static final By EQUIPMENT_HEADER = By.xpath("//h4[contains(.,'About Equipment')]/ancestor::div[@class='w-box-header']");

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
}