package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class InputNewWorkoutQuick extends AbstractComponent {

    private static final String INPUT_PATTERN = "//label[@for='%s']/ancestor::div/input[@id='%s']";
    private String label;

    public InputNewWorkoutQuick(WebDriver driver, String labelOne, String labelTwo) {
        super(driver);
        this.label = labelOne;
        this.label = labelTwo;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(INPUT_PATTERN, label, label));
    }

    public void enterInput(String text) {
        log.info("Send text to input {} ", label);
        driver.findElement(locator()).sendKeys(text);
    }
    public void clear() {
        driver.findElement(locator()).clear();
    }
}
