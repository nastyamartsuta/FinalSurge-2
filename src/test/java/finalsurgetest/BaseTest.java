package finalsurgetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginSteps loginSteps;
    protected AddWorkoutQuickSteps addWorkoutQuickSteps;
    protected HansonsSteps hansonsSteps;
    protected IntensitySteps intensitySteps;
    protected TinmanSteps tinmanSteps;
    protected CaloricNeedsOtherCalSteps caloricNeedsOtherCalSteps;
    protected PaceCalculatorOtherCalSteps paceCalculatorOtherCalSteps;
    protected ReportsSteps reportsSteps;
    protected PrintWorkoutsSteps printWorkoutsSteps;
    protected McMillanSteps mcMillanSteps;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSteps = new LoginSteps(driver);
        addWorkoutQuickSteps = new AddWorkoutQuickSteps(driver);
        hansonsSteps = new HansonsSteps(driver);
        caloricNeedsOtherCalSteps = new CaloricNeedsOtherCalSteps(driver);
        reportsSteps = new ReportsSteps(driver);
        printWorkoutsSteps = new PrintWorkoutsSteps(driver);
        paceCalculatorOtherCalSteps = new PaceCalculatorOtherCalSteps(driver);
        intensitySteps = new IntensitySteps(driver);
        tinmanSteps = new TinmanSteps(driver);
        mcMillanSteps = new McMillanSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
