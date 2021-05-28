package pages;

import com.fasterxml.jackson.core.JsonToken;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.StringUtils;

@Log4j2
public class HansonsPage extends BasePage {

    private static final By HANSONS_BUTTON = By.xpath("//a[@href='https://log.finalsurge.com/HansonsCalc.cshtml?c=1&ssl=1']");
    private static final By HEADER_HANSONS = By.xpath("//h4[contains(.,'HansonsPage Marathon Method Pace Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//div[@id='CalcBox']//input[@id='saveButtonSettings']");
    private static final By RECENT_RACE_INFORMATION_HEADER = By.xpath("//h4[contains(.,'Recent Race Information')]/ancestor::div[@class='w-box-header']");
    private static final By TRAINING_PACES_HEADER = By.xpath("//h4[contains(.,'Training Paces (Adjusted)')]/ancestor::div[@class='w-box-header']");
    private static final By EQUIVALENT_RACE_PERFORMANCES_HEADER = By.xpath("//h4[contains(.,'Equivalent Race Performances')]/ancestor::div[@class='w-box-header']");
    private static final By ACTUAL_INFORMATION = By.xpath("//div[@class='alert alert-info']");
    private static final By ACTUAL_TIME = By.xpath("//h4[contains(.,'Recent Race Information')]/ancestor::div[@class='w-box w-box-green']//tr//td[2]");
    private static final By ACTUAL_DISTANCE = By.xpath("//h4[contains(.,'Recent Race Information')]/ancestor::div[@class='w-box w-box-green']//tr//td[1]");

    public HansonsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the HansonsPage page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_HANSONS));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open HansonsPage page", HANSONS_BUTTON);
        driver.findElement(HANSONS_BUTTON).click();
    }

    public void clickCalculatePacesButton() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkCalculationsIsOpened() {
        log.info("Checking that the Recent race information was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(RECENT_RACE_INFORMATION_HEADER));
        log.info("Checking that the Training paces was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TRAINING_PACES_HEADER));
        log.info("Checking that the Equivalent race performances was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIVALENT_RACE_PERFORMANCES_HEADER));
        log.info("Checking that the Alert info was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(ACTUAL_INFORMATION));
        return true;
    }

    public String getActualTemperature() {
        log.info("Get the actual temperature");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);
        String firstLine = nodeText.split("\n")[0];
        String temperaturePrefix = firstLine.split(",")[0];
        String temperatureValue = temperaturePrefix.split(":")[1].trim();
        return temperatureValue.split(" ")[0].trim();
    }

    public String getActualTemperatureType() {
        log.info("Get the actual temperature type");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);
        String firstLine = nodeText.split("\n")[0];
        String temperaturePrefix = firstLine.split(",")[0];
        String temperatureValueType = temperaturePrefix.split(":")[1].trim();
        return temperatureValueType.split(" ")[1].trim();
    }

    public String getActualHumidity() {
        log.info("Get the actual humidity");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);
        String firstLine = nodeText.split("\n")[0];
        String humidityPrefix = firstLine.split(",")[1];
        String humidityValue = humidityPrefix.split(":")[1].trim();
        return humidityValue.substring(0, humidityValue.length() - 1).trim();
    }

    public String getActualWindySpeed() {
        log.info("Get the actual windy speed");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_INFORMATION);
        String firstLine = nodeText.split("\n")[0];
        String windyPrefix = firstLine.split(",")[2];
        String windyValue = windyPrefix.split(":")[1].trim();
        return windyValue.split(" ")[0].trim();
    }

    public String getActualDistance() {
        log.info("Get the actual distance");
        WebElement element = driver.findElement(ACTUAL_DISTANCE);
        return element.getText();
    }

    public String getActualHours() {
        log.info("Get the actual hours");
        WebElement element = driver.findElement(ACTUAL_TIME);
        return element.getText().split(":")[0];
    }

    public String getActualMinutes() {
        log.info("Get the actual minutes");
        WebElement element = driver.findElement(ACTUAL_TIME);
        return element.getText().split(":")[1];
    }

    public String getActualSeconds() {
        log.info("Get the actual windy spped type");
        WebElement element = driver.findElement(ACTUAL_TIME);
        return element.getText().split(":")[2];
    }
}