package pages;

import elements.DropdownSelectByVisibleText;
import lombok.extern.log4j.Log4j2;
import model.VitalsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Log4j2
public class DailyVitalsPage extends BasePage {

    private static final By DAILY_VITALS_BUTTON = By.xpath("//a[contains(.,'Daily Vitals')]");
    private static final By DAILY_VITALS_HEADER = By.xpath("//h4[contains(.,'Daily Vitals')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_VITALS_BUTTON = By.xpath("//button[contains(.,'Add Vitals')]");
    private static final By DAILY_VITALS_ADD_HEADER = By.xpath("//h4[contains(.,'Daily Vitals Add')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_NEW_VITALS_BUTTON = By.id("saveButton");
    private static final By ACTUAL_START_DATE = By.xpath("//div[@class='w-box-content table-responsive']//tr[(last())-1]/td");
    private static final By ACTUAL_END_DATE = By.xpath("//div[@class='w-box-content table-responsive']//tr/td[1]");
    private static final String PAST_DAYS = "PastDays";
    private static final String LAST_MONTH = "Last Month";
    private static final String THIS_YEAR = "This Year";
    private static final String DATE_FORMAT = "M/d/yyyy";
    private static final String ACTUAL_DATA = "//a[contains(.,'%s')]/ancestor::tr/td/a";
    private static final String ACTUAL_STEPS = "//a[contains(.,'%s')]/ancestor::tr/td[2]";
    private static final String ACTUAL_WEIGHT = "//a[contains(.,'%s')]/ancestor::tr/td[3]";
    private static final String ACTUAL_BODY_FAT = "//a[contains(.,'%s')]/ancestor::tr/td[4]";
    private static final String ACTUAL_RESTING_HR = "//a[contains(.,'%s')]/ancestor::tr/td[5]";
    private static final String ACTUAL_HRV = "//a[contains(.,'%s')]/ancestor::tr/td[6]";
    private static final String ACTUAL_CALORIES = "//a[contains(.,'%s')]/ancestor::tr/td[7]";
    private static final String ACTUAL_WATER = "//a[contains(.,'%s')]/ancestor::tr/td[8]";
    private static final String ACTUAL_MUSCLE_MASS = "//a[contains(.,'%s')]/ancestor::tr/td[9]";
    private static final String ACTUAL_SLEEP = "//a[contains(.,'%s')]/ancestor::tr/td[10]";
    private static final String ACTUAL_AWAKE = "//a[contains(.,'%s')]/ancestor::tr/td[11]";
    private static final String ACTUAL_AMOUNT = "//a[contains(.,'%s')]/ancestor::tr/td[12]";
    private static final String ACTUAL_QUALITY = "//a[contains(.,'%s')]/ancestor::tr/td[13]";
    private static final String ACTUAL_STRESS = "//a[contains(.,'%s')]/ancestor::tr/td[14]";
    private static final String ACTUAL_BLOOD_PRESSURE = "//a[contains(.,'%s')]/ancestor::tr/td[15]";
    private static final String ACTUAL_NOTES = "//a[contains(.,'%s')]/ancestor::tr/td[16]";

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Daily Vitals page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DAILY_VITALS_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Daily Vitals page", DAILY_VITALS_BUTTON);
        driver.findElement(DAILY_VITALS_BUTTON).click();
    }

    public void openDailyVitalsAddPanel() {
        log.info("Click {} in order to open daily vitals add panel", ADD_VITALS_BUTTON);
        driver.findElement(ADD_VITALS_BUTTON).click();
        log.info("Checking that the daily vitals add panel was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DAILY_VITALS_ADD_HEADER));
    }

    public void clickAddVitalsButton() {
        log.info("Click {} in order to add a new Vitals", SAVE_NEW_VITALS_BUTTON);
        driver.findElement(SAVE_NEW_VITALS_BUTTON).click();
    }

    public String getActualDailyVitalsData() {
        log.info("Get the actual daily vitals data");
        String element = getElementText(ACTUAL_DATA, VitalsModel.vitalsDate);
        return element.trim();
    }

    public String getActualDailyVitalsSteps() {
        log.info("Get the actual daily vitals steps");
        String element = getElementText(ACTUAL_STEPS, VitalsModel.vitalsDate);
        return element.trim();
    }

    public String getActualDailyVitalsWeight() {
        log.info("Get the actual daily vitals weight");
        String element = getElementText(ACTUAL_WEIGHT, VitalsModel.vitalsDate);
        return element.trim().split(" ")[0].trim();
    }

    public String getActualDailyVitalsWeightType() {
        log.info("Get the actual daily vitals weight type");
        String element = getElementText(ACTUAL_WEIGHT, VitalsModel.vitalsDate);
        return element.trim().split(" ")[1].trim();
    }

    public String getActualDailyVitalsBodyFat() {
        log.info("Get the actual daily vitals body fat");
        String element = getElementText(ACTUAL_BODY_FAT, VitalsModel.vitalsDate).trim();
        return element.substring(0, element.length() - 1).trim();
    }

    public String getActualDailyVitalsResting() {
        log.info("Get the actual daily vitals resting");
        String element = getElementText(ACTUAL_RESTING_HR, VitalsModel.vitalsDate).trim();
        return element.split(" ")[0].trim();
    }

    public String getActualDailyVitalsHRV() {
        log.info("Get the actual daily vitals HRV");
        return getElementText(ACTUAL_HRV, VitalsModel.vitalsDate).trim();
    }

    public String getActualDailyVitalsCalories() {
        log.info("Get the actual daily vitals calories");
        String element = getElementText(ACTUAL_CALORIES, VitalsModel.vitalsDate).trim();
        return element.split(" ")[0].trim();
    }

    public String getActualDailyVitalsWater() {
        log.info("Get the actual daily vitals water");
        String element = getElementText(ACTUAL_WATER, VitalsModel.vitalsDate).trim();
        return element.substring(0, element.length() - 1).trim();
    }

    public String getActualDailyVitalsMuscleMass() {
        log.info("Get the actual daily vitals muscle mass");
        String element = getElementText(ACTUAL_MUSCLE_MASS, VitalsModel.vitalsDate).trim();
        return element.split(" ")[0].trim();
    }

    public String getActualDailyVitalsMuscleMassType() {
        log.info("Get the actual daily vitals muscle mass type");
        String element = getElementText(ACTUAL_MUSCLE_MASS, VitalsModel.vitalsDate).trim();
        return element.split(" ")[1].trim();
    }

    public String getActualDailyVitalsSleep() {
        log.info("Get the actual daily vitals sleep");
        String element = getElementText(ACTUAL_SLEEP, VitalsModel.vitalsDate).trim();
        return element.split(" ")[0].trim();
    }

    public String getActualDailyVitalsAwake() {
        log.info("Get the actual daily vitals awake");
        String element = getElementText(ACTUAL_AWAKE, VitalsModel.vitalsDate).trim();
        return element.split(" ")[0].trim();
    }

    public String getActualDailyVitalsSleepAmount() {
        log.info("Get the actual daily vitals amount");
        return getElementText(ACTUAL_AMOUNT, VitalsModel.vitalsDate).trim();
    }

    public String getActualDailyVitalsSleepQuality() {
        log.info("Get the actual daily vitals quality");
        return getElementText(ACTUAL_QUALITY, VitalsModel.vitalsDate).trim();
    }

    public String getActualDailyVitalsStress() {
        log.info("Get the actual daily vitals stress");
        return getElementText(ACTUAL_STRESS, VitalsModel.vitalsDate).trim();
    }

    public String getActualDailyVitalsBloodPressureSystolic() {
        log.info("Get the actual daily vitals blood pressure systolic");
        String element = getElementText(ACTUAL_BLOOD_PRESSURE, VitalsModel.vitalsDate).trim();
        return element.split("/")[0].trim();
    }

    public String getActualDailyVitalsBloodPressureDiastolic() {
        log.info("Get the actual daily vitals blood pressure diastolic");
        String bloodPr = getElementText(ACTUAL_BLOOD_PRESSURE, VitalsModel.vitalsDate).trim();
        String diastolic = bloodPr.split("/")[1].trim();
        return diastolic.split(" ")[0].trim();
    }

    public String getActualDailyVitalsNotes() {
        log.info("Get the actual daily vitals notes");
        return getElementText(ACTUAL_NOTES, VitalsModel.vitalsDate).trim();
    }

    public void showLastMonthVitals() {
        log.info("View Last month vitals");
        new DropdownSelectByVisibleText(driver, PAST_DAYS).select(LAST_MONTH);
    }

    public void showThisYearVitals() {
        log.info("View this year vitals");
        new DropdownSelectByVisibleText(driver, PAST_DAYS).select(THIS_YEAR);
    }

    public ArrayList<String> expectedDates() {
        log.info("Expected data");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate prevMonthLocalDate = LocalDate
                .now()
                .minusMonths(1);
        String prevMonthStartDate = prevMonthLocalDate
                .withDayOfMonth(1)
                .format(formatter);
        String prevMonthEndDate = prevMonthLocalDate
                .withDayOfMonth(prevMonthLocalDate.lengthOfMonth())
                .format(formatter);

        ArrayList<String> dates = new ArrayList<>();
        dates.add(prevMonthStartDate);
        dates.add(prevMonthEndDate);
        return dates;
    }

    public ArrayList<WebElement> actualDates() {
        log.info("Find actual data");
        WebElement startDate = driver.findElement(ACTUAL_START_DATE);
        WebElement endDate = driver.findElement(ACTUAL_END_DATE);
        ArrayList<WebElement> actualDates = new ArrayList<>();
        actualDates.add(startDate);
        actualDates.add(endDate);
        return actualDates;
    }

    private String getElementText(String locator, String vitalsDate) {
        log.info("Find element");

        WebElement element = driver.findElement(By.xpath(String.format(locator, vitalsDate)));
        return element.getText();
    }
}
