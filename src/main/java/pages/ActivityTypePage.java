package pages;

import lombok.extern.log4j.Log4j2;
import model.ActivityTypeModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ActivityTypePage extends BasePage {

    private static final By WORKOUTS_BUTTON = By.xpath("//a[contains(.,'Workouts')]");
    private static final By CUSTOMIZE_ACTIVITY_TYPE_BUTTON = By.xpath("//div[@id='fade-menu']//a[text()='Customize Activity Types']");
    private static final By ADD_ACTIVITY_TYPE_HEADER = By.xpath("//h4[contains(.,'Add New Activity Type')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_ACTIVITY_TYPE_BUTTON = By.id("saveButton");
    private static final String ADDED_NEW_ACTIVITY_TYPE = "//h4[contains(.,'%s')]/ancestor::div[@class='w-box-header']";


    public ActivityTypePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the ActivityType page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_ACTIVITY_TYPE_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Move to {}", WORKOUTS_BUTTON);
        new Actions(driver)
                .moveToElement(driver.findElement(WORKOUTS_BUTTON))
                .perform();
        log.info("Click {} in order to open Activity Type page", CUSTOMIZE_ACTIVITY_TYPE_BUTTON);
        driver.findElement(CUSTOMIZE_ACTIVITY_TYPE_BUTTON).click();
    }

    public void clickAddActivityTypeButton() {
        log.info("Click {} in order to add a new activity type", ADD_ACTIVITY_TYPE_BUTTON);
        driver.findElement(ADD_ACTIVITY_TYPE_BUTTON).click();
    }

    public boolean getTypeAdded(ActivityTypeModel activityTypeModel) {
        log.info("Check that the new type was added");
        driver.findElement(By.xpath(String.format(ADDED_NEW_ACTIVITY_TYPE, activityTypeModel.getATypeName())));
        return true;
    }
}


