package finalsurgetest;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

import java.util.concurrent.TimeUnit;

@Log4j2
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
    protected AddShoesSteps addShoesSteps;
    protected AddBikeSteps addBikeSteps;
    protected AddRoutesSteps addRoutesSteps;
    protected ViewDailyVitalsSteps viewVitalsSteps;
    protected AddDailyVitalsSteps addVitalsSteps;
    protected OpenWorkoutsLibrarySteps openWorkoutLibrarySteps;
    protected AddWorkoutSteps addWorkoutSteps;
    protected AddNewActivityTypeSteps addNewActivityTypeSteps;
    protected UploadWorkoutDataSteps uploadWorkoutDataSteps;
    protected DeleteWorkoutSteps deleteWorkoutSteps;
    protected ViewWorkoutDetailsStep viewWorkoutDetailsStep;
    protected AddCommentsStep commentsStep;
    protected MoveWorkoutSteps moveWorkoutSteps;

    @BeforeMethod
    public void setup() {
        log.info("Driver initialization");
        System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920x1080");

        driver = new ChromeDriver(options);
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
        addShoesSteps = new AddShoesSteps(driver);
        addBikeSteps = new AddBikeSteps(driver);
        addRoutesSteps = new AddRoutesSteps(driver);
        viewVitalsSteps = new ViewDailyVitalsSteps(driver);
        addVitalsSteps = new AddDailyVitalsSteps(driver);
        openWorkoutLibrarySteps = new OpenWorkoutsLibrarySteps(driver);
        addWorkoutSteps = new AddWorkoutSteps(driver);
        addNewActivityTypeSteps = new AddNewActivityTypeSteps(driver);
        uploadWorkoutDataSteps = new UploadWorkoutDataSteps(driver);
        deleteWorkoutSteps = new DeleteWorkoutSteps(driver);
        viewWorkoutDetailsStep = new ViewWorkoutDetailsStep(driver);
        commentsStep = new AddCommentsStep(driver);
        moveWorkoutSteps = new MoveWorkoutSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        log.info("Quit from driver");
        driver.quit();
    }
}
