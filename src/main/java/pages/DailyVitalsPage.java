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
    private static final By SAVE_NEW_VITALS_BUTTON =  By.id("saveButton");
    private static final String ACTUAL_INFORMATION = "//a[contains(.,'%s')]/ancestor::tr";
    private static final By ACTUAL_START_DATE = By.xpath("//div[@class='w-box-content table-responsive']//tr[(last())]/td");
    private static final By ACTUAL_END_DATE = By.xpath("//div[@class='w-box-content table-responsive']//tr/td[1]");
    private static final String PAST_DAYS = "PastDays";
    private static final String LAST_MONTH = "Last Month";
    private static final String DATE_FORMAT ="M/d/yyyy" ;

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

    public String getActualText(VitalsModel vitalsModel) {
        WebElement element = driver.findElement(By.xpath(String.format(ACTUAL_INFORMATION, vitalsModel.getVitalsDate())));
        return element.getText();
    }


    public void showLastMonthVitals() {
        log.info("View Last month vitals");
        new DropdownSelectByVisibleText(driver, PAST_DAYS).select(LAST_MONTH);
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

    public  ArrayList<WebElement> actualDates() {
        log.info("Find actual data");
        WebElement startDate = driver.findElement(ACTUAL_START_DATE);
        WebElement endDate = driver.findElement(ACTUAL_END_DATE);
        ArrayList<WebElement> actualDates = new ArrayList<>();
        actualDates.add(startDate);
        actualDates.add(endDate);
        return actualDates;
   }
}
