package pages;

import elements.DropdownSelectByVisibleText;
import lombok.extern.log4j.Log4j2;
import model.VitalsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class DailyVitalsPage extends BasePage {

    private static final By DAILY_VITALS_BUTTON = By.xpath("//a[contains(.,'Daily Vitals')]");
    private static final By DAILY_VITALS_HEADER = By.xpath("//h4[contains(.,'Daily Vitals')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_VITALS_BUTTON = By.xpath("//button[contains(.,'Add Vitals')]");
    private static final By DAILY_VITALS_ADD_HEADER = By.xpath("//h4[contains(.,'Daily Vitals Add')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_NEW_VITALS_BUTTON =  By.id("saveButton");
    private static final String ACTUAL_INFORMATION = "//a[contains(.,'%s')]/ancestor::tr";

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Daily Vitals page has open");
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
        log.info("Checking that the daily vitals add panel has open");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DAILY_VITALS_ADD_HEADER));
    }

    public void clickAddVitalsButton() {
        log.info("Click {} in order to add new Vitals", SAVE_NEW_VITALS_BUTTON);
        driver.findElement(SAVE_NEW_VITALS_BUTTON).click();
    }

    public String getActualText(VitalsModel vitalsModel) {
        WebElement element = driver.findElement(By.xpath(String.format(ACTUAL_INFORMATION, vitalsModel.getVitalsDate())));
        return element.getText();
    }


    public void showLastMonthVitals() {
        log.info("View Last month vitals");
        new DropdownSelectByVisibleText(driver, "PastDays").select("Last Month");
    }
/*
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, 4);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date monthStart = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date monthEnd = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(calendar);

        System.out.println("Calculated month start date : " + format.format(monthStart));
        System.out.println("Calculated month end date : " + format.format(monthEnd));
    }


    public void checkLastMonthIsOpen(){

        //TODO как проверить что правильно открылось
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

    }*/


}
