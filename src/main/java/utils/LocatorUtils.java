package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorUtils {

    public static WebElement createByXpath(WebDriver driver, String xpathLocatorPattern, String label) {
        return driver.findElement(By.xpath(StringUtils.format(xpathLocatorPattern, label)));
    }
    public static WebElement createById(WebDriver driver, String idLocatorPattern, String label) {
        return driver.findElement(By.id(StringUtils.format(idLocatorPattern, label)));
    }

}
