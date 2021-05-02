package finalsurgetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CalendarPage;
import steps.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginSteps loginSteps;
    protected AddWorkoutQuickSteps addWorkoutQuickSteps;
    protected CalculatorSteps calculatorSteps;
    protected OtherCalculatorSteps otherCalculatorSteps;
    protected ReportsSteps reportsSteps;
    protected PrintWorkoutsSteps printWorkoutsSteps;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSteps = new LoginSteps(driver);
        addWorkoutQuickSteps = new AddWorkoutQuickSteps(driver);
        calculatorSteps = new CalculatorSteps(driver);
        otherCalculatorSteps = new OtherCalculatorSteps(driver);
        reportsSteps = new ReportsSteps(driver);
        printWorkoutsSteps = new PrintWorkoutsSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
